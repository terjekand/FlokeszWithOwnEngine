package com.mycompany.flokeszownengine.BL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Weapon {
    public ImageView weapon = new ImageView();
    Image image1;
    private int hit_poz, hit_dist[], damage;
    double x;
    public Weapon(double x) {

        image1 = null;
        try {
            image1 = new Image(new FileInputStream("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/weapon/boko.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        weapon.setImage(image1);
        hit_poz = 0;
        hit_dist = new int[4];
        hit_dist[0] = 0;
        hit_dist[1] = 16;
        hit_dist[2] = 60;
        hit_dist[3] = 120;
        damage = 50;
        this.x = x + 30;
        weapon.setX(this.x);
        weapon.setY(720);
    }

    public double getX() {
        return x;
    }

    public void hitR(){
        weapon.setRotate(90);
    }
    public void hitL(){
        
        weapon.setRotate(-90); 
    }

    public void revHit(int i){
        hit_poz = -1;
        weapon.setTranslateZ(i);
    }
}
