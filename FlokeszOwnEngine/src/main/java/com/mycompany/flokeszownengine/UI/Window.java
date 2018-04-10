package com.mycompany.flokeszownengine.UI;
import com.mycompany.flokeszownengine.BL.GameEngine;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Window{
    private Stage window;
    private Pane bg;
    private Scene scene;
    private String stageId;
    final ImageView selectedImage;
    Image image1;
    public Window(GameEngine game){
        stageId = "menu";
        selectedImage = new ImageView();
        image1 = null;
        try {
            image1 = new Image(new FileInputStream("/home/kiss/NetBeansProjects/FlokeszWithOwnEngine/FlokeszOwnEngine/src/main/resources/bg/menu/menu_bg.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        selectedImage.setImage(image1);
        window = new Stage();
        window.setTitle("TryOwnEngine");
        bg = new Pane();
        bg.setId("alap");
        bg.getChildren().addAll(game.flokesz.player, game.flokesz.fegyver.weapon);
        scene = new Scene(bg, 1920, 1080);
        scene.getStylesheets().addAll(this.getClass().getResource("/home/kiss/NetBeansProjects/FlokeszWithOwnEngine/FlokeszOwnEngine/src/main/resources/style.css").toExternalForm());
        window.show();
        window.setFullScreen(true);

    }

    public Scene getScene() {
        return scene;
    }

    public void update(){
        window.setScene(scene);


    }

}
