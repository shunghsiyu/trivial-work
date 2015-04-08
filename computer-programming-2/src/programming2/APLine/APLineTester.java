/*
 * 
 */

package programming2.APLine;

/**
 * APLine Tester
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 5, 2014
 */
public class APLineTester {
    public static void main(String[] args) {
        //Create a new line with equation 5x+4y-17=0
        APLine line1 = new APLine(5, 4, -17);
        //Get the slope of the line
        double slope1 = line1.getSlope();
        //Checks if point (5,-2) is on the line
        boolean onLine1 = line1.isOnLine(5, -2);
        
        //Create a new line with equation -25x+40y+30=0
        APLine line2 = new APLine(-25, 40, 30);
        //Get the slope of the line
        double slope2 = line2.getSlope();
        //Checks if point (5,-2) is on the line
        boolean onLine2 = line2.isOnLine(5, -2);
        
        //The maximum white spaces to pad
        int padding = 23;
        
        //Print the heading
        System.out.println(pad("Equation",padding) + 
                           pad("Slope(-a/b)",padding) +
                           "Is point (5,-2) on the line?");
        //Create a APLine alias
        APLine l;
        
        //Work on line1
        l = line1;
        //Print result of line1
        System.out.print(pad(l.getEquation(), padding) +
                           pad((-1*l.getA()) + " / " + l.getB() + " = " + l.getSlope(), padding));
        if(l.isOnLine(5, -2))
            System.out.print("Yes,");
        else
            System.out.print("No,");
        System.out.println(" because " + l.getOnLineEquation(5, -2));
        
        //Work on line2
        l = line2;
        //Print result of line2
        System.out.print(pad(l.getEquation(), padding) +
                           pad((-1*l.getA()) + " / " + l.getB() + " = " + l.getSlope(), padding));
        if(l.isOnLine(5, -2))
            System.out.print("Yes,");
        else
            System.out.print("No,");
        System.out.println(" because " + l.getOnLineEquation(5, -2));
    }
    
    //Turn a string into a certian length by filling it with trailing spaces
    public static String pad(String originalString, int length) {
        return String.format("%1$-" + length + "s", originalString);
    }
}
