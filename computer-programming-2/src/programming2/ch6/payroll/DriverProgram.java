/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

---------------------

---------------------

 */

package programming2.ch6.payroll;

/**
 *
 * @author yus
 */
public class DriverProgram {
    public static void main(String[] args) {
        Payroll[] payrolls = new Payroll[3];
        
        payrolls[0] = new Payroll("Joe Shmo", 1111);
        payrolls[0].setPayRate(15);
        payrolls[0].setHours(50);
        
        payrolls[1] = new Payroll("Sally Smith", 2222);
        payrolls[1].setPayRate(20);
        payrolls[1].setHours(50);
        
        payrolls[2] = new Payroll("Juan Lola", 3333);
        payrolls[2].setPayRate(25);
        payrolls[2].setHours(40);
        
        System.out.println("ID\t" +
                        "Name\t\t" +
                        "rate/hr\t\t" +
                        "hrs/worked\t" +
                        "Gross pay");
        for(Payroll payroll : payrolls)
            printPayroll(payroll);
    }
    
    public static void printPayroll(Payroll payroll) {
        System.out.print(payroll.getId());
        System.out.print("\t" + payroll.getEmployeeName());
        System.out.print("\t" + (int) payroll.getPayRate());
        System.out.print("\t\t" + (int) payroll.getHours());
        System.out.print("\t\t" + (int) payroll.getGrossPay());
        System.out.println();
    }
}
