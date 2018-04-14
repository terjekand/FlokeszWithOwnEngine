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
package com.mycompany.flokeszownengine.BL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author kiss
 */
public class Res {
    Image image1;
    ImageView display;
    VBox vbox;
    Button fullhd, hd;
    Scene scene1;
    Pane bg;
    boolean choosed;
    public Res(){
        display = new ImageView();
        choosed = false;
        bg = new Pane();
        vbox = new VBox();
        fullhd = new Button("FullHD");
        hd = new Button("HD");
        image1 = new Image(getClass().getClassLoader().getResource("res.png").toString());
        display.setImage(image1);
        fullhd.prefHeight(75);
        fullhd.prefWidth(150);
        fullhd.setLayoutX(image1.getWidth() / 4);
        fullhd.setLayoutY(0);
        hd.prefHeight(75);
        hd.prefWidth(150);
        hd.setLayoutX(image1.getWidth() / 4);
        hd.setLayoutY(100);
        vbox.getChildren().addAll(fullhd, hd);
        bg.getChildren().addAll(display, vbox);
        scene1 = new Scene(bg, image1.getWidth(), image1.getHeight());
       
    }
    
    public ImageView getView(){
        return display;
    }
    public Scene getScene(){
        return scene1;
    }
    
    public Button getFullHdButton(){
        return fullhd;
    }
     public Button getHdButton(){
        return hd;
    }
    
    public boolean getChoosed(){
        return choosed;
    }
    
    public void setChoosed(boolean x){
        choosed = x;
    }
    
}
