package testForCharacter;

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
public class Test1 {
    Character flokesz;
    @BeforeClass
    public static void sep(){
        System.out.println("\n##### T E S T S    F O R    C H A R A C T E R    C L A S S #####\n");
    }
    @Before
    public void init(){
        flokesz = new Character();
    }
    /**
     * A karakter kepenek letezeset teszteli.
    */
     @Test
    public void testCharacterImg(){
        System.out.print("Testing player Image...");
        Assert.assertNotNull(flokesz.getImg());
        System.out.println("[OK]");
    }
    @Test
    /**
     * Az aktualis elet visszaadasat teszteli.
     */
    public void testCharacterHP(){
        System.out.print("Testing player CurrHp...");
        Integer hp = 100;
        Integer flokeszHp = flokesz.getHp();
        Assert.assertEquals(hp, flokeszHp);
        System.out.println("[OK]");
    }
    @Test
    /**
     * Az aktualis elet modositasat teszteli.
     */
    public void testCharacterHPMod(){
        System.out.print("Testing player HP Modification...");
        Integer hp = 80;
        flokesz.setHp(-20);
        Integer flokeszHp = flokesz.getHp();
        Assert.assertEquals(hp, flokeszHp);
        hp = 120;
        flokesz.setHp(40);
        flokeszHp = flokesz.getHp();
        Assert.assertEquals(hp, flokeszHp);
        System.out.println("[OK]");
    }
    @Test
    /**
     * A hatralokes kezdoerteket tesztel.
     */
    public void testFlokeszBacked(){
        System.out.print("Testing player Back Counter...");
        Integer FlokeszBacked = flokesz.getBacked();
        Integer value = 0;
        Assert.assertEquals(value, FlokeszBacked);
        System.out.println("[OK]");
    }
    @Test
    /**
     * A fegyver letezeset teszteli.
     */
    public void testFlokeszWeapon(){
        System.out.print("Testing player Weapon...");
        Assert.assertNotNull(flokesz.getWeapon());
        System.out.println("[OK]");
    }
    @Test
    /**
     * A Score szamalalo kezdoerteket teszteli.
     */
    public void testFlokeszKillCounter(){
        System.out.print("Testing player KillCounter...");
        Integer FlokeszKill = flokesz.getKillCount();
        Integer value = 0;
        Assert.assertEquals(FlokeszKill, value);
        System.out.println("[OK]");
    }
    @Test
    /**
     * Az atjutashoz szukseges logiakai valtozo (Pass) kezdoerteket teszteli.
     */
    public void testFlokeszPass(){
        System.out.print("Testing player Pass Access...");
        Assert.assertFalse(flokesz.getPass());
        System.out.println("[OK]");
    }
    
    @Test
    /**
     * A pass modositasara szolgalo fuggvenyt teszteli.
     */
    public void testFlokeszPassMod(){
        System.out.print("Testing player Pass Modification...");
        flokesz.setPass(true);
        Assert.assertTrue(flokesz.getPass());
        flokesz.setPass(false);
        Assert.assertFalse(flokesz.getPass());
        System.out.println("[OK]");
    }
    
