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
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE) {
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
            if (keyEvent.getCode() == KeyCode.A) {
                flokesz.setX(flokesz.getX() - 10);
                flokesz.jobbra = false;
                flokesz.rest = false;
                flokesz.fegyver.weapon.setRotate(0);

            }
            if (keyEvent.getCode() == KeyCode.D) {
                flokesz.setX(flokesz.getX() + 10);
                flokesz.jobbra = true;
                flokesz.rest = false;
                flokesz.fegyver.weapon.setRotate(0);

            }
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                    flokesz.rest = true; 
                flokesz.fegyver.weapon.setRotate(0);}
        };
}
