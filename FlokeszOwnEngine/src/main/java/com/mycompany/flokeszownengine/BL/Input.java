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
import lombok.extern.slf4j.Slf4j;
/**
 *
 * @author kiss
 */
@Slf4j
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
                        log.trace("Input - > doHitAction -> hit to Right(rotate 90)");
                    }
                        
                    else{
                        flokesz.fegyver.weapon.setRotate(0);
                        i = 0;
                        log.trace("Input - > doHitAction -> hit to Right(rotate 0)");
                    }
                    
                }                
                else{
                 if(i == 0){
                        flokesz.fegyver.hitL();
                        i++;
                        log.trace("Input - > doHitAction -> hit to Left(rotate - 90)");
                    }
                        
                    else{
                        flokesz.fegyver.weapon.setRotate(0);
                        i = 0;
                        log.trace("Input - > doHitAction -> hit to Left(rotate 0)");
                        
                    }  
                }
    }
    /**
    * A balra futas megvalositasaert felelos fuggvveny.
    */
    public void applyLeftMovement(){
                flokesz.fegyver.weapon.setRotate(0);
                log.trace("Input - > applyLeftMovement -> Weapon rotate -> 0");
                flokesz.setX(flokesz.getPoz() - 15);
                log.trace("Input - > applyLeftMovement -> mod pozition");
                flokesz.jobbra = false;
                log.trace("Input - > applyLeftMovement -> character -> jobbra = false");
                flokesz.rest = false;
                log.trace("Input - > applyLeftMovement -> character - >rest -> false");
                i = 0;
    }
    /**
    * A jobbra futas megvalositasaert felelos fuggveny.
    */
    public void applyRightMovement(){
                flokesz.fegyver.weapon.setRotate(0);
                log.trace("Input - > applyRightMovement -> Weapon rotate -> 0");
                flokesz.setX(flokesz.getPoz() + 15);
                log.trace("Input - > applyRightMovement -> mod pozition");
                flokesz.jobbra = true;
                log.trace("Input - > applyRightMovement -> character -> jobbra = true");
                flokesz.rest = false;
                log.trace("Input - > applyRightMovement -> character - >rest -> false");
                i = 0;
    }
    /**
     * A tovabbjutas ellenorzese.
     */
    public void tryToPass(){
        Menu menu = new Menu();
        log.trace("Try to Pass");
        if(menu.isNearTheTable(flokesz)){
            flokesz.setPass(true);
            log.trace("Pass Rights gained");
        }
            
    }
    /**
    * A billentyuzet lenyomas erzekelese.
    */
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                 tryToPass();
                 log.trace("Enter pressed");
            }
            if (keyEvent.getCode() == KeyCode.SPACE) {
                doHitAction();
                flokesz.setUtes(true);
                log.trace("Space pressed");
            }
            if (keyEvent.getCode() == KeyCode.A) {
                applyLeftMovement();
                log.trace("A pressed");
            }
            if (keyEvent.getCode() == KeyCode.D) {
                applyRightMovement();
                log.trace("D pressed");

            }
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                flokesz.rest = true; 
                flokesz.fegyver.weapon.setRotate(0);
                flokesz.setUtes(false);
                log.trace("Key Released func Called");
            }    
        };
}
