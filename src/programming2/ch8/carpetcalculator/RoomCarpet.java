/**
 * Chapter 8 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

/*
                      UML
--------------------------------------------------
|                  RoomCarpet                    |
--------------------------------------------------
| - size: RoomDimension                          |
| - carpetCost: double                           |
--------------------------------------------------
| + RoomCarpet(dim: RoomDimension, cost: double) |
| + getTotalCost(): double                       |
| + toString: String                             |
--------------------------------------------------
*/

package programming2.ch8.carpetcalculator;

public class RoomCarpet {
    private final RoomDimension size;
    private final double carpetCost;

    /**
     * Constructor for the RoomCarpet class.
     * @param dim dimension of the room
     * @param cost cost of the carpet per square feet
     */
    public RoomCarpet(RoomDimension dim, double cost) {
        this.size = dim;
        this.carpetCost = cost;
    }
    
    /**
     * Get the total cost of this RoomCarpet instance.
     * @return the total cost
     */
    public double getTotalCost() {
        return size.getArea()*carpetCost;
    }
    
    /**
     * Convert this RoomCarpet instance to a String representation.
     * @return String representation of this RoomCarpet instance
     */
    @Override
    public String toString() {
        return size.toString() + " * $" + carpetCost + "/sqft = $" + 
                Math.round(getTotalCost());
    }
}
