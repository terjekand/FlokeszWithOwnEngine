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
package testforWeapon;
import com.mycompany.flokeszownengine.BL.Weapon;
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
public class Test3 {
    Weapon fegyver;
    Character flokesz;
    @BeforeClass
    public static void sep(){
        System.out.println("\n##### T E S T S    F O R    W E A P O N    C L A S S #####\n");
    }
    @Before
    public void init(){
        flokesz = new Character();
        fegyver = new Weapon(flokesz.getPlayer().getX());
    }
    
    /**
     * A fegyver ImageView-jenek tesztje.
     */
    @Test
    public void testForWeaponImage(){
        System.out.print("Testing weapon ImageView...");
        Assert.assertNotNull(fegyver.getWeapon());
        System.out.println("[OK]");
    }
    
    /**
     * A fegyver sebzesenek tesztje.
     */
    @Test
    public void testForWeaponDamage(){
        System.out.print("Testing weapon Damage...");
        Assert.assertEquals(50, fegyver.getDamage());
        System.out.println("[OK]");
    }
    /**
     * A fegyver X koordinatajanak tesztje.
     */
    @Test
    public void testForWeaponX(){
        System.out.print("Testing weapon Position...");
        Double value = flokesz.getPlayer().getX() + 15;
        Double value2 = fegyver.getX();
        Assert.assertEquals(value, value2);
        System.out.println("[OK]");
    }
    
    /**
     * A fegyver jobbra utesenek tesztje.
     */
    @Test
    public void testForWeaponHitR(){
        System.out.print("Testing weapon Rotation to R...");
        fegyver.hitR();
        Double rotation = 90.0;
        Double weaponRotation = fegyver.getWeapon().getRotate();
        Assert.assertEquals(rotation, weaponRotation);
        System.out.println("[OK]");
    }
    
    /**
     * A fegyver balra utesenek tesztje.
     */
    @Test
    public void testForWeaponHitL(){
        System.out.print("Testing weapon Rotation to L...");
        fegyver.hitL();
        Double rotation = -90.0;
        Double weaponRotation = fegyver.getWeapon().getRotate();
        Assert.assertEquals(rotation, weaponRotation);
        System.out.println("[OK]");
    }
   
    
    @After
    public void killTest(){
        
    }
     @AfterClass
    public static void killClasss() throws Exception {
    }
    
}
