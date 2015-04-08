/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examreview;

import java.math.BigInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 */
public class FibonacciTest {
    
    public FibonacciTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Fibonacci.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Fibonacci.main(args);
    }

    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetNumber0() {
        System.out.println("getNumber");
        int n = 0;
        BigInteger expResult = BigInteger.ZERO;
        BigInteger result = Fibonacci.getNumber(n);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetNumber1() {
        System.out.println("getNumber");
        int n = 1;
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = Fibonacci.getNumber(n);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetNumber2() {
        System.out.println("getNumber");
        int n = 2;
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = Fibonacci.getNumber(n);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetNumber3() {
        System.out.println("getNumber");
        int n = 19;
        BigInteger expResult = new BigInteger("4181");
        BigInteger result = Fibonacci.getNumber(n);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetSequence() {
        System.out.println("getSequence");
        int start = 1;
        int end = 20;
        String expResult = "1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 ";
        String result = Fibonacci.getSequence(start, end);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumber method, of class Fibonacci.
     */
    @Test
    public void testGetSequenceAverage() {
        System.out.println("getSequenceAverage");
        int start = 1;
        int end = 20;
        double expResult = 885.5;
        double result = Fibonacci.getSequenceAverage(start, end);
        assertEquals(expResult, result, 0.001);
    }
    
}
