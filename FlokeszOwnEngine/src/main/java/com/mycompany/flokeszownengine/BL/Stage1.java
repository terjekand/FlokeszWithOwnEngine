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

import javafx.scene.image.Image;

/**
 *
 * @author kiss
 */
public class Stage1 {
    Image image1;
    Bear bear;
    boolean run = false;
    public Stage1(){
        bear = new Bear();
        image1 = new Image(getClass().getClassLoader().getResource("hd/bg/maps/1.png").toString());
    }
    public Bear getBear(){
        return bear;
    }
    public boolean getRun(){
        return run;
    }
    public void setRun(boolean x){
        run = x;
    }
    public Image getImage(){
        return image1;
    }
    public void update(Character flokesz){
        bear.update(flokesz);
        if(flokesz.getBacked() > 0){
            flokesz.applyBackward(bear.getSpeed());
        }
    }
    
}
