package com.mycompany.flokeszownengine.BL;

import com.mycompany.flokeszownengine.UI.Window;
import javafx.animation.AnimationTimer;

public class GameEngine {
    long startNanoTime;

    public Input getInput() {
        return input;
    }

    Input input;
    Window ablak;
    public Character flokesz;

    public GameEngine(){
        flokesz = new Character();
        ablak = new Window(this);
        startNanoTime = System.nanoTime();
        input = new Input(flokesz);
         ablak.getScene().setOnKeyPressed(input.keyEventHandler);
    }

    public void MainLoop(){
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                flokesz.update();
                ablak.update();
                //input.A_Key = input.D_Key = false;
                ablak.getScene().setOnKeyPressed(input.keyEventHandler);
                flokesz.rest = true;
                flokesz.Count_rest++;



            }
        }.start();

    }
}
