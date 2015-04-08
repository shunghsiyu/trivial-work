/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.retailitem;

import programming2.ch6.employee.Employee;

/**
 *
 * @author yus
 */
public class driving_program {
    
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        employees[1] = new Employee("Mark Jones", 39119, "IT", "Programmer");
        employees[2] = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");
        
        int padding = 18;
        System.out.print(pad("Name", padding));
        System.out.print(pad("ID Number", padding));
        System.out.print(pad("Department", padding));
        System.out.println(pad("Position", padding));
        System.out.println(pad("",padding*4).replace(' ', '-'));
        for(Employee employee : employees) {
            System.out.print(pad(employee.getName(), padding));
            System.out.print(pad(String.valueOf(employee.getIdNumber()), padding));
            System.out.print(pad(employee.getDepartment(), padding));
            System.out.println(pad(employee.getPosition(), padding));
        }
        
    }
    
    //Turn a string into a certian length by filling it with trailing spaces
    public static String pad(String originalString, int length) {
        return String.format("%1$-" + length + "s", originalString);
    }
}
