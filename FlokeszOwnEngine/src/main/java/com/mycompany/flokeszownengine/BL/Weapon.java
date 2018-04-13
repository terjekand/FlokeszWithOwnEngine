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
public class Weapon {
    public ImageView weapon = new ImageView();
    Image image1;
    private int hit_poz, hit_dist[], damage;
    double x;
    public Weapon(double x) {

        image1 = null;
            //image1 = new Image(new FileInputStream("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/weapon/boko.png"));
        image1 = new Image(getClass().getClassLoader().getResource("weapon/boko.png").toString());
        weapon.setImage(image1);
        hit_poz = 0;
        hit_dist = new int[4];
        hit_dist[0] = 0;
        hit_dist[1] = 16;
        hit_dist[2] = 60;
        hit_dist[3] = 120;
        damage = 50;
        this.x = x + 30;
        weapon.setX(this.x);
        weapon.setY(720);
    }

    public double getX() {
        return x;
    }

    public void hitR(){
        weapon.setRotate(90);
    }
    public void hitL(){
        
        weapon.setRotate(-90); 
    }

    public void revHit(int i){
        hit_poz = -1;
        weapon.setTranslateZ(i);
    }
    public ImageView getWeapon(){
        return weapon;
    }
}
