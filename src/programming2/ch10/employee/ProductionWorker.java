/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.employee;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 23, 2014
 */
public class ProductionWorker extends Employee {
    public static final int DAY_SHIFT = 1;
    public static final int NIGHT_SHIFT = 2;
    private int shift;
    private double payRate;

    public ProductionWorker() {
    }

    public ProductionWorker(String name, String employeeNumber, 
            String hireDateString, int shift, double payRate) {
        super(name, employeeNumber, hireDateString);
        this.shift = checkShift(shift);
        this.payRate = payRate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = checkShift(shift);
    }
    
    private int checkShift(int shift) {
        if(shift != DAY_SHIFT && shift != NIGHT_SHIFT) {
            throw new IllegalArgumentException("Shift needs to be either day "
                    + "shift or night shift");
        }
        return shift;
    }
    
    private String shiftToString() {
        String shiftString = null;
        if(this.shift == DAY_SHIFT) {
            shiftString = "Day";
        } else if(this.shift == NIGHT_SHIFT) {
            shiftString = "Night";
        }
        return shiftString;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%n"));
        sb.append("Shift: ");
        sb.append(shiftToString());
        sb.append(String.format("%n"));
        sb.append("Hourly Pay Rate: $");
        sb.append(String.format("%.2f", getPayRate()));
        return sb.toString();
    }
}
