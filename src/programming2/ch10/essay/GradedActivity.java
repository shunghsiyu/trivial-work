/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.essay;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 25, 2014
 */
public class GradedActivity {
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public char getGrade() {
        char letterGrade;
        if(score >= 90) {
            letterGrade = 'A';
        } else if(score >= 80) {
            letterGrade = 'B';            
        } else if(score >= 70) {
            letterGrade = 'C';            
        } else if(score >= 60) {
            letterGrade = 'D';            
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
