/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.carpetcalculator;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */
public class RoomCarpetTester {
    public static void main(String[] args) {
        RoomDimension room1 = new RoomDimension(12, 10);
        RoomCarpet room1Carpet = new RoomCarpet(room1, 8);
        System.out.println("room1: " + room1Carpet.toString());
        
        RoomDimension room2 = new RoomDimension(12.5, 10.5);
        RoomCarpet room2Carpet = new RoomCarpet(room2, 10.5);
        System.out.println("room2: " + room2Carpet.toString());
    }
}
