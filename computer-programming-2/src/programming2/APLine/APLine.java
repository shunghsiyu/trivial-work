/*                      UML
 * -----------------------------------------------
 * |                   APLine                    |
 * -----------------------------------------------
 * | - a: int                                    |
 * | - b: int                                    |
 * | - c: int                                    |
 * -----------------------------------------------
 * | + APLine(a:int, b:int, c:int)               |
 * | + getA(): int                               |
 * | + getB(): int                               |
 * | + getC():int                                |
 * | + getEquation(): String                     |
 * | + getOnLineEquation(x: int, y: int): String |
 * | + getSlope(): double                        |
 * | + isOnLine(x: int, y: int): boolean         |
 * -----------------------------------------------
 */

package programming2.APLine;

/**
 * APLine calculates the slope of a line and checks whether an input point
 * is on the line.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 5, 2014
 */
public class APLine {
    private int a;
    private int b;
    private int c;

    /**
     * Constructor of APLine class.
     * @param a the value of 'a' in line equation ax+by+c=0.
     * @param b the value of 'b' in line equation ax+by+c=0.
     * @param c the value of 'c' in line equation ax+by+c=0.
     */
    public APLine(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     * Calculate and return the slope of this line.
     * @return the slope of this APLine instance.
     */
    public double getSlope() {
        double a = this.getA();
        return -a/getB();
    }
    
    /**
     * Check whether a point is on this line.
     * @param x the x-coordinate of the point.
     * @param y the y-coordinate of the point.
     * @return true if the point is on the line, false if not.
     */
    public boolean isOnLine(int x, int y) {
        if((getA()*x + getB()*y + getC()) == 0)
            return true;
        else
            return false;
    }
    
    /**
     * Return the value of 'a' in line equation ax+by+c=0.
     * @return the value of 'a'.
     */
    public int getA() {
        return a;
    }
    
    /**
     * Return the value of 'b' in line equation ax+by+c=0.
     * @return the value of 'b'.
     */
    public int getB() {
        return b;
    }

    /**
     * Return the value of 'c' in line equation ax+by+c=0.
     * @return the value of 'c'.
     */
    public int getC() {
        return c;
    }
    
    /**
     * Return the line equation in the form of 'ax + by + c = 0' of this line.
     * @return the line equation of this line.
     */
    public String getEquation() {
        String by;
        String c0;
        if(b > 0)
            by = "+ ";
        else
            by = "- ";
        by = by + Math.abs(b) + "y";
        
        if(c > 0)
            c0 = "+ ";
        else
            c0 = "- ";
        c0 = c0 + Math.abs(c) + " = 0";
        return String.format("%1$dx %2$s %3$s", a, by, c0);
    }
    
    /**
     * Return the equation with 'x' and 'y' substituted with the coordinates
     * of the input point.
     * @param x the x-coordinate of the point.
     * @param y the y-coordinate of the point.
     * @return the equation with input point substituted in.
     */
    public String getOnLineEquation(int x, int y) {
        String by;
        String c0;
        if(b > 0)
            by = "+ ";
        else
            by = "- ";
        by = by + Math.abs(b) + "(" + y + ")";
        
        if(c > 0)
            c0 = "+ ";
        else
            c0 = "- ";
        c0 = c0 + Math.abs(c);
        if(this.isOnLine(x, y))
            c0 = c0 + " = 0";
        else
            c0 = c0 + " != 0";
        return String.format("%1$d(%2$d) %3$s %4$s", a, x, by, c0);
    }
}
