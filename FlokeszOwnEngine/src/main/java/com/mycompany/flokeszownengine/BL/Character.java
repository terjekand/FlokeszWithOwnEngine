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


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author kiss
 */
public class Character {
    public ImageView player = new ImageView();
    Image image1 = null;
    public Weapon fegyver;
    private float currHp, maxHp;
    boolean jobbra = true;
    boolean rest = true;
    boolean rested = true;
    int backed = 0;
    public String map;
    boolean enterPressed = false;
    private int killCounter = 0;
    public boolean jobbraMent = false, balraMent = false;
    boolean pass = false;
    Character(){
        image1 = new Image(getClass().getClassLoader().getResource("Flokesz/rest/flokesz.gif").toString());
        player.setImage(image1);
        player.setX(100);
        player.setY(600);
        fegyver = new Weapon(130);
        map = "Menu";
        //TODO HP-BAR
        //TODO WEAPON

    }
    public boolean getPass(){
        return pass;
    }
    public void setPass(boolean x){
        pass = x;
    }
    void setX(double x){
        player.setX(x);
        fegyver.weapon.setX(x + 60);
    }
    double getX(){
        return player.getX();
    }
    public void setImg(String img){
       image1 = new Image(getClass().getClassLoader().getResource(img).toString());
    }
    public void update(){
        if(!rest){
            if(jobbra){
                    rested = false;
                    balraMent = false;
                    if(!jobbraMent)
                        setImg("Flokesz/run/flokesz_run.gif");
                    player.setImage(image1);
                }

                else{
                rested = false;
                jobbraMent = false;
                if(!balraMent)
                   setImg("Flokesz/run/flokesz_run_R.gif");
                   player.setImage(image1);
                }
            }
        else{
            if(!rested){
                jobbraMent = false;
                balraMent = false;
                rested = true;
                if(jobbra)
                    setImg("Flokesz/rest/flokesz.gif");
                else
                    setImg("Flokesz/rest/flokesz_R.gif");
                player.setImage(image1);
            }
            
        }
        }
                
        
     }

