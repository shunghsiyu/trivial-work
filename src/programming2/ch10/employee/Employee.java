/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 23, 2014
 */
public class Employee {
    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private String name;
    private String employeeNumber;
    private Date hireDate;

    public Employee() {
    }
    
    public Employee(String name, String employeeNumber, String hireDateString) {
        this.name = name;
        this.employeeNumber = checkEmployeeNumber(employeeNumber);
        this.hireDate = parseDate(hireDateString);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = checkEmployeeNumber(employeeNumber);
    }
    
    private String checkEmployeeNumber(String employeeNumber) {
        if(!employeeNumber.matches("[0-9]{3}-[A-M]")) {
            throw new IllegalArgumentException("Employee number has the wrong "
                    + "format");
        }
        return employeeNumber;
    }

    public String getHireDate() {
        return dateFormat.format(hireDate);
    }

    public void setHireDate(String hireDateString) {
        this.hireDate = parseDate(hireDateString);
    }
    
    private Date parseDate(String dateString) {
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Hire date has the wrong "
                    + "format");
        }
        return date;
    }
}
