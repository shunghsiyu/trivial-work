/**
 * Chapter 8 Programming Challenges 3.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.carpetcalculator;


public class RoomCarpetTester {
    public static void main(String[] args) {
        // Create a RoomCarpet instance costing $8/sqft in a 12x10 ft room
        RoomDimension room1 = new RoomDimension(12, 10);
        RoomCarpet room1Carpet = new RoomCarpet(room1, 8);
        System.out.println("room1: " + room1Carpet.toString());
        
        // Create a RoomCarpet instance costing $10.5/sqft in a 12.5x10.5 ft room
        RoomDimension room2 = new RoomDimension(12.5, 10.5);
        RoomCarpet room2Carpet = new RoomCarpet(room2, 10.5);
        System.out.println("room2: " + room2Carpet.toString());
    }
}
