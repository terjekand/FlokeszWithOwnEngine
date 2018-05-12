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

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 *
 * @author kiss
 */
public class Input {
    /**
     * A Character osztaly egy eleme.
     * Arra hasznaljuk, hogy ra allitsuk az erteket a GameEngine-ben levojere.
     */
    Character flokesz;
    /**
     * Hit-RevHit hez hasznalt szamlalo.
     */
    int i = 0;
    /**
     * Az input osztaly konstruktora.
     * @param flokesz re allitjuk a sajat flokesz objektumunk erteket.
     */
    public Input(Character flokesz){
        this.flokesz = flokesz;
    }
    /**
    * Az utes mozdulat megvalositasaert felelos fuggveny.
    */
    public void doHitAction(){
        if(flokesz.jobbra){
                    if(i == 0){
                        flokesz.fegyver.hitR();
                        i++;
                    }
                        
                    else{
                        flokesz.fegyver.weapon.setRotate(0);
                        i = 0;
                    }
                    
                }                
                else{
                 if(i == 0){
                        flokesz.fegyver.hitL();
                        i++;
                    }
                        
                    else{
                        flokesz.fegyver.weapon.setRotate(0);
                        i = 0;
                    }  
                }
    }
    /**
    * A balra futas megvalositasaert felelos fuggvveny.
    */
    public void applyLeftMovement(){
                flokesz.fegyver.weapon.setRotate(0);
                flokesz.setX(flokesz.getPoz() - 15);
                flokesz.jobbra = false;
                flokesz.rest = false;
                i = 0;
    }
    /**
    * A jobbra futas megvalositasaert felelos fuggveny.
    */
    public void applyRightMovement(){
                flokesz.fegyver.weapon.setRotate(0);
                flokesz.setX(flokesz.getPoz() + 15);
                flokesz.jobbra = true;
                flokesz.rest = false;
                i = 0;
    }
    /**
     * A tovabbjutas ellenorzese.
     */
    public void tryToPass(){
        Menu menu = new Menu();
        if(menu.isNearTheTable(flokesz))
            flokesz.setPass(true);
    }
    /**
    * A billentyuzet lenyomas erzekelese.
    */
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                 tryToPass();
            }
            if (keyEvent.getCode() == KeyCode.SPACE) {
                doHitAction();
                flokesz.setUtes(true);
            }
            if (keyEvent.getCode() == KeyCode.A) {
                applyLeftMovement();
            }
            if (keyEvent.getCode() == KeyCode.D) {
                applyRightMovement();

            }
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                flokesz.rest = true; 
                flokesz.fegyver.weapon.setRotate(0);
                flokesz.setUtes(false);
            }    
        };
}
