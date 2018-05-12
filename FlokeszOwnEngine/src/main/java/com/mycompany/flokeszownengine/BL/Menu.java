/*
 * Copyright 2018 Kiss Dávid.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.mycompany.flokeszownengine.BL;

import static java.lang.Math.abs;
/**
 *
 * @author kiss
 */
public class Menu {
    private double tablaPoz, tav;

    public Menu(){
        tav = 100.0;
        tablaPoz = 1280.0;
    }
    /**
    * Vissza adja a tabla poziciojat a mapon.
    * @return A tabla pozicioja.
    */
    public double getTablaPoz() {
        return tablaPoz;
    }
    
    
    /**
     * Az enter leutes a tablanal volt-e.
     * Ha igen akkor a karakter tovabb mehet a palyara
     * @param flokesz a karakterunk amely tovabbjut majd a palyara
     * @return logikai ertek ami vissza adja, hogy elkezdodhet-e a jatek.
     */
    
    public boolean isNearTheTable(Character flokesz){
        return (abs(flokesz.player.getX() - tablaPoz) <= tav);
    }
}
