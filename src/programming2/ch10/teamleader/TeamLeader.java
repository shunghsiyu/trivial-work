/**
 * Chapter 10 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 25, 2014
 */

/*
                                   UML
------------------------------------------------------------------------------
|                               TeamLeader                                   |
------------------------------------------------------------------------------
| - monthlyBonus: double                                                     |
| - requiredTrainingHours: double                                            |
| - trainingHoursAttended: double                                            |
------------------------------------------------------------------------------
| + TeamLeader()                                                             |
| + TeamLeader(name: String, employeeNumber: String, hireDateString: String, |    
|     shift: int, payRate: double, monthlyBonus: double,                     |
|     requiredTraining: double, trainingHoursAttended)                       |
| + getMonthlyBonus(): double                                                |
| + setMonthlyBonus(monthlyBonus: double): void                              |
| + getRequiredTrainingHours(): double                                       |
| + setRequiredTrainingHours(double requiredTrainingHours): void             |
| + getTrainingHoursAttended(): double                                       |
| + setTrainingHoursAttended(trainingHoursAttended: double): void            |
| + toString(): String                                                       |
------------------------------------------------------------------------------
*/
package programming2.ch10.teamleader;


import java.text.DecimalFormat;
import programming2.ch10.employee.ProductionWorker;


public class TeamLeader extends ProductionWorker {
    // For formatting numbers representing money
    private static final DecimalFormat decimalFormat = 
            new DecimalFormat("###,###,###,###.00");
    private double monthlyBonus;
    private double requiredTrainingHours;
    private double trainingHoursAttended;

    /**
     * Default constructor of TeamLeader class.
     */
    public TeamLeader() {
    }

    /**
     * Constructor of TeamLeader class.
     * @param name name of the team leader
     * @param employeeNumber team leader's employee number
     * @param hireDateString date the team leader was hired
     * @param shift the team leader's shift
     * @param payRate the team leader's pay rate
     * @param monthlyBonus the team leader's monthly bonus
     * @param requiredTrainingHours the number of required training hour for the
     * team leader
     * @param trainingHoursAttended the number of training hours the team leader
     * had attended so far
     */
    public TeamLeader(String name, 
            String employeeNumber, String hireDateString, int shift, 
            double payRate, double monthlyBonus, double requiredTrainingHours, 
            double trainingHoursAttended) {
        super(name, employeeNumber, hireDateString, shift, payRate);
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.trainingHoursAttended = trainingHoursAttended;
    }

    /**
     * Get this team leader's monthly bonus.
     * @return team leader's monthly bonus
     */
    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    /**
     * Set this team leader's monthly bonus.
     * @param monthlyBonus the team leader's monthly bonus
     */
    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    /**
     * Get the number of required training hour for this team leader.
     * @return the number of required training hour for the team leader
     */
    public double getRequiredTrainingHours() {
        return requiredTrainingHours;
    }
    
    /**
     * Set the number of required training hour for this team leader
     * @param requiredTrainingHours the number of required training hour for the
     * team leader
     */
    public void setRequiredTrainingHours(double requiredTrainingHours) {
        this.requiredTrainingHours = requiredTrainingHours;
    }

    /**
     * Get the number of training hours this team leader had attended so far.
     * @return the number of training hours the team leader had
     */
    public double getTrainingHoursAttended() {
        return trainingHoursAttended;
    }

    /**
     * Set the number of training hours this team leader had attended so far.
     * @param trainingHoursAttended  the number of training hours the team 
     * leader had
     */
    public void setTrainingHoursAttended(double trainingHoursAttended) {
        this.trainingHoursAttended = trainingHoursAttended;
    }

    /**
     * Return a string representation of this Team Leader instance.
     * @return string representation of the Team Leader instance
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%n"));
        sb.append("Monthly Bonus: $");
        sb.append(getMonthlyBonus());
        sb.append(String.format("%n"));
        sb.append("Required Training Hour: ");
        sb.append(String.format("%.1f", getRequiredTrainingHours()));
        sb.append(String.format("%n"));
        sb.append("Training Hours Attended: ");
        sb.append(String.format("%.1f", getTrainingHoursAttended()));
        return sb.toString();
    }
}
