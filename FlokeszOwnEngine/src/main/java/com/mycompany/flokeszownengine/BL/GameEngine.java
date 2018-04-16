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
import com.mycompany.flokeszownengine.UI.Window;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 *
 * @author kiss
 */
public class GameEngine {
    long startNanoTime;
    Stage1 stage1;
    public Input getInput() {
        return input;
    }

    Input input;
    Window ablak;
    boolean alreadyStopped = false;
    public Character flokesz;

    public GameEngine(){
        stage1 = new Stage1();
        flokesz = new Character();
        ablak = new Window(this);
        startNanoTime = System.nanoTime();
        input = new Input(flokesz);
         ablak.getScene().setOnKeyPressed(input.keyEventHandler);
    }

    public void MainLoop(){
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
                    stage1.setRun(true);
                    ablak.getBg().getChildren().add(stage1.getBear().getView());
                    ablak.getBg().getChildren().add(ablak.getScoreBox());
                    ablak.getScoreBox().setText("0");
                    ablak.getScoreBox().setTextFill(Color.WHITE);
                    ablak.getScoreBox().setFont(Font.font ("Verdana", 40));
                }
                if(stage1.getRun()){
                        if(flokesz.getBacked() > 0)
                            ablak.getHpBox().setText("" + flokesz.getHp());
                        if(stage1.getBear().getHealth() <= 0){
                            ablak.getBg().getChildren().remove(stage1.getBear().getView());
                            stage1.initBear();
                            ablak.getBg().getChildren().add(stage1.getBear().getView());
                            flokesz.incKillCount();
                            ablak.getScoreBox().setText("" + flokesz.getKillCount());
                        }
                        stage1.update(flokesz);
                    }
                }
                else if(!alreadyStopped){
                    Label endtext = new Label("Well Played!\n" + flokesz.getBacked());
                    endtext.setAlignment(Pos.CENTER);
                    endtext.setTextFill(Color.WHITE);
                    endtext.setFont(Font.font ("Verdana", 40));
                    ablak.setEnd();
                    ablak.getBg().getChildren().add(endtext);
                    alreadyStopped = true;
                    ablak.update(flokesz);
                }
                
            }
        }.start();

    }
}
