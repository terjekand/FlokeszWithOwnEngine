package com.mycompany.flokeszownengine.BL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Character {
    public ImageView player = new ImageView();
    Image image1 = null;
    public Weapon fegyver;
    private float currHp, maxHp;
    boolean jobbra = true;
    boolean rest = true;
    boolean hit = false;
    int Count_jobb = 0;
    int Count_bal= 0;
    int run_speed = 4;
    int Count_hit = 0;
    int Count_rest = 0;
    boolean hit_left = false;
    boolean hit_right = false;
    boolean hatra_jobbrol = true;
    boolean hatra_balrol = true;
    int backed = 0;
    public String map;
    boolean enterPressed = false;
    private int killCounter = 0;
    public int runStack;
    Character(){
        try {
            image1 = new Image(new FileInputStream("/home/kiss/NetBeansProjects/FlokeszWithOwnEngine/FlokeszOwnEngine/src/main/resources/Flokesz/rest/flokesz.gif"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Count_rest = 0;
        fegyver = new Weapon(100);
        player.setImage(image1);
        player.setX(100);
        player.setY(600);
        fegyver = new Weapon(130);
        runStack = 0;
        map = "Menu";
        //TODO HP-BAR
        //TODO WEAPON

    }
    void setX(double x){
        player.setX(x);
        fegyver.weapon.setX(x + 60);
    }
    double getX(){
        return player.getX();
    }
    public void setImg(String img){
        try {
            image1 = new Image(new FileInputStream(img));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void update(){
            if(!rest){
                if(jobbra){
                    if(Count_jobb == 0){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_run_1.png");
                    }
                    else if(Count_jobb == 1){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_run_2.png");
                    }
                    else if(Count_jobb == 2){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_run_3.png");
                    }
                    else{
                        Count_jobb = 0;
                    }
                }

                else{
                    if(Count_bal == 0){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_R_run_1.png");
                    }
                    else if(Count_bal == 1){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_R_run_2.png");
                    }
                    else if(Count_bal == 2){
                        setImg("/home/kiss/Documents/School/ProgTech/OwnEngine/src/main/java/textures/run/flokesz_R_run_3.png");
                    }
                    else{
                        Count_bal = 0;
                    }
                }
            }
            else
                 setImg("/home/kiss/NetBeansProjects/FlokeszWithOwnEngine/FlokeszOwnEngine/src/main/resources/Flokesz/rest/flokesz.gif");
        player.setImage(image1);
     }
}
