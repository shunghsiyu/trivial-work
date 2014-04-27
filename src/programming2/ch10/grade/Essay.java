/*
                                 UML
-------------------------------------------------------------------------
|                               Essay                                   |
-------------------------------------------------------------------------
| - grammar: double                                                     |
| - spelling: double                                                    |
| - correctLength: double                                               |
| - content: double                                                     |
-------------------------------------------------------------------------
| + setScore(grammer: double, spelling: double, correctLength:double,   |
|     content: double)                                                  |
| + getGrammer(): double                                                |
| + getSpelling(): double                                               |
| + getCorrectLength(): double                                          |
| + getContent(): double                                                |
| - checkScore(scoreToCheck: double)                                    |
-------------------------------------------------------------------------
 */

package programming2.ch10.grade;




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

    /**
     * Set the score of this Essay instance.
     * @param grammar grammar points
     * @param spelling spelling points
     * @param correctLength length points
     * @param content content points
     */
    public void setScore(double grammar, double spelling, double correctLength, 
            double content) {
        super.setScore(grammar + spelling + correctLength + content);
        this.grammar = checkScore(grammar);
        this.spelling = checkScore(spelling);
        this.correctLength = checkScore(correctLength);
        this.content = checkScore(content);
    }

    /**
     * Get the grammar points.
     * @return grammar points
     */
    public double getGrammar() {
        return grammar;
    }

    /**
     * Get the spelling points.
     * @return spelling points
     */
    public double getSpelling() {
        return spelling;
    }

    /**
     * Get the length points.
     * @return length points
     */
    public double getCorrectLength() {
        return correctLength;
    }

    /**
     * Get the content points.
     * @return content points
     */
    public double getContent() {
        return content;
    }
    
    /**
     * Check whether or not a score is within the correct range.
     * @param scoreToCheck the input score to check
     * @return the same input score
     */
    private double checkScore(double scoreToCheck) {
        if(scoreToCheck > 100) {
            throw new IllegalArgumentException("A score cannot be higher than "
                    + "100");
        }
        return scoreToCheck;
    }
}
