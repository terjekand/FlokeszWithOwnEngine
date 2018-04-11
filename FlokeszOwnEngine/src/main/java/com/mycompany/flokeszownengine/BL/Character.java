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
    boolean rested = true;
    int backed = 0;
    public String map;
    boolean enterPressed = false;
    private int killCounter = 0;
    public boolean jobbraMent = false, balraMent = false;
    boolean pass = false;
    Character(){
        try {
            image1 = new Image(new FileInputStream("/home/kiss/NetBeansProjects/FlokeszWithOwnEngine/FlokeszOwnEngine/src/main/resources/Flokesz/rest/flokesz.gif"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        player.setImage(image1);
        player.setX(100);
        player.setY(600);
        fegyver = new Weapon(130);
        map = "Menu";
        //TODO HP-BAR
        //TODO WEAPON

    }
    public boolean getPass(){
        return pass;
    }
    public void setPass(boolean x){
        pass = x;
    }
    void setX(double x){
        player.setX(x);
        fegyver.weapon.setX(x + 60);
    }
    double getX(){
        return player.getX();
    }
    public void setImg(String img){
       image1 = new Image(getClass().getClassLoader().getResource(img).toString());
    }
    public void update(){
        if(!rest){
            if(jobbra){
                    rested = false;
                    balraMent = false;
                    if(!jobbraMent)
                        setImg("Flokesz/run/flokesz_run.gif");
                    player.setImage(image1);
                }

                else{
                rested = false;
                jobbraMent = false;
                if(!balraMent)
                   setImg("Flokesz/run/flokesz_run_R.gif");
                   player.setImage(image1);
                }
            }
        else{
            if(!rested){
                jobbraMent = false;
                balraMent = false;
                rested = true;
                if(jobbra)
                    setImg("Flokesz/rest/flokesz.gif");
                else
                    setImg("Flokesz/rest/flokesz_R.gif");
                player.setImage(image1);
            }
            
        }
        }
                
        
     }

