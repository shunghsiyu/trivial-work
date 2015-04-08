/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.pet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 */
public class KennelTest {
    
    public KennelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of allSpeak method, of class Kennel.
     */
    @Test
    public void testToString() {
        System.out.println("allSpeak");
        Kennel instance = new Kennel();
        instance.addPet(new Dog("Ruffy"));
        instance.addPet(new Cat("Tom"));
        instance.addPet(new LoudDog("Barker"));
        instance.allSpeak();
        String expected = "Ruffy: woof\n"
                        + "Tom: meow\n"
                        + "Barker: woof woof";
        String result = instance.toString();
        assertEquals(expected, result);
    }
    
}
