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
     * A medve balra torteno hatralokeset teszteli.
     */
    @Test
    public void testBackL(){
        System.out.print("Testig bear toBackL...");//214
        flokesz.getPlayer().setX(210);
        bear.getView().setX(0);
        Assert.assertTrue(bear.toBackL(flokesz));
        
        flokesz.getPlayer().setX(210);
        bear.getView().setX(105);
        Assert.assertTrue(bear.toBackL(flokesz));
        
        flokesz.getPlayer().setX(400);
        bear.getView().setX(105);
        Assert.assertFalse(bear.toBackL(flokesz));
        
        
        flokesz.getPlayer().setX(400);
        bear.getView().setX(800);
        Assert.assertFalse(bear.toBackL(flokesz));
        System.out.println("[OK]");
    }
    
    
     /**
     * A medve jobbra torteno hatralokeset teszteli.
     */
    @Test
    public void testBackR(){
        System.out.print("Testig bear toBackR...");//214
        bear.getView().setX(140);
        flokesz.getPlayer().setX(0);
        Assert.assertTrue(bear.toBackR(flokesz));
        
        bear.getView().setX(70);
        flokesz.getPlayer().setX(0);
        Assert.assertTrue(bear.toBackR(flokesz));
        
        flokesz.getPlayer().setX(400);
        bear.getView().setX(105);
        Assert.assertFalse(bear.toBackR(flokesz));
        
        
        flokesz.getPlayer().setX(400);
        bear.getView().setX(800);
        Assert.assertFalse(bear.toBackR(flokesz));
        System.out.println("[OK]");
    }
    
    /**
     * Az update elso tesztje.
     * A tesztnel a koncked valtozo beallitasat nezem.
     */
    @Test
    public void testUpdate1(){
        System.out.print("Testig bear Update1...");//214
        bear.getView().setX(140);
        flokesz.getPlayer().setX(0);
        Assert.assertTrue(bear.toBackR(flokesz));
        bear.update(flokesz);
        Assert.assertEquals(bear.getKnocked(), 8);
        System.out.println("[OK]");        
    }
    
    /**
     * Az update masodik tesztje.
     * A tesztnel a medve elet csokkeneset nezem.
     * Flokesz utes = false eseten.
     */
    @Test
    public void testUpdate2(){
        System.out.print("Testig bear Update2...");//214
        bear.getView().setX(140);
        flokesz.getPlayer().setX(0);
        Assert.assertTrue(bear.toBackR(flokesz));
        bear.update(flokesz);
        Assert.assertEquals(bear.getHealth(), 100);
        System.out.println("[OK]");
    }
    
    /**
     * Az update masodik tesztje.
     * A tesztnel a medve elet csokkeneset nezem.
     * Flokesz utes = true eseten.
     */
    @Test
    public void testUpdate3(){
        System.out.print("Testig bear Update3...");//214
        bear.getView().setX(140);
        flokesz.getPlayer().setX(0);
        flokesz.setUtes(true);
        Assert.assertTrue(bear.toBackR(flokesz));
        bear.update(flokesz);
        Assert.assertEquals(bear.getHealth(), 50);
        
        bear.getView().setX(140);
        flokesz.getPlayer().setX(0);
        flokesz.setUtes(true);
        bear.setKnocked(0);
        bear.update(flokesz);
        Assert.assertEquals(bear.getHealth(), 0);
        
        System.out.println("[OK]");
    }
    
    
    /**
     * Az update masodik tesztje.
     * A tesztnel a karakter elet csokkeneset nezem.
     * Flokesz utes = true eseten.
     */
    @Test
    public void testUpdate4(){
        System.out.print("Testig bear Update4...");//214
        for(int i = 80; i > 0; i -= 20){
            bear.getView().setX(140);
            flokesz.getPlayer().setX(0);
            Assert.assertTrue(bear.toBackR(flokesz));
            bear.setKnocked(0);
            bear.update(flokesz);
            Assert.assertEquals(i, flokesz.getHp());
        }
        
        System.out.println("[OK]");
    }
    
    
    
    @After
    public void killTest(){
        
    }
     @AfterClass
    public static void killClasss() throws Exception {
    }
    
}
