/**
 * Chapter 8 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.carpetcalculator;

public class RoomDimension {
    private final double length;
    private final double width;

    public RoomDimension(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double getArea() {
        return length*width;
    }
    
    @Override
    public String toString() {
        return length + "x" + width + " sqft";
    }
}
