package com.mycompany.flokeszownengine.BL;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {
    public boolean A_Key, D_Key;
    Character flokesz;
    Input(Character flokesz){
        this.flokesz = flokesz;
    }
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                System.out.println("enter pressed");
            }
            if (keyEvent.getCode() == KeyCode.A) {
                flokesz.setX(flokesz.getX() - 10);
                flokesz.rest = false;
                flokesz.Count_bal++;
                flokesz.jobbra = false;

            }
            if (keyEvent.getCode() == KeyCode.D) {
                flokesz.setX(flokesz.getX() + 10);
                flokesz.rest = false;
                flokesz.Count_jobb++;
                flokesz.jobbra = true;
            }
        };
}
