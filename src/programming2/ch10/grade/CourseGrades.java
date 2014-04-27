/**
 * Chapter 10 Programming Challenges 5.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 26, 2014
 */

/*
                           UML
---------------------------------------------------------
|                      CourseGrades                     |
---------------------------------------------------------
| - grades: GradedActivity[]                            |
---------------------------------------------------------
| + setLab(lab: GradedActivity): void                   |
| + setPassFailExam(passFailExam: PassFailExam): void   |
| + setEssay(essay: Essay): void                        |
| + setFinalExam(finalExam: FinalExam): void            |
| + toString(): String                                  |
---------------------------------------------------------
*/

package programming2.ch10.grade;


public class CourseGrades {
    private GradedActivity[] grades;

    /**
     * Default constructor to initialize CourseGrades class.
     */
    public CourseGrades() {
        this.grades = new GradedActivity[4];
    }
    
    /**
     * Set the student's score for lab activity.
     * @param lab student's score for lab activity
     */
    public void setLab(GradedActivity lab) {
        grades[0] = lab;
    }
    
    /**
     * Set the student's score for pass/fail exam.
     * @param passFailExam student's score for pass/fail exam.
     */
    public void setPassFailExam(PassFailExam passFailExam) {
        grades[1] = passFailExam;
    }
    
    /**
     * Set the student's score for the essay.
     * @param essay student's score for the essay
     */
    public void setEssay(Essay essay) {
        grades[2] = essay;
    }
    
    /**
     * Set the student's score for the final exam.
     * @param finalExam student's score for the final exam
     */
    public void setFinalExam(FinalExam finalExam) {
        grades[3] = finalExam;
    }

    /**
     * Return a string representation of this CourseGrades instance. Displaying
     * the student's score the the lab, pass/fail exam, essay and final exam.
     * @return string representation of the student's course grade
     */
    @Override
    public String toString() {
        int ws = -22;
        String[] categories = {"Lab", "Pass/Fail Exam", "Essay", "Final Exam"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grades.length; i++) {
            sb.append(String.format("%"+ws+"s %.1f    Grade: %c%n", 
                    categories[i]+" Score:", grades[i].getScore(), grades[i].getGrade()));
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
