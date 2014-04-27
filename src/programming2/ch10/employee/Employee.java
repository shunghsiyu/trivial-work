/*
                                    UML
-----------------------------------------------------------------------------
|                                 Employee                                  |
-----------------------------------------------------------------------------
| - name: String                                                            |
| - employeeNumber: String                                                  |
| - hireDate: Date                                                          |
-----------------------------------------------------------------------------
| + Employee()                                                              |
| + Employee(name: String, employeeNumber: String, hireDateString: String)  |
| + getName(): String                                                       |
| + setName(name: String): void                                             |
| + getEmployeeNumber(): String                                             |
| + setEmployeeNumber(name: String): void                                   |
| - checkEmployeeNumber(employeeNumber: String): String                     |
| + getHireDate(): String                                                   |
| + setHireDate(hireDateString: String): void                               |
| - parseDate(dateString: String): Date                                     |
| + toString(): String                                                      |
-----------------------------------------------------------------------------
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
    // For parsing the hire date
    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private String name;
    private String employeeNumber;
    private Date hireDate;

    /**
     * Default constructor for the Employee class.
     */
    public Employee() {
    }
    
    /**
     * Constructor for the Employee class.
     * @param name name of the employee
     * @param employeeNumber employee's number
     * @param hireDateString date that the employee was hired
     */
    public Employee(String name, String employeeNumber, String hireDateString) {
        this.name = name;
        this.employeeNumber = checkEmployeeNumber(employeeNumber);
        this.hireDate = parseDate(hireDateString);
    }

    /**
     * Get the name of the employee.
     * @return name of the employee
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the employee
     * @param name name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the employee's number.
     * @return employee's number
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Set the employee's number
     * @param employeeNumber employee's number
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = checkEmployeeNumber(employeeNumber);
    }
    
    /**
     * Checks if the input employee number is in the correct format.
     * @param employeeNumber employee's number to check
     * @return the input employee number
     */
    private String checkEmployeeNumber(String employeeNumber) {
        if(!employeeNumber.matches("[0-9]{3}-[A-M]")) {
            throw new IllegalArgumentException("Employee number has the wrong "
                    + "format");
        }
        return employeeNumber;
    }

    /**
     * Get the employee's hire date.
     * @return the employee's hire date
     */
    public String getHireDate() {
        return dateFormat.format(hireDate);
    }

    /**
     * Set the employee's hire date
     * @param hireDateString the employee's hire date
     */
    public void setHireDate(String hireDateString) {
        this.hireDate = parseDate(hireDateString);
    }
    
    /**
     * Parse a string representation of date into a date object.
     * @param dateString string to parse
     * @return date object of the parsed string
     */
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
    
    /**
     * Return a string representation of this Employee instance.
     * @return string representation of this employee instance
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(getName());
        sb.append(String.format("%n"));
        sb.append("Employee Number: ");
        sb.append(getEmployeeNumber());
        sb.append(String.format("%n"));
        sb.append("Hire Date: ");
        sb.append(getHireDate());
        return sb.toString();
    }
}
