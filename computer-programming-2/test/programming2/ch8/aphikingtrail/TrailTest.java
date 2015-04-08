/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.aphikingtrail;

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
public class TrailTest {
    public static final int[] markers = {100, 150, 105, 120, 90, 80, 50, 75, 
        75, 70, 80 , 90, 100};
    
    public TrailTest() {
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
     * Test of isLevelTrailSegment method, of class Trail.
     */
    @Test
    public void testIsLevelTrailSegmentTrue() {
        System.out.println("isLevelTrailSegmentTrue");
        int start = 7;
        int end = 10;
        Trail instance = new Trail(markers);
        boolean expResult = true;
        boolean result = instance.isLevelTrailSegment(start, end);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLevelTrailSegment method, of class Trail.
     */
    @Test
    public void testIsLevelTrailSegmentFalse() {
        System.out.println("isLevelTrailSegmentFalse");
        int start = 2;
        int end = 12;
        Trail instance = new Trail(markers);
        boolean expResult = false;
        boolean result = instance.isLevelTrailSegment(start, end);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDifficult method, of class Trail.
     */
    @Test
    public void testIsDifficult() {
        System.out.println("isDifficult");
        Trail instance = new Trail(markers);
        boolean expResult = true;
        boolean result = instance.isDifficult();
        assertEquals(expResult, result);
    }
    
}
