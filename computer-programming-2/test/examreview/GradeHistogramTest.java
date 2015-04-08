/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examreview;

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
public class GradeHistogramTest {
    public static GradeHistogram gradeHistogramToTest;
    
    public GradeHistogramTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        int[] gradesToTest = { 49, 50, 51, 59, 0, 5, 9, 10, 15, 19, 
                50, 55, 89, 99, 100};
        gradeHistogramToTest = new GradeHistogram(gradesToTest);
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
     * Test of main method, of class GradeHistogram.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {""};
        GradeHistogram.main(args);
        // Checks if main can run
    }

    /**
     * Test 1 of getNumbersInRange method, of class GradeHistogram.
     */
    @Test
    public void testGetNumbersInRange1() {
        System.out.println("getNumbersInRange");
        int lowerBound = 0;
        int upperBound = 9;
        GradeHistogram instance = gradeHistogramToTest;
        int expResult = 3;
        int result = instance.getNumbersInRange(lowerBound, upperBound);
        assertEquals(expResult, result);
    }
    
    /**
     * Test 2 of getNumbersInRange method, of class GradeHistogram.
     */
    @Test
    public void testGetNumbersInRange2() {
        System.out.println("getNumbersInRange");
        int lowerBound = 0;
        int upperBound = 59;
        GradeHistogram instance = gradeHistogramToTest;
        int expResult = 12;
        int result = instance.getNumbersInRange(lowerBound, upperBound);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTable method, of class GradeHistogram.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetTableException() {
        System.out.println("getTable");
        int zero = 0;
        GradeHistogram instance = gradeHistogramToTest;
        String result = instance.getTable(zero);
    }
    
    /**
     * Test of getTable method, of class GradeHistogram.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        int range = 10;
        GradeHistogram instance = gradeHistogramToTest;
        String expResult =
                "  0 -  9: ***\n" +
                " 10 - 19: ***\n" +
                " 20 - 29: \n" +
                " 30 - 39: \n" +
                " 40 - 49: *\n" +
                " 50 - 59: *****\n" +
                " 60 - 69: \n" +
                " 70 - 79: \n" +
                " 80 - 89: *\n" +
                " 90 -100: **\n";
        String result = instance.getTable(range);
        assertEquals(expResult, result);
    }
    
}
