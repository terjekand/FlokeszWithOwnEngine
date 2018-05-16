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
package testForDB;

import com.mycompany.flokeszownengine.DB.DataBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Dávid
 */
public class Test5 {
    
    private DataBase DB;
    
    @BeforeClass
    public static void sep(){
        System.out.println("\n##### T E S T S    F O R    D A T A B A S E    C L A S S #####\n");
    }
    
    @Before
    public void setUp() {
        DB = DataBase.getDbPeldany();
    }

    /**
     * A connect(), isConnect() és disconnect() metódusok tesztelése.
     *
     * @throws JPA hiba esetén
     */
    @Test
    public void testForDataBase1() throws Exception {
        System.out.print("Test for connectDB...");
        DB.connectDB(); //Exception esetén automatikusan hiba jön
        System.out.println("[OK]");

        System.out.print("Test for isConnected...");
        Assert.assertTrue(DB.connected());
        System.out.println("[OK]");

        System.out.print("Test for disconnectDB...");
        DB.disconnectDB();
        Assert.assertFalse(DB.connected());
        System.out.println("[OK]");
    }
    
}
