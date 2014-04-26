/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.teamleader;


import java.text.DecimalFormat;
import programming2.ch10.employee.ProductionWorker;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 25, 2014
 */
public class TeamLeader extends ProductionWorker {
    private static final DecimalFormat decimalFormat = 
            new DecimalFormat("###,###,###,###.00");
    private double monthlyBonus;
    private double requiredTrainingHours;
    private double trainingHoursAttended;

    public TeamLeader() {
    }

    public TeamLeader(String name, 
            String employeeNumber, String hireDateString, int shift, 
            double payRate, double monthlyBonus, double requiredTrainingHours, 
            double trainingHoursAttended) {
        super(name, employeeNumber, hireDateString, shift, payRate);
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.trainingHoursAttended = trainingHoursAttended;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public double getRequiredTrainingHours() {
        return requiredTrainingHours;
    }

    public void setRequiredTrainingHours(double requiredTrainingHours) {
        this.requiredTrainingHours = requiredTrainingHours;
    }

    public double getTrainingHoursAttended() {
        return trainingHoursAttended;
    }

    public void setTrainingHoursAttended(double trainingHoursAttended) {
        this.trainingHoursAttended = trainingHoursAttended;
    }

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
