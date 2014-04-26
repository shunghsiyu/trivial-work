/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private static final DecimalFormat decimalFormat = 
            new DecimalFormat("###,###,###,###.00");
    private double salary;
    private double bonus;

    public ShiftSupervisor() {
    }

    public ShiftSupervisor(String name, String employeeNumber, 
            String hireDateString, double annualSalary, double productionBonus) 
    {
        super(name, employeeNumber, hireDateString);
        this.salary = annualSalary;
        this.bonus = productionBonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
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