    @Test
    /**
     * Az utesvaltozo alaphelyzetet teszteli.
     */
    public void testFlokeszUtes(){
        System.out.print("Testing player Hit...");
        Assert.assertFalse(flokesz.getUtes());
        System.out.println("[OK]");
    }
    /**
     * Az utes beallitasara szolgalo valtozo tesztelese.
     */
    @Test
    public void testFlokeszUtesMod(){
        System.out.print("Testing player Hit Modification...");
        flokesz.setUtes(true);
        Assert.assertTrue(flokesz.getUtes());
        flokesz.setUtes(false);
        Assert.assertFalse(flokesz.getUtes());
        System.out.println("[OK]");
    }
    /**
     * Az imaget megjelenito ImageView tartalmat tesztelem.
     */
    @Test
    public void testFlokeszImageView(){
        System.out.print("Testing player ImageView...");
        Assert.assertNotNull(flokesz.getPlayer());
        System.out.println("[OK]");
    }
    /**
     * A hatralokes tesztelese mind a ket iranyba.
     * Megnezem jobbra
     * Megnezem ezutan balra(alaphelyzet)
     * Megnezem ezutan megint balra
     */
    @Test
    public void testFlokeszToBack1(){
        System.out.print("Testing player Apply Backward...");
        Double currLocPlayer = flokesz.getPlayer().getX();
        Double currLocPlayerWeapon = flokesz.getWeapon().getWeapon().getX();
        //Jobbra
        flokesz.applyBackward(1);
        Double currLocPlayerMod = flokesz.getPlayer().getX();
        Double currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        //Teszt
        Assert.assertNotEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertNotEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        //Balra(alaphelyzet)
        flokesz.applyBackward(-1);
        currLocPlayerMod = flokesz.getPlayer().getX();
        currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        //Teszt
        Assert.assertEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        //Balra megint
        flokesz.applyBackward(-1);
        currLocPlayerMod = flokesz.getPlayer().getX();
        currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        //Teszt
        Assert.assertNotEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertNotEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        
        System.out.println("[OK]");
    }
    /**
     * A karakter hatralokesenek erzekelese a backed valtozonak a figyelesevel.
     */
    @Test
    public void testFlokeszToBack2(){
        System.out.println("Testing player Apply Backward...");
        System.out.println("Test 50 times the backed parameter");
        for(int i = 0; i < 50; i++){
            flokesz.applyBackward(1);
            System.out.print("#");
        }
            
        
        Assert.assertEquals(-50, flokesz.getBacked());
        
        System.out.println("[OK]");
    }
    /**
     * Hatralokes utan X koordinata figyelese pozitiv irany.
     */
    @Test
    public void testFlokeszToBack3(){
        System.out.println("Testing player Apply Backward...");
        System.out.println("Test 50 times the back motion to Right...");
        for(int i = 0; i < 50; i++){
            flokesz.applyBackward(1);
            System.out.print("#");
        }
        Double value1 = 2600.0;
        Double value2 = flokesz.getPlayer().getX();
        Assert.assertEquals(value1, value2);
        System.out.println("[OK]");
    }
    
    /**
     * Hatralokes utan X koordinata figyelese negativ irany.
     */
    @Test
    public void testFlokeszToBack4(){
        System.out.println("Testing player Apply Backward...");
        System.out.println("Test 50 times the back motion to Left...");
        for(int i = 0; i < 50; i++){
            flokesz.applyBackward(-1);
            System.out.print("#");
        }
        Double value1 = -2400.0;
        Double value2 = flokesz.getPlayer().getX();
        Assert.assertEquals(value1, value2);
        System.out.println("[OK]");
    }
    /**
     * Hatralokes utan X koordinata figyelese pozitiv irany.
     * (fegyver)
     */
    @Test
    public void testFlokeszWeaponToBack1(){
        System.out.println("Testing player's weapon Apply Backward...");
        System.out.println("Test 50 times the back motion to Left...");
        Double value1 = flokesz.getWeapon().getWeapon().getX() + 50 * 50;
        for(int i = 0; i < 50; i++){
            flokesz.applyBackward(1);
            System.out.print("#");
        }
        
        Double value2 = flokesz.getWeapon().getWeapon().getX();
        Assert.assertEquals(value1, value2);
        System.out.println("[OK]");
    }
    
       /**
     * Hatralokes utan X koordinata figyelese negativ irany.
     * (fegyver)
     */
    @Test
    public void testFlokeszWeaponToBack2(){
        System.out.println("Testing player's weapon Apply Backward...");
        System.out.println("Test 50 times the back motion to Left...");
        Double value1 = flokesz.getWeapon().getWeapon().getX() - 50 * 50;
        for(int i = 0; i < 50; i++){
            flokesz.applyBackward(-1);
            System.out.print("#");
        }
        
        Double value2 = flokesz.getWeapon().getWeapon().getX();
        Assert.assertEquals(value1, value2);
        System.out.println("[OK]");
    }
    
    
    /**
     * A karakter score novelesenek a tesztje.
    */
    @Test
    public void testFlokeszKillCountInc(){
        System.out.println("Testing player Score Increaser...");
        
        for(int i = 1; i < 51; i++){
            flokesz.incKillCount();
            Assert.assertEquals(flokesz.getKillCount(), i);
            System.out.print("#");
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
