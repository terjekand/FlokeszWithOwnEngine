package com.mycompany.flokeszownengine.BL;

public class Menu {
    private String bg_img, id;
    private int fogadoPoz, piacPoz, muhelyPoz, tablaPoz, tav, piacHossz = 775;
    private boolean tablanal, muhelynel, piacnal, fogadonal;

    public Menu(){
        id = "menu";
        bg_img = "/bg/menu/menu_bg.png";
        tav = 50;
        fogadoPoz = 220;
        piacPoz = 825;
        tablaPoz = 1830;
        muhelyPoz = 1430;
        tablanal = false;
        piacnal = false;
        fogadonal = false;
        muhelynel = false;
    }

    public String getId() {
        return id;
    }

    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
    }
}
