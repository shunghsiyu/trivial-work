/*
 * 
 */

package programming2.ch7.int2DArray;

import java.io.PrintStream;

/**
 * Chapter 07 Programming Challenges 15.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 9, 2014
 */
public class Int2DArrayTester {
    public static void main(String[] args) {
        //Create a 2D int array
        int[][] iarray = { { 2, 1, 9},
                           { 7, 3, 4},
                           { 5, 6, 8} };
        
        //Create a Int2DArray instance to work on int array
        Int2DArray arrayOperation = new Int2DArray();
        
        //Create a alias of System.out
        PrintStream o = System.out;
        
        //Print the result of the int array operations
        o.println("Processing iarray.");
        o.println("Total: " + arrayOperation.getTotal(iarray));
        o.println("Average: " + arrayOperation.getAverage(iarray));
        for(int row = 0; row < iarray.length; row++) {
            o.println("Total of row " + row + ": " + 
                      arrayOperation.getRowTotal(iarray, row));
        }
        for(int column = 0; column < iarray[0].length; column++) {
            o.println("Total of col " + column + ": " + 
                      arrayOperation.getColumnTotal(iarray, column));
        }
        for(int row = 0; row < iarray.length; row++) {
            o.println("Highest in row " + row + ": " + 
                      arrayOperation.getHighestInRow(iarray, row));
        }
        for(int row = 0; row < iarray.length; row++) {
            o.println("Total of row " + row + ": " + 
                      arrayOperation.getLowestInRow(iarray, row));
        }
    }
}
