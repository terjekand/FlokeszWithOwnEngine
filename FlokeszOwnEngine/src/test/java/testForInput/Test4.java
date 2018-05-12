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
package testForInput;

import com.mycompany.flokeszownengine.BL.Input;
import com.mycompany.flokeszownengine.BL.Character;
import com.mycompany.flokeszownengine.BL.Menu;
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
public class Test4 {
    Input input;
    Character flokesz;
    @BeforeClass
    public static void sep(){
        System.out.println("\n##### T E S T S    F O R    I N P U T    C L A S S #####\n");
    }
    @Before
    public void init(){
        flokesz = new Character();
        input = new Input(flokesz);
    }
    /**
     * A jobbra mozgas tesztje.
     */
    @Test
    public void testRightMovement(){
        System.out.print("Test Right Movement...");
        Double value1 = flokesz.getPlayer().getX();
        input.applyRightMovement();
        Double value2 = flokesz.getPlayer().getX();
        Assert.assertNotEquals(value1, value2);
        Assert.assertTrue(flokesz.isJobbra());
        System.out.println("[OK]");
    }
    
    /**
     * A balra mozgas tesztje.
     */
    @Test
    public void testLeftMovement(){
        System.out.print("Test Left Movement...");
        Double value1 = flokesz.getPlayer().getX();
        input.applyLeftMovement();
        Double value2 = flokesz.getPlayer().getX();
        Assert.assertNotEquals(value1, value2);
        Assert.assertFalse(flokesz.isJobbra());
        System.out.println("[OK]");
    }
        
    
    /**
     * Az utest tesztelese Jobbra.
     */
    @Test
    public void testHitAction(){
        
        System.out.print("Test Hit Action to Right...");
        
        input.doHitAction();
        Double value1 = 90.0;
        Double value2 = flokesz.getWeapon().getWeapon().getRotate();
        Assert.assertEquals(value1, value2);
        
        System.out.println("[OK]");
                
    }
    /**
     * Az utest tesztelese Balra.
     */
    @Test
    public void testLeftHitAction(){
        
        System.out.print("Test Hit Action to Hit To Left...");
        input.applyLeftMovement();
        input.doHitAction();
        Double value1 = -90.0;
        Double value2 = flokesz.getWeapon().getWeapon().getRotate();
        Assert.assertEquals(value1, value2);
        
        System.out.println("[OK]");
                
    }
    
    
    /**
     * 50 utest tesztelese Balra.
     */
    @Test
    public void test50LeftHitAction(){
        
        System.out.println("Test 50 Hit Action to Hit To Left...");
        input.applyLeftMovement();
        Double value1 = -90.0;
        Double zeroValue = 0.0;
        Double value2;
        for(int i = 0; i < 50; i++){
            input.doHitAction();
            value2 = flokesz.getWeapon().getWeapon().getRotate();
            if(i % 2 == 0)
                Assert.assertEquals(value1, value2);
            else
                Assert.assertEquals(zeroValue, value2);
            System.out.print("#");
        }
        
        System.out.println("[OK]");
                
    }
    /**
     * 50 utest tesztelese Jobbra.
     */
    @Test
    public void test50RightHitAction(){
        
        System.out.println("Test 50 Hit Action to Hit To Left...");
        //input.applyLeftMovement();
        Double value1 = 90.0;
        Double zeroValue = 0.0;
        Double value2;
        for(int i = 0; i < 50; i++){
            input.doHitAction();
            value2 = flokesz.getWeapon().getWeapon().getRotate();
            if(i % 2 == 0)
                Assert.assertEquals(value1, value2);
            else
                Assert.assertEquals(zeroValue, value2);
            System.out.print("#");
        }
        
        System.out.println("[OK]");
                
    }
    /**
     * 25 utest tesztelese Jobbra es 25 Balra.
     */
    @Test
    public void testMixedHit(){
        
        System.out.println("Test 50 Mixed Hit...");
        //input.applyLeftMovement();
        Double value1;
        Double zeroValue = 0.0;
        Double value2;
        for(int i = 0; i < 50; i++){
            if(i % 2 == 0){
                input.applyRightMovement();
                value2 = flokesz.getWeapon().getWeapon().getRotate();
                Assert.assertEquals(zeroValue, value2);
                input.doHitAction();
                value2 = flokesz.getWeapon().getWeapon().getRotate();
                value1 = 90.0;
                Assert.assertEquals(value1, value2);
            }
            else{
                input.applyLeftMovement();
                value2 = flokesz.getWeapon().getWeapon().getRotate();
                Assert.assertEquals(zeroValue, value2);
                input.doHitAction();
                value2 = flokesz.getWeapon().getWeapon().getRotate();
                value1 = -90.0;
                Assert.assertEquals(value1, value2);
            }
            System.out.print("#");
        }
        
        System.out.println("[OK]");
                
    }
    
    /**
     * Az utest tesztelese visszafele.
     */
    @Test
    public void testRevHit(){
        
        System.out.print("Test Hit Action to Default1...");
        
        input.doHitAction();
        input.doHitAction();
        Double value1 = 0.0;
        Double value2 = flokesz.getWeapon().getWeapon().getRotate();
        Assert.assertEquals(value1, value2);
        
        System.out.println("[OK]");        
    }
    
    /**
     * Az atjutas tesztje.
     */
    @Test
    public void testPass(){
        System.out.print("Test character Pass Acces...");
        Menu menu = new Menu();
        flokesz.getPlayer().setX(menu.getTablaPoz());
        input.tryToPass();
        Assert.assertTrue(flokesz.getPass());
        System.out.println("[OK]");    
    }
    
    @After
    public void killTest(){
        
    }
     @AfterClass
    public static void killClasss() throws Exception {
    }
    
}
