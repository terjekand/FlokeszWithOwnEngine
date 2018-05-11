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
package TestForBear;

import com.mycompany.flokeszownengine.BL.Bear;
import com.mycompany.flokeszownengine.BL.Character;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author Dávid
 */
@RunWith(JfxRunner.class)
public class Test2 {
    Character flokesz;
    Bear bear;
    @BeforeClass
    public static void sep(){
        System.out.println("\n##### T E S T S    F O R    B E A R    C L A S S #####\n");
    }
    @Before
    public void init(){
        bear = new Bear();
        flokesz = new Character();
    }
    /**
     * A medve kezdo eletenek tesztje.
     */
    @Test
    public void testBearHp(){
        System.out.print("Testig bear start Hp...");
        Integer value = 100;
        Integer bearHp = bear.getHealth();
        Assert.assertEquals(bearHp, value);
        System.out.println("[OK]");
    }
    /**
     * A medve kezdokepenek letezese (jol lett-e beallitva).
     */
    @Test
    public void testBearImageVaildate(){
        System.out.print("Testig bear Image...");
        Assert.assertNotNull(bear.getImage());
        System.out.println("[OK]");
    }
    

    /**
     * A medve ImageView-enek a tesztje.
     */
    @Test
    public void testBearView(){
        System.out.print("Testig bear View...");
        Assert.assertNotNull(bear.getView());
        System.out.println("[OK]");
    }
    /**
     * A medve eletenek beallitasat teszteli.
     */
    
    @Test
    public void testBearHealthSetter(){
        System.out.print("Testig bear Heath Getter...");
        bear.setHealth(80);
        Integer value = 80;
        Integer bearHealth = bear.getHealth();
        Assert.assertEquals(bearHealth,value);
        
        bear.setHealth(-400);
        bearHealth = bear.getHealth();
        value = -400;
        Assert.assertEquals(bearHealth,value);
        
        System.out.println("[OK]");
    }
    /**
     * A medve hatralokeset teszteli.
     */
    @Test
    public void testBackL(){
        System.out.print("Testig bear toBackL...");
        flokesz.getPlayer().setX(400);
        bear.getView().setX(850);
        Assert.assertTrue(bear.toBackL(flokesz));
        
        System.out.println("[OK]");
    }
    
    
    
    
    @After
    public void killTest(){
        
    }
     @AfterClass
    public static void killClasss() throws Exception {
    }
    
}
