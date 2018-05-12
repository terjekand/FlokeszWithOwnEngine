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
    /**
     * A hatterkep.
     */
    Image image1;
    /**
     * Az enemy letrehozasa.
     */
    Bear bear;
    /**
     * Fut-e az adott palya.
     */
    boolean run = false;
    /**
     * Konstruktor.
     * Hatterkep betoltese es medve peldanyositasa.
     */
    public Stage1(){
        bear = new Bear();
        image1 = new Image(getClass().getClassLoader().getResource("hd/bg/maps/1.png").toString());
    }
    /**
     * Az ellenseg kinyerese a palyarol.
     * @return A medve objektumot kapjuk meg vele
     */
    public Bear getBear(){
        return bear;
    }
    /**
     * Megnezzuk, hogy fut-e az adott palya.
     * @return A futashoz tartozo logikai ertek
     */
    public boolean getRun(){
        return run;
    }
    /**
     * A futas modositasa.
     * @param x re allitjuk a futast
     */
    public void setRun(boolean x){
        run = x;
    }
    /**
     * A hatterkep visszaadasa.
     * @return A hatterkep
     */
    public Image getImage(){
        return image1;
    }
    /**
     * A medve inicializalasa.
     * Meghivodik igy a konstruktora amelyben randomba megkapja, hogy melyik oldalrol indul
     * Ennek fuggvenyeben kerulnek betoltodesre a kepek hozza
     */
    public void initBear(){
        bear = new Bear();
    }
    /**
     * A palya frissitese.
     * Firssitem benne a medvet is a karakter alapjan
     * A karakter atadasa azert fontos mert az o helyzetetol es az egyeb parametereitol fugg, hogy
     * sebzodik e valami, hatralokodik e, stb...
     * @param flokesz a bejovo karakter, minden frissitest hozza nezek
     */
    public void update(Character flokesz){
        bear.update(flokesz);
        if(flokesz.getBacked() > 0){
            flokesz.applyBackward(bear.getSpeed());
        }
    }
    
}
