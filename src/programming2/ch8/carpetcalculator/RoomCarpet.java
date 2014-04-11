/**
 * Chapter 8 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.carpetcalculator;

public class RoomCarpet {
    private final RoomDimension size;
    private final double carpetCost;

    public RoomCarpet(RoomDimension dim, double cost) {
        this.size = dim;
        this.carpetCost = cost;
    }
    
    public double getTotalCost() {
        return size.getArea()*carpetCost;
    }
    
    @Override
    public String toString() {
        return size.toString() + " * $" + carpetCost + "/sqft = $" + 
                Math.round(getTotalCost());
    }
}
