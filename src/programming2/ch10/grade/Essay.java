/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.grade;

import programming2.ch10.grade.GradedActivity;



/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 25, 2014
 */
public class Essay extends GradedActivity {
    private double grammar;
    private double spelling;
    private double correctLength;
    private double content;

    public void setScore(double grammar, double spelling, double correctLength, 
            double content) {
        super.setScore(grammar + spelling + correctLength + content);
        this.grammar = checkScore(grammar);
        this.spelling = checkScore(spelling);
        this.correctLength = checkScore(correctLength);
        this.content = checkScore(content);
    }

    public double getGrammar() {
        return grammar;
    }

    public double getSpelling() {
        return spelling;
    }

    public double getCorrectLength() {
        return correctLength;
    }

    public double getContent() {
        return content;
    }
    
    public double checkScore(double scoreToCheck) {
        if(scoreToCheck > 100) {
            throw new IllegalArgumentException("A score cannot be higher than "
                    + "100");
        }
        return scoreToCheck;
    }
}
