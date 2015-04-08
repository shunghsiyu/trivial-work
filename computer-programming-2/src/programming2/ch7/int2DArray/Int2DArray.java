/*                            UML
 * --------------------------------------------------------------
 * |                       Int2DArray                           |
 * --------------------------------------------------------------
 * |                                                            |
 * --------------------------------------------------------------
 * | + Int2DArray()                                             |
 * | + getAverage(inputArray: int[][]): double                  |
 * | + getColumnTotal(inputArray: int[][], column: int): int    |
 * | + getHighestInRow(inputArray: int[][], row: int): int      |
 * | + getLowestInRow(inputArray: int[][], row: int): int       |
 * | + getRowTotal(inputArray: int[][], row: int): int          |
 * | + getTotal(inputArray: int[][]): int                       |
 * --------------------------------------------------------------
 */

package programming2.ch7.int2DArray;

/**
 * Chapter 07 Programming Challenges 15.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 9, 2014
 */
public class Int2DArray {
    /**
     * An empty default constructor.
     */
    public Int2DArray() {
    }
    
    /**
     * Calculate the total of all the values in the array.
     * @param inputArray the array to do the calculation on.
     * @return the total of all the values in the array.
     */
    public int getTotal(int[][] inputArray) {
        int total = 0;
        for(int row = 0; row < inputArray.length; row++) {
            for(int column = 0; column < inputArray[row].length; column++) {
                total = total + inputArray[row][column];
            }
        }
        return total;
    }

    /**
     * Calculate the average of all the values in the array.
     * @param inputArray the array to do the calculation on.
     * @return the average of all the values in the array.
     */
    public double getAverage(int[][] inputArray) {
        int numRow = inputArray.length;
        int numColumn = inputArray[0].length;
        double count = numRow * numColumn;
        return getTotal(inputArray)/count;
    }

    /**
     * Calculate the total of all the values in the specified row of the array.
     * @param inputArray the array to do the calculation on.
     * @param row the row in array to do the calculation on.
     * @return the total of all the values in the specified row of the array.
     */
    public int getRowTotal(int[][] inputArray, int row) {
        int rowTotal = 0;
        for(int column = 0; column < inputArray[row].length; column++) {
            rowTotal = rowTotal + inputArray[row][column];
        }
        return rowTotal;
    }

    /**
     * Calculate the total of all the values in the specified column of the 
     * array.
     * @param inputArray the array to do the calculation on.
     * @param column the column in array to do the calculation on.
     * @return the total of all the values in the specified column of the array.
     */
    public int getColumnTotal(int[][] inputArray, int column) {
        int columnTotal = 0;
        for(int row = 0; row < inputArray.length; row++) {
            columnTotal = columnTotal + inputArray[row][column];
        }
        return columnTotal;
    }

    /**
     * Get the highest value in the specified row of the array.
     * @param inputArray the array to do the calculation on.
     * @param row the row in array to do the calculation on.
     * @return the highest value in the specified row of the array.
     */
    public int getHighestInRow(int[][] inputArray, int row) {
        int rowHighest = 0;

        for(int column = 0; column < inputArray[row].length; column++) {

            if(rowHighest < inputArray[row][column]) {
                rowHighest = inputArray[row][column];
            }

        }

        return rowHighest;
    }

    /**
     * Get the lowest value in the specified row of the array.
     * @param inputArray the array to do the calculation on.
     * @param row the row in array to do the calculation on.
     * @return the lowest value in the specified row of the array.
     */
    public int getLowestInRow(int[][] inputArray, int row) {
        int rowLowest = inputArray[row][0];

        for(int column = 0; column < inputArray[row].length; column++) {

            if(rowLowest > inputArray[row][column]) {
                rowLowest = inputArray[row][column];
            }

        }

        return rowLowest;
    }
}
