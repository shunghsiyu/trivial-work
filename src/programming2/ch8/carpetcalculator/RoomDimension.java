/**
 * Chapter 8 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

/*
                      UML
--------------------------------------------------
|                 RoomDimension                  |
--------------------------------------------------
| - length: double                               |
| - width: double                                |
--------------------------------------------------
| + RoomDimension(length: double, width: double) |
| + getArea(): double                            |
| + toString(): String                           |
--------------------------------------------------
*/

package programming2.ch8.carpetcalculator;

public class RoomDimension {
    private final double length;
    private final double width;

    /**
     * Constructor for RoomDimension class.
     * @param length length of the room
     * @param width width of the room
     */
    public RoomDimension(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    /**
     * Get the area of this RoomDimension instance.
     * @return area of the room
     */
    public double getArea() {
        return length*width;
    }
    
    /**
     * Get the String representation of this RoomDimension instance.
     * @return the String representation of this RoomDimension instance
     */
    @Override
    public String toString() {
        return length + "x" + width + " sqft";
    }
}
