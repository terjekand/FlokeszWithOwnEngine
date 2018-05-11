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
import javafx.scene.image.Image;
import org.junit.runner.RunWith;

/**
 *
 * @author Dávid
 */
@RunWith(JfxRunner.class)
public class Test1 {
    Character flokesz;
    @BeforeClass
    public static void setUpClass() throws Exception {
        
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
        Float hp = new Float(100);
        Float flokeszHp = new Float(flokesz.getHp());
        Assert.assertEquals(hp, flokeszHp);
        System.out.println("[OK]");
    }
    @Test
    /**
     * Az aktualis elet modositasat teszteli.
     */
    public void testCharacterHPMod(){
        System.out.print("Testing player HP Modification...");
        Float hp = new Float(80);
        flokesz.setHp(-20);
        Float flokeszHp = new Float(flokesz.getHp());
        Assert.assertEquals(hp, flokeszHp);
        hp = new Float(120);
        flokesz.setHp(40);
        flokeszHp = new Float(flokesz.getHp());
        Assert.assertEquals(hp, flokeszHp);
        System.out.println("[OK]");
    }
    @Test
    /**
     * A hatralokes kezdoerteket tesztel.
     */
    public void testFlokeszBacked(){
        System.out.print("Testing player Back Counter...");
        Integer FlokeszBacked = new Integer(flokesz.getBacked());
        Integer value = new Integer(0);
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
        Integer FlokeszKill = new Integer(flokesz.getKillCount());
        Integer value = new Integer(0);
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
    public void testFlokeszToBack(){
        System.out.print("Testing player Apply Backward...");
        Double currLocPlayer = flokesz.getPlayer().getX();
        Double currLocPlayerWeapon = flokesz.getWeapon().getWeapon().getX();
        
        flokesz.applyBackward(1);
        Double currLocPlayerMod = flokesz.getPlayer().getX();
        Double currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        
        Assert.assertNotEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertNotEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        
        flokesz.applyBackward(-1);
        currLocPlayerMod = flokesz.getPlayer().getX();
        currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        
        Assert.assertEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        
        flokesz.applyBackward(-1);
        currLocPlayerMod = flokesz.getPlayer().getX();
        currLocPlayerWeaponMod = flokesz.getWeapon().getWeapon().getX();
        
        Assert.assertNotEquals(currLocPlayer, currLocPlayerMod);
        Assert.assertNotEquals(currLocPlayerWeaponMod, currLocPlayerWeapon);
        
        System.out.println("[OK]");
    }
    /**
     * A karakterk epmodosito fuggveny tesztelese.
    */
    @Test
    public void testImageMod(){
        System.out.print("Testing player Image Modification...");
        Image image1 = new Image(getClass().getClassLoader().getResource("hd/Flokesz/run/flokesz_run.gif").toString());
        flokesz.setImg("hd/Flokesz/run/flokesz_run.gif");
        Assert.assertEquals(image1, flokesz.getImg());
        
        
        image1 = new Image(getClass().getClassLoader().getResource("hd/Flokesz/run/flokesz_run_R.gif").toString());
        flokesz.setImg("hd/Flokesz/run/flokesz_run_R.gif");
        Assert.assertEquals(image1, flokesz.getImg());
        
        
        System.out.println("[OK]");
    }
    
    @After
    public void killTest(){
        
    }
     @AfterClass
    public static void killClasss() throws Exception {
    }


    
}
