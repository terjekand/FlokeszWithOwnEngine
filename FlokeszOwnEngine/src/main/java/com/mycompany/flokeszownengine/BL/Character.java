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
    private int killCounter = 0;
    public boolean jobbraMent = false, balraMent = false;
    boolean pass = false;
    boolean utes = false;
    Character(){
        image1 = new Image(getClass().getClassLoader().getResource("fullhd/Flokesz/rest/flokesz.gif").toString());
        player.setImage(image1);
        player.setX(100);
        player.setY(600);
        fegyver = new Weapon(130);
        map = "Menu";
        //TODO HP-BAR

    }
    public boolean getUtes(){
        return utes;
    }
    public void setUtes(boolean x){
        utes = x;
    }
    public boolean getPass(){
        return pass;
    }
    public ImageView getPlayer(){
        return player;
    }
    public void setPass(boolean x){
        pass = x;
    }
    void setX(double x){
        player.setX(x);
        fegyver.weapon.setX(x + 60);
    }
    double getPoz(){
        return player.getX();
    }
    public void setImg(String img){
       image1 = new Image(getClass().getClassLoader().getResource(img).toString());
    }
    public Image getImg(){
        return image1;
    }
    public void setBacked(int x){
        backed = x;
    }
    public int getBacked(){
        return backed;
    }
    public void applyBackward(int x){
        if(x < 0){
            player.setX(player.getX() - 50);
            fegyver.getWeapon().setX(fegyver.getWeapon().getX() - 50);
        }
        else{
            player.setX(player.getX() + 50);
            fegyver.getWeapon().setX(fegyver.getWeapon().getX() + 50);
        }
        
        backed--;
        
    }
    public Weapon getWeapon(){
        return fegyver;
    }
    public void update(){
        if(!rest){
            if(jobbra){
                    rested = false;
                    balraMent = false;
                    if(!jobbraMent)
                        setImg("fullhd/Flokesz/run/flokesz_run.gif");
                    player.setImage(image1);
                }

                else{
                rested = false;
                jobbraMent = false;
                if(!balraMent)
                   setImg("fullhd/Flokesz/run/flokesz_run_R.gif");
                   player.setImage(image1);
                }
            }
        else{
            if(!rested){
                jobbraMent = false;
                balraMent = false;
                rested = true;
                if(jobbra)
                    setImg("fullhd/Flokesz/rest/flokesz.gif");
                else
                    setImg("fullhd/Flokesz/rest/flokesz_R.gif");
                player.setImage(image1);
            }
            
        }
        }
                
        
     }

