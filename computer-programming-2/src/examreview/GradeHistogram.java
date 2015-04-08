/**
 * Programming 2 Exam 1 Review: 2 - GradeHistogram.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;


public class GradeHistogram {
    /*------------ Tester ----------------*/
    public static void main(String[] args) {
        int[] grades = { 49, 50, 51, 59, 0, 5, 9, 10, 15, 19, 
        50, 55, 89, 99, 100};
        GradeHistogram gradeHistogram = new GradeHistogram(grades);
        
        int range = 10;
        System.out.print(gradeHistogram.getTable(range));
    }

    /* ------------ Class ----------------*/
    private final int maxGrade = 100; 
    private int[] grades;
    private String fill;
    
    public GradeHistogram(int[] inputGrades) {
        this(inputGrades, "*");
    }
    
    public GradeHistogram(int[] inputGrades, String fill) {
        this.grades = inputGrades;
        this.fill = fill;
    }
    
    public int getNumbersInRange(int lowerBound, int upperBound) {
        int count = 0;
        for(int grade: grades) {
            if(lowerBound <= grade && grade <= upperBound) {
                count = count + 1;
            }
        }
        return count;
    }
    
    public String getTable(int range) {
        if(range <= 0) {
            throw new IllegalArgumentException("Variable 'range' cannot be less"
                    + "than 0!");
        }
        
        StringBuilder table = new StringBuilder();
        for(int lowerBound = 0; lowerBound < maxGrade; 
                lowerBound += range) {
            int upperBound = lowerBound+range-1;
            if(upperBound == maxGrade - 1) {
                upperBound = maxGrade;
            }
            table.append(String.format("%1$3d -%2$3d: ", lowerBound, upperBound));
            int numStar = this.getNumbersInRange(lowerBound, upperBound);
            for(int i = 0; i < numStar; i++) {
                table.append(fill);
            }
            table.append("\n");
        }
        return table.toString();
    }
    
}
