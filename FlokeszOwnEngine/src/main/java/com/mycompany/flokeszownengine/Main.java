package com.mycompany.flokeszownengine;
import com.mycompany.flokeszownengine.BL.GameEngine;

import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application{
    GameEngine MyEngine;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyEngine = new GameEngine();
        MyEngine.MainLoop();

    }
}