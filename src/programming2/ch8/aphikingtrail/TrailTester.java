/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.aphikingtrail;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */
public class TrailTester {
    public static void main(String[] args) {
        int[] markers = {100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80 , 90, 
            100};
        Trail trail = new Trail(markers);
        
        System.out.println(trail.isLevelTrailSegment(7, 10));
        System.out.println(trail.isLevelTrailSegment(2, 12));
        System.out.println(trail.isDifficult());
    }
}
