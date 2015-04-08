/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package programming2.ch7.rainfall;

/**
 * @author Shung-Hsi Yu 
 * ID#0906172
 */
public class driving_program {
    
    public static void main(String[] args) {
        //Initialize a double array to store the rainfaill for each month
        double[] yearRainfall = new double[12];
        //Store the rainfall into the double array
        yearRainfall[0] = 0.40;
        yearRainfall[1] = 0.94;
        yearRainfall[2] = 3.21;
        yearRainfall[3] = 3.74;
        yearRainfall[4] = 1.73;
        yearRainfall[5] = 1.03;
        yearRainfall[6] = 1.27;
        yearRainfall[7] = 2.58;
        yearRainfall[8] = 6.98;
        yearRainfall[9] = 6.90;
        yearRainfall[10] = 2.80;
        yearRainfall[11] = 2.53;
        //Create a Rainfall class instance and pass the double array
        Rainfall rainfall = new Rainfall(yearRainfall);
        
        //Display the results
        System.out.println("Austin Tx  Rainfall 2009");
        for(int i = 0; i < Rainfall.MONTHS.length; i++) {
            String month = Rainfall.MONTHS[i];
            System.out.println(" " + month + "\t\t" +
                            rainfall.getMonthRainfall(month));
        }
        System.out.println(" Average\t" + rainfall.getAverage());
        System.out.println(" Max\t\t" + rainfall.getMost());
        System.out.println(" Min\t\t" + rainfall.getLeast());
        
    }
}
