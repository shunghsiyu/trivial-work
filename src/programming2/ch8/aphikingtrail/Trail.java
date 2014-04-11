/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.aphikingtrail;

import java.util.Arrays;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */
public class Trail {
    private final int[] markers;

    public Trail(int[] markers) {
        this.markers = Arrays.copyOf(markers, markers.length);
    }
    
    public boolean isLevelTrailSegment(int start, int end) {
        /* --- Preconditions --- */
        if(start < 0) {
            throw new IllegalArgumentException("'start' is less than zero");
        } else if(end < start) {
            throw new IllegalArgumentException("'start' should be greater than "
                    + "'end'");
        } else if(end > (markers.length -1)) {
            throw new IllegalArgumentException("'end' should be less than "
                    + "marker.length-1");
        }
        
        /* --- Work --- */
        int max = markers[start];
        int min = markers[start];
        for(int i = start+1; i <= end; i++) {
            if(markers[i] < min) {
                min = markers[i];
            }
            if(markers[i] > max) {
                max = markers[i];
            }
        }
        boolean isLevel = ((max-min) <= 10); 
        return isLevel;
    }
    
    public boolean isDifficult() {
        int[] changes = getMarkerChange();
        
        int numSteep = 0;
        for(int change: changes) {
            if(Math.abs(change) >= 30) {
                numSteep = numSteep + 1;
            }
        }
        
        boolean isDifficult = (numSteep >= 3);
        return isDifficult;
    }
    
    private int[] getMarkerChange() {
        int[] markersDelta = new int[markers.length-1];
        for(int i = 0; i < markers.length-1; i++) {
            markersDelta[i] = markers[i] - markers[i+1];
        }
        return markersDelta;
    }
}
