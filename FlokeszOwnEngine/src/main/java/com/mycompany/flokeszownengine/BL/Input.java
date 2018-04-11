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
    public boolean A_Key, D_Key;
    Character flokesz;
    int i = 0;
    Input(Character flokesz){
        this.flokesz = flokesz;
    }
    
    private void doHitAction(){
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
    private void applyRightMovement(){
                flokesz.setX(flokesz.getX() - 15);
                flokesz.jobbra = false;
                flokesz.rest = false;
    }
    private void applyLeftMovement(){
                flokesz.setX(flokesz.getX() + 15);
                flokesz.jobbra = true;
                flokesz.rest = false;
    }
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                Menu menu = new Menu();
                if(menu.isNearTheTable(flokesz))
                    flokesz.setPass(true);
            }
            if (keyEvent.getCode() == KeyCode.SPACE) {
                doHitAction();
            }
            if (keyEvent.getCode() == KeyCode.A) {
                flokesz.fegyver.weapon.setRotate(0);
                applyRightMovement();

            }
            if (keyEvent.getCode() == KeyCode.D) {
                flokesz.fegyver.weapon.setRotate(0);
                applyLeftMovement();

            }
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                    flokesz.rest = true; 
                flokesz.fegyver.weapon.setRotate(0);}
        };
}
