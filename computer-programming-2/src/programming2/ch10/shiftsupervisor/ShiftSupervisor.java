/*                                 UML
 ----------------------------------------------------------------------------
 |                          ShiftSupervisor                                 |
 ----------------------------------------------------------------------------
 | - salary: double                                                         |
 | - bonus: double                                                          |
 ----------------------------------------------------------------------------
 | + ShiftSupervisor()                                                      |
 | + ShiftSupervisor(name: String, employeeNumber:String,                   |
 |     hireDateString: String, annualSalary: double, productionBonus: double)
 | + getSalary(): double                                                    |
 | + setSalary(salary: double): void                                        |
 | + getBonus(): double                                                     |
 | + setBonus(bonus: double): void                                          |
 | + toString(): String                                                     |
 ----------------------------------------------------------------------------
 */

package programming2.ch10.shiftsupervisor;


import java.text.DecimalFormat;
import programming2.ch10.employee.Employee;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 25, 2014
 */

public class ShiftSupervisor extends Employee {
    // For formatting money
    private static final DecimalFormat decimalFormat = 
            new DecimalFormat("###,###,###,###.00");
    private double salary;
    private double bonus;

    /**
     * Default constructor for ShiftSupervisor class.
     */
    public ShiftSupervisor() {
    }

    /**
     * Constructor for ShiftSupervisor class.
     * @param name name of the shift supervisor
     * @param employeeNumber shift supervisor's number
     * @param hireDateString date the shift supervisor was hired
     * @param annualSalary the shift supervisor's annual salary
     * @param productionBonus the shift supervisor's bonus when the shift meets 
     * the requirement
     */
    public ShiftSupervisor(String name, String employeeNumber, 
            String hireDateString, double annualSalary, double productionBonus) 
    {
        super(name, employeeNumber, hireDateString);
        this.salary = annualSalary;
        this.bonus = productionBonus;
    }

    /** 
     * Get the salary of this shift supervisor.
     * @return the employee's annual salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the salary of this shift supervisor.
     * @param salary the employee's annual salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Get the shift supervisor's bonus when the shift meets the requirement.
     * @return shift supervisor's bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Set the shift supervisor's bonus when the shift meets the requirement.
     * @param bonus shift supervisor's bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    /**
     * Return a string representation of this ShiftSupervisor instance.
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%n"));
        sb.append("Annual Salary: $");
        sb.append(decimalFormat.format(getSalary()));
        sb.append(String.format("%n"));
        sb.append("Production Bonus: $");
        sb.append(decimalFormat.format(getBonus()));
        return sb.toString();
    }
}
