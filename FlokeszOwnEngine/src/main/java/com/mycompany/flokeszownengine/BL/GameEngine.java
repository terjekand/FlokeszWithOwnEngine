package com.mycompany.flokeszownengine.BL;
/*
 * Copyright 2018 Kiss Dávid.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.mycompany.flokeszownengine.DB.DataBase;
import com.mycompany.flokeszownengine.DB.JPAEntity;
import com.mycompany.flokeszownengine.UI.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.extern.slf4j.Slf4j;
/**
 *
 * @author kiss
 */
@Slf4j
public class GameEngine {
    
    /**
     * Az adatbazis kezelo peldanyositasa.
     */
    private static final DataBase DB = DataBase.getDbPeldany();
    /**
     * JPA entitas letrehozasa.
     */
    private JPAEntity flokeszEntity;
    
    /**
     * A jatek inditasanak ideje.
     */
    long startNanoTime;
    /**
     * Az elso palya letrehozasa.
     */
    Stage1 stage1;
    /**
     * A billenttyuzet kezelesert felelos objektum letrehozasa.
     */
    Input input;
    /**
     * A megjelenito ablak letrehozasa.
     */
    Window ablak;
    /**
     * A fo karakterunk letrehozasa.
     */
    public Character flokesz;
    /**
     * A GameEngine osztaly konstruktora.
     * Stage1 -> peldanyositasa.
     * flokesz -> peldanyositas.
     * ablak -> peldanyositasa.
     * startNanoTime -> a letrehozas idopontja.
     * input -> peldanyositas.
     * billentyuzet kezeles beallitasa.
     */
    public GameEngine() throws Exception{
        int HighScore = DB.getAllOrderedByScore().get(0).getScore();
        stage1 = new Stage1();
        flokesz = new Character();
        ablak = new Window(this);
        ablak.getHpBox().setText("" + HighScore);
        startNanoTime = System.nanoTime();
        input = new Input(flokesz);
        ablak.getScene().setOnKeyPressed(input.keyEventHandler);
        log.trace("GameEngine constructor");
    }
    /**
    * Vissza adja az inputer felelos objektumot a jatekhoz.
    * @return   a jatekmotorhoz tartozo input
    */
    public Input getInput() {
        return input;
    }
    /**
    * A jatek magja.
    * Ezzel indul el a jatek, a benne talalhato AnimationTimer felelos a folyamatos futasert.
    * Minden futas kozben torteno fuggoseg itt lesz levizsgalva. 
    */
    public void MainLoop(){
        log.trace("GameEngine MainLoop -> Called");
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                if(flokesz.getHp() > 0){
                    flokesz.update();
                ablak.update(flokesz);
                ablak.getScene().setOnKeyPressed(input.keyEventHandler);
                ablak.getScene().setOnKeyReleased(input.keyEventHandler);
                flokesz.rest = true;
                if(flokesz.getPass()){
                    ablak.setView(stage1.getImage());
                    flokesz.setPass(false);
                    log.trace("Passed section: Character.pass = false");
                    stage1.setRun(true);
                    log.trace("Passed section: Set stage1.run = true");
                    ablak.getBg().getChildren().add(stage1.getBear().getView());
                    log.trace("Passed section: Add Bear ImageView to scene");
                    ablak.getBg().getChildren().add(ablak.getScoreBox());
                    log.trace("Passed section: Add scorebox to scene");
                    ablak.getScoreBox().setText("0");
                    ablak.getScoreBox().setTextFill(Color.WHITE);
                    ablak.getScoreBox().setFont(Font.font ("Verdana", 40));
                    log.trace("Character Passed -> Stage1 Initialized");
                }
                if(stage1.getRun()){
                        if(flokesz.getBacked() > 0){
                            ablak.getHpBox().setText("" + flokesz.getHp());
                            log.trace("Character Hp Box Updated");
                            
                        }
                            
                        if(stage1.getBear().getHealth() <= 0){
                            ablak.getBg().getChildren().remove(stage1.getBear().getView());
                            stage1.initBear();
                            log.trace("Run section: Init Bear");
                            ablak.getBg().getChildren().add(stage1.getBear().getView());
                            flokesz.incKillCount();
                            ablak.getScoreBox().setText("" + flokesz.getKillCount());
                            log.trace("A bear was killed!");
                        }
                        stage1.update(flokesz);
                        log.trace("GameEngine -> Stage1 is running");
                    }
                }
                else{
                    //TODO: GAME OVER
                    ablak.getBg().setOpacity(0.7);
                    log.trace("Set Opacity");
                    flokeszEntity = new JPAEntity();
                    flokeszEntity.setScore(flokesz.getKillCount());
                    log.trace("Save player score");
                    try {
                        DB.save(flokeszEntity);
                    } catch (IllegalArgumentException ex) {
                        log.error("Exception: ", ex);
                    } catch (Exception ex) {
                        log.error("Exception: ", ex);
                    }
                    log.trace("Game over");
                }
                
                
            }
        }.start();

    }
}
