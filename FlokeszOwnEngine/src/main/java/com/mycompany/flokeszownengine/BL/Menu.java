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
    private int fogadoPoz, piacPoz, muhelyPoz, tablaPoz, tav, piacHossz = 775;
    private boolean tablanal, muhelynel, piacnal, fogadonal;

    public Menu(){
        tav = 100;
        fogadoPoz = 220;
        piacPoz = 825;
        tablaPoz = 1280;
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
