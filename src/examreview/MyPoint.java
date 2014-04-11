/**
 * Computer Programming 2 Exam 1 Review: 4 - MyPoint
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;


public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public double distance(int anotherX, int anotherY) {
        return Math.sqrt(Math.pow(anotherX-this.x, 2) + Math.pow(anotherY-this.y, 2));
    }
    
    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }
}
