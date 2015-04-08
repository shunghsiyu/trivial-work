package programming2.ch10.teamleader;

/**
   This program demonstrates a solution to the
   TeamLeader Class programming challenge.
*/
import programming2.ch10.employee.ProductionWorker;


public class TeamLeaderDemo
{
   public static void main(String[] args)
   {
      // Create a TeamLeader object and pass the initialization
      // data to the constructor.
      TeamLeader t =
           new TeamLeader("John Smith", "123-A", "11-15-2005",
                           ProductionWorker.DAY_SHIFT, 16.50, 500.0,
                           5.0, 2.5);
      
      // Display the data.
      System.out.println("Here's the first team leader.");
      System.out.println(t);
      
      // Create another TeamLeader object and use the
      // set methods.
      TeamLeader t2 = new TeamLeader();
      t2.setName("Joan Jones");
      t2.setEmployeeNumber("222-L");
      t2.setHireDate("12-12-2005");
      t2.setShift(ProductionWorker.NIGHT_SHIFT);
      t2.setPayRate(18.50);
      t2.setMonthlyBonus(600.0);
      t2.setRequiredTrainingHours(7.0);
      t2.setTrainingHoursAttended(3.5);
      
      // Display the data.
      System.out.println("\nHere's the second production worker.");
      System.out.println(t2);
   }
}