/**
 * Chapter 10 Programming Challenges 1.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 23, 2014
 */

/*
                            UML
-------------------------------------------------------------
|                     ProductionWorker                      |
-------------------------------------------------------------
| - shift: int                                              |
| - payRate: double                                         |
-------------------------------------------------------------
| + ProductionWorker()                                      |
| + ProductionWorker(name: String, employeeNumber: String,  |
|     hireDateString: String, shift: int, payRate: double)  |
| + getShift(): int                                         |
| + setShift(shift: int): void                              |
| - checkShift(shift: int): int                             |
| + getPayRate(): double                                    |
| + setPayRate(payRate: double): void                       |
| - shiftToString(): String                                 |
| + toString(): String                                      |
-------------------------------------------------------------
*/

package programming2.ch10.employee;


public class ProductionWorker extends Employee {
    public static final int DAY_SHIFT = 1;
    public static final int NIGHT_SHIFT = 2;
    private int shift;
    private double payRate;

    /**
     * Default constructor of ProductionWorker class.
     */
    public ProductionWorker() {
    }

    /**
     * Constructor of ProductionWorker class.
     * @param name name of the production worker
     * @param employeeNumber production worker's employee number
     * @param hireDateString date the production worker was hired
     * @param shift the production worker's shift
     * @param payRate the production worker's pay rate
     */
    public ProductionWorker(String name, String employeeNumber, 
            String hireDateString, int shift, double payRate) {
        super(name, employeeNumber, hireDateString);
        this.shift = checkShift(shift);
        this.payRate = payRate;
    }

    /**
     * Get the shift of this production worker
     * @return shift of the production worker
     */
    public int getShift() {
        return shift;
    }

    /**
     * Set the shift of this production worker
     * @param shift shift of the production worker
     */
    public void setShift(int shift) {
        this.shift = checkShift(shift);
    }
    
    /**
     * Check the shift value of this production worker
     * @param shift shift of the production worker
     * @return input shift of the production worker
     * @throws IllegalArgumentException if the shift value is incorrect
     */
    private int checkShift(int shift) {
        if(shift != DAY_SHIFT && shift != NIGHT_SHIFT) {
            throw new IllegalArgumentException("Shift needs to be either day "
                    + "shift or night shift");
        }
        return shift;
    }
    
    /**
     * Get the pay rate of this production worker
     * @return pay rate of the production worker
     */
    public double getPayRate() {
        return payRate;
    }
    
    /**
     * Set the pay rate of this production worker
     * @param payRate pay rate of the production worker
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    /**
     * Return a string representation of the shift.
     * @return string representation of the shift
     */
    private String shiftToString() {
        String shiftString = null;
        if(this.shift == DAY_SHIFT) {
            shiftString = "Day";
        } else if(this.shift == NIGHT_SHIFT) {
            shiftString = "Night";
        }
        return shiftString;
    }
    
    /**
     * Return the string representation of this production worker instance.
     * @return string representation of this production worker instance
     */
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
