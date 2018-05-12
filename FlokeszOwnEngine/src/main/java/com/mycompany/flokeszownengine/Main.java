package com.mycompany.flokeszownengine;
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

import com.mycompany.flokeszownengine.BL.GameEngine;
import com.mycompany.flokeszownengine.DB.DataBase;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
/**
 *
 * @author kiss
 */
@Slf4j
public class Main extends Application{
    /**
     * Egy adatbaziskezelo peldanyositasa.
     * A connectionhoz.
     */
    private static final DataBase DB = DataBase.getDbPeldany();
    /**
     * A jatekmotor letrehozasa.
     */
    GameEngine MyEngine;
    /**
     * A main fuggveny.
     * Ez a belepesi pont, ez inditja a start fuggvenyt,
     * valamint kapcsolodik az adatbazishoz.
     * @param args Argomentumok.
     */
    public static void main(String[] args){
         try {
            DB.connectDB();
            log.trace("Connect to database");

            launch(args);

        } catch (Exception e) {
            log.error("Problem with the database");
        } finally {
            DB.disconnectDB();
            log.trace("Disconnect form the database");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyEngine = new GameEngine();
        log.trace("Create new engine");
        log.trace("Call Engine MainLoop");
        MyEngine.MainLoop();
        

    }
}