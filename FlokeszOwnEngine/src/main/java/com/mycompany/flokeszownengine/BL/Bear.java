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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author kiss
 */
public class Bear {
    Image image1;
    ImageView bear;
    public Bear(){
        bear = new ImageView();
        image1 = null;
        image1 = new Image(getClass().getClassLoader().getResource("enemy/bear/bear_R.gif").toString());
        bear.setImage(image1);
        bear.setX(2300);
        bear.setY(500);
    }
    public ImageView getView(){
        return bear;
    }
    public Image getImage(){
        return image1;
    }
    public void update(){
        bear.setX(bear.getX() - 2);
    }
}
