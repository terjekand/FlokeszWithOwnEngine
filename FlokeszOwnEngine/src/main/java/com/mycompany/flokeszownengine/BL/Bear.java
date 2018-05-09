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
    int health;
    public Bear(){
        health = 100;
        speed = -6;
        bearPoz = new int [2];
        bearPoz[0] = -300;
        bearPoz[1] = 1666;
        Random rand = new Random();
        actPoz = rand.nextInt(2);
        bear = new ImageView();
        image1 = null;
        if(actPoz == 1)
            image1 = new Image(getClass().getClassLoader().getResource("hd/characters/enemy/lvl1/bear/bear_R.gif").toString());
        else
            image1 = new Image(getClass().getClassLoader().getResource("hd/characters/enemy/lvl1/bear/bear.gif").toString());
        bear.setImage(image1);
        bear.setX(bearPoz[actPoz]);
        bear.setY(350);
        knocked = 0;
        if(actPoz == 0)
            speed *= -1;
    }
    /**
     * A medve eletet kapjuk meg.
     * @return a medve elete
     */
    public int getHealth(){
        return health;
    }
    /**
     * Modostijuk a medve eletet.
     * @param x el modosul
     */
    public void setHealth(int x){
        health = x;
    }
    /**
     * A medvehez tartozo kepet adja vissza.
     * @return azt az ImageViewet adja vissza amelyet be toltok a scenembe
     */
    public ImageView getView(){
        return bear;
    }
    /**
     * Kep kinyeres.
     * @return Megkapjuk, hogy aktualisan melyik kep van betoltve az ImageViewunkba 
     */
    public Image getImage(){
        return image1;
    }
    /**
     * Pozicio kinyeres.
     * @return A medve aktualis pozicioja
     */
    public double getPoz(){
        return bear.getX();
    }
    /**
     * A hatralokes megvalositasa, az alapjan, hogy a konstruktorban mely poziciora tettuk le a medvet.
     */
    private void back(){
        if(actPoz == 1)
             bear.setX(bear.getX() + 50);
        else
            bear.setX(bear.getX() - 50);
        knocked--;
    }
    /**
     * A medve sebessege.
     * @return A medve mozgasi sebesseget adja meg
     */
    public int getSpeed(){
        return speed;
    }
    /**
     * Jobbrol utkozes erzekelese.
     * Megnezzuk, hogy a karakter pozicioja + annak szelessege a medve poziciojahoz kepest hogyan helyezkedik el
     * X koordinatakat vizsgálok csak.
     * Egy tartomanyt hasznalok benne, mert ha statikusana cska egy adott X koordinatara vizsgalnek, akkor
     * a sok mozgasi hatas miatt bekovetkezhet, hogy rosszul tortenik a vizsgalat,
     * @param flokesz a karakter amihez kepest frissitunk mindent
     * @return olyan logikai ertek amely visszaadja, hogy hatra kell e lokni a medvet
     */
    public boolean toBackR(Character flokesz){
        return (abs(flokesz.getPoz() + flokesz.getImg().getWidth() - bear.getX()) < 5) 
                || (abs(flokesz.getPoz() + flokesz.getImg().getWidth() / 2 - bear.getX()) < 5);
    }
    /**
     * A fent letrehozott hatralokes fuggveny megvalositasa balra.
     * @param flokesz a karater amihez kepest frissitunk mindent
     * @return olyan logikai ertek amely megadja, hogy hatra kell-e lokni a medvet
     */
    public boolean toBackL(Character flokesz){
         return (abs(flokesz.getPoz() - (bear.getX() + image1.getWidth())) < 5) 
                || (abs(flokesz.getPoz()  - (bear.getX() + image1.getWidth() / 2)) < 5); 
    }
    /**
     * A medve frissitese.
     * A sebzes megvalositasa.
     * A hatralokes megvalositasa.
     * A mozgas megvalositasa.
     * 
     * @param flokesz 
     */
    public void update(Character flokesz){
        if(knocked == 0){
            if(toBackR(flokesz)
              || toBackL(flokesz)
                    ){
            knocked = 8;
            if(!flokesz.getUtes()){
                flokesz.setBacked(8);
                flokesz.setHp(-20);
            }
            else{
                health -= flokesz.getWeapon().getDamage();
            }
        }
        else
            bear.setX(bear.getX() + speed);
        }
        else
            back();
        
    }
}
