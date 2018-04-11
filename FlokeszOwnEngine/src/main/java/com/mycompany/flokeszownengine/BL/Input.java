package com.mycompany.flokeszownengine.BL;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
