package com.mycompany.flokeszownengine.BL;

import com.mycompany.flokeszownengine.UI.Window;
import javafx.animation.AnimationTimer;

public class GameEngine {
    long startNanoTime;
    Stage1 stage1;
    public Input getInput() {
        return input;
    }

    Input input;
    Window ablak;
    public Character flokesz;

    public GameEngine(){
        stage1 = new Stage1();
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
                ablak.update(flokesz);
                ablak.getScene().setOnKeyPressed(input.keyEventHandler);
                ablak.getScene().setOnKeyReleased(input.keyEventHandler);
                flokesz.rest = true;
                if(flokesz.getPass()){
                    ablak.setView(stage1.getImage());
                    flokesz.setPass(false);
                    stage1.setRun(true);
                    ablak.getBg().getChildren().add(stage1.getBear().getView());
                }
                if(stage1.getRun()){
                    stage1.update(flokesz);
                }
            }
        }.start();

    }
}
