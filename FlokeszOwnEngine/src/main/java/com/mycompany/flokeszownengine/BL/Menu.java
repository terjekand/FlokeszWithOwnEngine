package com.mycompany.flokeszownengine.BL;

import static java.lang.Math.abs;

public class Menu {
    private int fogadoPoz, piacPoz, muhelyPoz, tablaPoz, tav, piacHossz = 775;
    private boolean tablanal, muhelynel, piacnal, fogadonal;

    public Menu(){
        tav = 100;
        fogadoPoz = 220;
        piacPoz = 825;
        tablaPoz = 1830;
        muhelyPoz = 1430;
        tablanal = false;
        piacnal = false;
        fogadonal = false;
        muhelynel = false;
    }
    public boolean isNearTheTable(Character flokesz){
        if(abs(flokesz.player.getX() - tablaPoz) <= tav)
            return true;
        return false;
    }
}
