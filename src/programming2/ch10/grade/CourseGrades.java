/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.grade;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 26, 2014
 */
public class CourseGrades {
    private GradedActivity[] grades;

    public CourseGrades() {
        this.grades = new GradedActivity[4];
    }
    
    public void setLab(GradedActivity lab) {
        grades[0] = lab;
    }
    
    public void setPassFailExam(PassFailExam passFailExam) {
        grades[1] = passFailExam;
    }
    
    public void setEssay(Essay essay) {
        grades[2] = essay;
    }
    
    public void setFinalExam(FinalExam finalExam) {
        grades[3] = finalExam;
    }

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
