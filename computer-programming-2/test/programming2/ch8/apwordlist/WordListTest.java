/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.apwordlist;

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
public class WordListTest {
    public static String[] animalArray = {"cat", "mouse", "frog", "dog", "dog"};
    
    public WordListTest() {
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
     * Test of numWordsOfLength method, of class WordList.
     */
    @Test
    public void testNumWordsOfLength() {
        System.out.println("numWordsOfLength");
        int len = 4;
        WordList instance = new WordList(animalArray);
        int expResult = 1;
        int result = instance.numWordsOfLength(len);
        assertEquals(expResult, result);
        
        len = 3;
        expResult = 3;
        result = instance.numWordsOfLength(len);
        assertEquals(expResult, result);
        
        len = 2;
        expResult = 0;
        result = instance.numWordsOfLength(len);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeWordsOfLength method, of class WordList.
     */
    @Test
    public void testRemoveWordsOfLength() {
        System.out.println("removeWordsOfLength");
        WordList instance = new WordList(animalArray);
        instance.removeWordsOfLength(4);
        String expResult = "[\"cat\", \"mouse\", \"dog\", \"dog\"]";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance.removeWordsOfLength(3);
        expResult = "[\"mouse\"]";
        result = instance.toString();
        assertEquals(expResult, result);
        
        instance.removeWordsOfLength(2);
        expResult = "[\"mouse\"]";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class WordList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WordList instance = new WordList(animalArray);
        String expResult = "[\"cat\", \"mouse\", \"frog\", \"dog\", \"dog\"]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
