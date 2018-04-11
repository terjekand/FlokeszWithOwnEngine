package com.mycompany.flokeszownengine.UI;
import com.mycompany.flokeszownengine.BL.GameEngine;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.mycompany.flokeszownengine.BL.Character;

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
        image1 = new Image(getClass().getClassLoader().getResource("bg/menu/menu_bg.png").toString());
        selectedImage.setImage(image1);
        window = new Stage();
        window.setTitle("TryOwnEngine");
        bg = new Pane();
        bg.setId("alap");
        bg.getChildren().addAll(selectedImage, game.flokesz.player, game.flokesz.fegyver.weapon);
        scene = new Scene(bg, 1920, 1080);
        window.show();
        //window.setFullScreen(true);

    }

    public Scene getScene() {
        return scene;
    }
    public Pane getBg(){
        return bg;
    }

    public void setView(Image image){
        selectedImage.setImage(image);
    }
    public void update(Character flokesz){
        window.setScene(scene);


    }

}
