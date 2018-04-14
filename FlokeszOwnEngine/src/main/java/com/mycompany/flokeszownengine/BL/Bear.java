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
import javafx.scene.image.ImageView;
import static java.lang.Math.abs;
import java.util.Random;
/**
 *
 * @author kiss
 */
public class Bear {
    Image image1;
    ImageView bear;
    int knocked;
    int bearPoz[];
    int actPoz;
    int speed;
    public Bear(){
        speed = -2;
        bearPoz = new int [2];
        bearPoz[0] = -300;
        bearPoz[1] = 2300;
        Random rand = new Random();
        actPoz = rand.nextInt(2);
        bear = new ImageView();
        image1 = null;
        if(actPoz == 1)
            image1 = new Image(getClass().getClassLoader().getResource("enemy/bear/bear_R.gif").toString());
        else
            image1 = new Image(getClass().getClassLoader().getResource("enemy/bear/bear.gif").toString());
        bear.setImage(image1);
        bear.setX(bearPoz[actPoz]);
        bear.setY(500);
        knocked = 0;
        if(actPoz == 0)
            speed *= -1;
    }
    public ImageView getView(){
        return bear;
    }
    public Image getImage(){
        return image1;
    }
    public double getPoz(){
        return bear.getX();
    }
    private void back(){
        if(actPoz == 1)
             bear.setX(bear.getX() + 50);
        else
            bear.setX(bear.getX() - 50);
        knocked--;
    }
    public boolean toBackR(Character flokesz){
        return (abs(flokesz.getPoz() + flokesz.getImg().getWidth() - bear.getX()) < 5) 
                || (abs(flokesz.getPoz() + flokesz.getImg().getWidth() / 2 - bear.getX()) < 5);
    }
    public boolean toBackL(Character flokesz){
         return (abs(flokesz.getPoz() - bear.getX() + image1.getWidth()) < 5) 
                || (abs(flokesz.getPoz() - bear.getX() + image1.getWidth() / 2) < 5); 
    }
    public void update(Character flokesz){
        if(knocked == 0){
            if(toBackR(flokesz)
              //|| toBackL(flokesz)
                    ){
            knocked = 8;
            if(!flokesz.getUtes())
                flokesz.setBacked(8);
        }
        else
            bear.setX(bear.getX() + speed);
        }
        else
            back();
        
    }
}
