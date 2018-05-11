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
    public Character(){
        currHp = 100;
        killCounter = 0;
        image1 = new Image(getClass().getClassLoader().getResource("hd/Flokesz/rest/flokesz.gif").toString());
        player.setImage(image1);
        player.setX(100);
        player.setY(400);
        fegyver = new Weapon(130);
        map = "Menu";
        //TODO HP-BAR

    }
    /**
     * Az utes statuszat adja vissza.
     * @return Vissza adja, hogy eppen utunk-e.
     */
    public boolean getUtes(){
        return utes;
    }
    /**
     * Az utes statuszanak a modositasa.
     * @param x re modositjuk az utes statuszat (logikai ertek)
     */
    public void setUtes(boolean x){
        utes = x;
    }
    /**
     * Atmehetunk-e az elso palyara.
     * @return ha a pass logikai valtozo igaz akkor tovabbenged a jatek
     */
    public boolean getPass(){
        return pass;
    }
    /**
     * Vissza adja az objektumhoz tartozo megjelenitendo kepet.
     * @return a player valtozo a kepet tartalmazza amit mindenhol mashol csak frissitek
     */
    public ImageView getPlayer(){
        return player;
    }
    /**
     * Ha az atjutasi feltetelek teljesulnek akkor hivodik meg.
     * @param x re allitja a Pass valtozot
     */
    public void setPass(boolean x){
        pass = x;
    }
    /**
     * Fegyver es karakter mozgatasa.
     * Jobbra vagy balra nezes erzekelese
     * @param x re allitja a koordinatajat a karakternek es ehhez kepest relativan a fegyveret
     */
    void setX(double x){
        if(jobbra)
            fegyver.weapon.setX(x + 45);
        else
            fegyver.weapon.setX(x + 60);
        player.setX(x);
    }
    /**
     * Karakter poziciojanak megkapasa.
     * @return a karakter pozicioja
     */
    double getPoz(){
        return player.getX();
    }
    /**
     * A kepek frissitesere hasznalom.
     * A kepek a billentyuzet leutesek fuggvenyeben frissulnek
     * @param img re allitom az imageview kepet
     */
    public void setImg(String img){
       image1 = new Image(getClass().getClassLoader().getResource(img).toString());
    }
    /**
     * Megkapjuk az aktualis kepet.
     * @return az aktualisan hasznalt kep
     */
    public Image getImg(){
        return image1;
    }
    /**
     * A hatrautes beallitasa.
     * Amikor a karakter utkozik a medvevel ezt a valtozot egy nullanal nagyobb szamra allitom be.
     * Ennek segitsegevel fokozatosan csuszik hatra a karakter es ha modositani akarok a hatralokes merteken
     * csak nagyobb szamot adok at a fuggvenynek.
     * @param x - szer csuszik hatra majd a karakter
     */
    public void setBacked(int x){
        backed = x;
    }
    /**
     * Megezzuk, hogy mennyit kell meg hatra csusznunk.
     * @return mennyiszer kell meg hatracsusznunk
     */
    public int getBacked(){
        return backed;
    }
    /**
     * Az olesek szamat adja vissza.
     * @return az olesek szama
     */
    public int getKillCount(){
        return killCounter;
    }
    /**
     * Az olesek szamanak novelese.
    */
    public void incKillCount(){
        killCounter++;
    }
    /**
     * A hatralokes megvalositasa.
     * @param x a medve sebessege, ami hogyha negativ, akkor jobbrol
     * egyebkent meg balrol erkezik, ennek fuggvenyeben tudjuk meg, hogy
     * melyik iranyba valosul meg a hatralokes
     */
    public void applyBackward(float x){
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
    /**
     * Aktualis elet visszaadasa.
     * @return az aktualis elet
     */
    public float getHp(){
        return currHp;
    }
    /**
     * Aktualis frissitese.
     * Alltalaban negativ szammal hivodik meg a fuggveny
     * @param x el csokken az elet
     */
    public void setHp(int x){
        currHp += x;
    }
    /**
     * A fegyver objektum megszerzese.
     * @return megkapjuk a karakterhez tartozo fegyver objektumot
     */
    public Weapon getWeapon(){
        return fegyver;
    }
    /**
     * A karakterunk frissitese.
     * Jellemzoen minden karakterhez tartozo uj kep betoltesere itt kerul sor
     */
    public void update(){
        if(!rest){
            if(jobbra){
                    rested = false;
                    balraMent = false;
                    if(!jobbraMent)
                        setImg("hd/Flokesz/run/flokesz_run.gif");
                    player.setImage(image1);
                }

                else{
                rested = false;
                jobbraMent = false;
                if(!balraMent)
                   setImg("hd/Flokesz/run/flokesz_run_R.gif");
                   player.setImage(image1);
                }
            }
        else{
            if(!rested){
                jobbraMent = false;
                balraMent = false;
                rested = true;
                if(jobbra)
                    setImg("hd/Flokesz/rest/flokesz.gif");
                else
                    setImg("hd/Flokesz/rest/flokesz_R.gif");
                player.setImage(image1);
            }
            
        }
        }
                
        
     }

