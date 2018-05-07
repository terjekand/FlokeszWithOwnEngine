package com.mycompany.flokeszownengine.UI;
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

import com.mycompany.flokeszownengine.BL.GameEngine;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.mycompany.flokeszownengine.BL.Character;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 *
 * @author kiss
 */
public class Window{
    private Stage window;
    private Pane bg;
    private Scene scene;
    private String stageId;
    final ImageView selectedImage;
    Image image1;
    Label scoreBox;
    Label hpBox;
    public Window(GameEngine game){
        scoreBox = new Label();
        hpBox = new Label("100");
        hpBox.setLayoutX(1280);
        hpBox.setTextFill(Color.RED);
        hpBox.setFont(Font.font ("Verdana", 40));
        stageId = "menu";
        selectedImage = new ImageView();
        image1 = null;
        image1 = new Image(getClass().getClassLoader().getResource("hd/bg/menu/menu_bg.png").toString());
        selectedImage.setImage(image1);
        window = new Stage();
        window.setTitle("TryOwnEngine");
        bg = new Pane();
        bg.setId("alap");
        bg.getChildren().addAll(selectedImage, hpBox, game.flokesz.player, game.flokesz.fegyver.weapon);
        scene = new Scene(bg, 1366, 768);
        window.show();
        //window.setFullScreen(true);

    }
    /**
     * Eletet mutato label .
     * @return Azt a Labelt adja vissza amelyben a karater elete jelenul meg
     */
    public Label getHpBox(){
        return hpBox;
    }
    /**
     * Scoreot mutato label.
     * Ha megolunk egy medvet no a scoreunk
     * @return Az a label ami a scoreunkat tartalmazza
     */
    public Label getScoreBox(){
        return scoreBox;
    }
    /**
     * A stagehoz tartozo scenet adja vissza.
     * @return A stagehoz tartozo scene
     */
    public Scene getScene() {
        return scene;
    }
    /**
     * A bg olyan csoport amihez minden tovabbi obj kapcsolodik.
     * @return Az alapertelmezett layout visszaadasa amire letrehoztam a scenet
     */
    public Pane getBg(){
        return bg;
    }
    /**
     * Hatter beallitasa.
     * @param image imagera
     */
    public void setView(Image image){
        selectedImage.setImage(image);
    }
    /**
     * Kepernyo frissitese.
     * @param flokesz 
     */
    public void update(Character flokesz){
            window.setScene(scene);


    }

}
