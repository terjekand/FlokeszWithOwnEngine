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
        image1 = new Image(getClass().getClassLoader().getResource("hd/weapon/boko.png").toString());
        weapon.setImage(image1);
        hit_poz = 0;
        damage = 50;
        this.x = x + 15;
        weapon.setX(this.x);
        weapon.setY(485);
    }
    /**
     * Az objektum helyzetenek meghatarozasa.
     * @return A kep X koordinataja
     */
    public double getX() {
        return x;
    }
    /**
     * A fegyver sebzeset adja vissza.
     * @return A sebzes merteke
     */
    public int getDamage(){
        return damage;
    }
    /**
     * Jobbra utunk.
     */
    public void hitR(){
        weapon.setRotate(90);
    }
    /**
     * Balra utunk.
     */
    public void hitL(){
        
        weapon.setRotate(-90); 
    }
    /**
     * ImageView megszerzese.
     * @return Az az image view ami a scene-hez hozza lesz adva.
     */
    public ImageView getWeapon(){
        return weapon;
    }
}
