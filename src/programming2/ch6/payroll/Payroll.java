/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

------------------------------------------
                 Payroll
------------------------------------------
 - employeeName: String
 - id: int
 - payRate: double
 - hours: double
------------------------------------------
 + Payroll(employeeName: String, id: int)
 + getEmployeeName(): String
 + setEmployeeName(employeeName: String): void
 + getId(): int
 + setId(id: int): void
 + getPayRate(): double
 + setPayRate(payRate: double): void
 + getHours(): double
 + setHours(hours: double): void
 + getGrossPay(): double
------------------------------------------
 
 */

package programming2.ch6.payroll;

/**
 *
 * @author yus
 */
public class Payroll {
    private String employeeName;
    private int id;
    private double payRate;
    private double hours;

    public Payroll(String employeeName, int id) {
        this.employeeName = employeeName;
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    public double getGrossPay() {
        double extra = 0;
        if(hours > 40)
            extra = (hours - 40) * payRate * 0.5;
        return payRate * hours + extra;
    }
}
