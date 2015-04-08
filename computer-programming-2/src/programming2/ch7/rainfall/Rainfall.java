/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

-----------------------------------------------
|                 Rainfall                    |
-----------------------------------------------
| - yearRainfall: double[]                    |
-----------------------------------------------
| + Rainfall()                                |
| + Rainfall(yearRainfall: double[])          |
| + getTotal(): double                        |
| + getAverage(): double                      |
| + getMost(): double                         |
| + getLeast(): double                        |
| + getMonthRainfall(month: String): double   |
-----------------------------------------------

*/

package programming2.ch7.rainfall;

/**
 * The Rainfall class stores the rainfall of different months in a year 
 * and provides methods to calculate total, average, maximum and minimum 
 * rainfall in a year.
 * 
 * @author Shung-Hsi Yu 
 * ID#0906172
 */
public class Rainfall {
    /**
     * The first three letters of the months
     */
    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May",
                             "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private double[] yearRainfall;

    /**
     * Rainfall class constructor that takes no parameter and initialize 
     * this.yearRainfall to a double array with twelve elements.
     */
    public Rainfall() {
        this.yearRainfall = new double[12];
    }

    /**
     * Rainfall class constructor that takes a double array as parameter 
     * and takes the value inside and store it to this.yearRainfall.
     * If the input array is shorter than twelve elements the remaining months 
     * are filled with zero, while values after the twelfth element are omitted.
     * @param yearRainfall double array holds the rainfall
     */
    public Rainfall(double[] yearRainfall) {
        this.yearRainfall = new double[12];
        int arrayLength = MONTHS.length;
        if(yearRainfall.length < MONTHS.length)
            arrayLength = yearRainfall.length;
        System.arraycopy(yearRainfall, 0, this.yearRainfall, 0, arrayLength);
    }
    
    /**
     * Returns the total rainfall in this Rainfall instance.
     * @return the total rainfall
     */
    public double getTotal() {
        double total = 0;
        for(double rainfall: yearRainfall)
            total = total + rainfall;
        return total;
    }
    
    /**
     * Returns the average rainfall in this Rainfall instance.
     * @return the average rainfall
     */
    public double getAverage() {
        return getTotal()/this.yearRainfall.length;
    }
    
    /**
     * Returns the maximum rainfall in this Rainfall instance
     * @return the maximum rainfall
     */
    public double getMost() {
        double most = 0;
        for(double rainfall: yearRainfall)
            if(most < rainfall)
                most = rainfall;
        return most;
    }
    
    /**
     * Returns the minimum rainfall in this Rainfall instance
     * @return the minimum rainfall
     */
    public double getLeast() {
        double least = yearRainfall[0];
        for(double rainfall: yearRainfall)
            if(least > rainfall)
                least = rainfall;
        return least;
    }
    
    /**
     * Returns the rainfall of a certain month. 
     * @param month the first three letters of the month to query. (e.g. "Jan")
     * @return rainfall of the queried month or NaN if cannot be found
     */
    public double getMonthRainfall(String month) {
        double rainfall = Double.NaN;
        for(int i = 0; i < this.yearRainfall.length; i++) {
            if(month.equalsIgnoreCase(MONTHS[i])) {
                rainfall = this.yearRainfall[i];
                break;
            }
        }
        return rainfall;
    }
}
