/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.employee;

/**
 *
 * @author yus
 */
public class Employee {
    private String name;
    private int idNumber;
    private String department;
    private String position;
    
    //Constructor that doesn't take any variable and sets name, department and position to blank and id number to 0
    public Employee() {
        this("", 0, "", "");
    }
    
    //Constructor that takes and sets the name and id number and leaves other fields as blank
    public Employee(String _name, int _idNumber) {
        this(_name, _idNumber, "", "");
    }
    
    //Constructor that sets all instance variables
    public Employee(String _name, int _idNumber, String _department, String _position) {
        this.name = _name;
        this.idNumber = _idNumber;
        this.department = _department;
        this.position = _position;
    }
    
    //Return the name of this employee instance
    public String getName() {
        return this.name;
    }
    
    //Return the id number of this employee instance
    public int getIdNumber() {
        return this.idNumber;
    }
    
    //Return the department that this employee instance belongs to
    public String getDepartment() {
        return this.department;
    }
    
    //Return the position/title of this employee instance
    public String getPosition() {
        return this.position;
    }
    
    //Set the name of this employee instance
    public void setName(String _name) {
        this.name = _name;
    }
    
    //Set the id number of this employee instance
    public void setIdNumber(int _idNumber) {
        this.idNumber = _idNumber;
    }
    
    //Set the department that this employee instance belongs to
    public void setDepartment(String _department) {
        this.department = _department;
    }
    
    //Set the position of this employee instance
    public void setPosition(String _position) {
        this.position = _position;
    }
}
