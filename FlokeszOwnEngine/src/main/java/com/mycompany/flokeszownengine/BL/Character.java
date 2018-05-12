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
import lombok.extern.slf4j.Slf4j;
/**
 *
 * @author kiss
 */
@Slf4j
public class Character {
    /**
     * A jatekos kepet tartalmazo ImageView.
     */
    public ImageView player = new ImageView();
    /**
     * A jatekos kepe.
     * Ebbe toltodnek bele a gifek.
     */
    Image image1 = null;
    /**
     * A jatekoshoz tartozo fegyver objektum.
     */
    public Weapon fegyver;
    /**
     * Az aktualis eletet tartalmazo valtozo.
     */
    private int currHp;
    /**
     * Azt mutatja, hogy a jatekos melyik iranyba nez.
     * Ha igaz erteke van, akkor a jatekos jobbra nez.
     */
    boolean jobbra = true;
    /**
     * Ha nem mozdultunk meg, akkor pihenunnk.
     * Ez alapjan toltodik be a piheneshez tartozo gif.
     */
    boolean rest = true;
    /**
     * Azt nezi meg, hogy pihenunk-e mar.
     * Ha pihenunk akkor nem irjuk felul a gifet.
     */
    boolean rested = true;
    /**
     * A hatralokeshez tartozo szamlalo.
     */
    int backed = 0;
    /**
     * Meg adja, hogy a jatekos melyik mapon van.
     */
    public String map;
    /**
     * A score tarolasara szolgal.
     */
    private int killCounter = 0;
    /**
     * A jobbra es a balra menes elozoleges firssiteset nezi.
     * Ha valamelyik igaz akkor azt jelenti, hogy az adott pozicio mar updatelve lett.
     */
    public boolean jobbraMent = false, balraMent = false;
    /**
     * A stage1-re valo atjutas lehetoseget adja meg.
     */
    boolean pass = false;
    /**
     * Ut-e a karakter.
     */
    boolean utes = false;
    /**
     * A Character osztaly konstruktora.
     * ->Kep betoltes.
     * ->Valtozok inicializalasa.
     * ->Pozicionalas.
     */
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
        log.trace("Character constructor called");
    }
    /**
     * a Jobbrameno valtozo erteket adja vissza.
     * @return A jobbra menes erteke.
     */
    public boolean isJobbra() {
        return jobbra;
    }
    /**
     * Beallitja a jobbramenest.
     * @param jobbra erre allitja be.
     */
    public void setJobbra(boolean jobbra) {
        this.jobbra = jobbra;
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
        log.trace("Player and Weapon X position modified");
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
        log.trace("Character -> Load new Gif");
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
        log.trace("Character -> Check store");
        return killCounter;
    }
    /**
     * Az olesek szamanak novelese.
    */
    public void incKillCount(){
        log.trace("Character -> Increase Score");
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
        log.trace("Character -> applyBackward");
        backed--;
        log.trace("Character ->Decrease backed");
        
    }
    /**
     * Aktualis elet visszaadasa.
     * @return az aktualis elet
     */
    public int getHp(){
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
                    log.trace("Character -> Run to Right Gif");
                }

                else{
                rested = false;
                jobbraMent = false;
                if(!balraMent)
                   setImg("hd/Flokesz/run/flokesz_run_R.gif");
                   player.setImage(image1);
                   log.trace("Character -> Run to Left Gif");
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
                log.trace("Character -> Rest");
            }
            
        }
        }
                
        
     }

