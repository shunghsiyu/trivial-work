/**
   This program demonstrates a solution to the
   ShiftSupervisor Class programming challenge.
*/
package programming2.ch10.shiftsupervisor;


public class ShiftSupervisorDemo
{
   public static void main(String[] args)
   {
      // Create a ShiftSupervisor object and pass the initialization
      // data to the constructor.
      ShiftSupervisor ss =
           new ShiftSupervisor("John Smith", "123-A", "11-15-2005",
                               48000.0, 6500.0);
      
      // Display the data.
      System.out.println("Here's the first shift supervisor.");
      System.out.println(ss);
      
      // Create another ShiftSupervisor object and use the
      // set methods.
      ShiftSupervisor ss2 = new ShiftSupervisor();
      ss2.setName("Joan Jones");
      ss2.setEmployeeNumber("222-L");
      ss2.setHireDate("12-12-2005");
      ss2.setSalary(55000.0);
      ss2.setBonus(8000.0);
      
      // Display the data.
      System.out.println("\nHere's the second shift supervisor.");
      System.out.println(ss2);
   }
}