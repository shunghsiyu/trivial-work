/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.employee;

import java.util.Date;
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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of getName method, of class Employee.
     */
    @Test
    public void testSetGetName() {
        System.out.println("setName getName");
        Employee instance = new Employee();
        String expResult = "John Man";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test
    public void testSetGetEmployeeNumber() {
        System.out.println("setEmployeeNumber getEmployeeNumber");
        Employee instance = new Employee();
        String expResult = "931-M";
        instance.setEmployeeNumber(expResult);
        String result = instance.getEmployeeNumber();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmployeeNumberFail() {
        System.out.println("setEmployeeNumber Exception1");
        Employee instance = new Employee();
        String expResult = "93o-M";
        instance.setEmployeeNumber(expResult);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmployeeNumberFail2() {
        System.out.println("setEmployeeNumber Exception2");
        Employee instance = new Employee();
        String expResult = "9311-M";
        instance.setEmployeeNumber(expResult);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmployeeNumberFail3() {
        System.out.println("setEmployeeNumber Exception3");
        Employee instance = new Employee();
        String expResult = "931-Z";
        instance.setEmployeeNumber(expResult);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmployeeNumberFail4() {
        System.out.println("setEmployeeNumber Exception4");
        Employee instance = new Employee();
        String expResult = "931-b";
        instance.setEmployeeNumber(expResult);
    }
    
    /**
     * Test of getEmployeeNumber method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmployeeNumberFail5() {
        System.out.println("setEmployeeNumber Exception5");
        Employee instance = new Employee();
        String expResult = "931-MM";
        instance.setEmployeeNumber(expResult);
    }

    /**
     * Test of setHireDate method, of class Employee.
     */
    @Test
    public void testSetGetHireDate() {
        System.out.println("setHireDate getHireDate");
        String expResult = "01-12-1998";
        Employee instance = new Employee();
        instance.setHireDate(expResult);
        String result = instance.getHireDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHireDate method, of class Employee.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetHireDateFail() {
        System.out.println("setHireDate Exception");
        String expResult = "1o-12-1999";
        Employee instance = new Employee();
        instance.setHireDate(expResult);
        System.out.println(instance.getHireDate());
    }    
}
