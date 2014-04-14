/**
 * AP Trail.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.aphikingtrail;

import java.util.Arrays;


public class Trail {
    private final int[] markers;

    /**
     * Constructor for trail class. Makes a copy of the input array.
     * @param markers markers of the altitude of the trail
     */
    public Trail(int[] markers) {
        this.markers = Arrays.copyOf(markers, markers.length);
    }
    
    /**
     * Checks if the segment of trail from marker[start] to marker[end] 
     * (inclusive) is considered to be level. A segment is considered to be 
     * level if the difference between the maximum height and the minimum height
     * is less than or equal to 10.
     * @param start the start of the segment
     * @param end the end of the segment (inclusive)
     * @return whether or not the segment is level
     */
    public boolean isLevelTrailSegment(int start, int end) {
        /* --- Preconditions --- 
           0 < start < end < marker.lenth
        */
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
        // Initialize min and max
        int max = markers[start];
        int min = markers[start];
        // Go through the segment in the array to find min and max
        for(int i = start+1; i <= end; i++) {
            if(markers[i] < min) {
                min = markers[i];
            }
            if(markers[i] > max) {
                max = markers[i];
            }
        }
        // the segment is level if the difference between min and max is <= 10
        boolean isLevel = ((max-min) <= 10); 
        return isLevel;
    }
    
    /**
     * Checks if the trail is difficult. A trail is considered to be difficult 
     * if the trail contains three or more places where the height of adjacent 
     * markers has a difference >= 30.
     * @return whether or not the trail is difficult
     */
    public boolean isDifficult() {
        // Get an array that contains the changes of height
        int[] changes = getMarkerChange();
        
        // Calculate the number of times the changes of height is greater than 
        // 30 (steep)
        int numSteep = 0;
        for(int change: changes) {
            if(Math.abs(change) >= 30) {
                numSteep = numSteep + 1;
            }
        }
        
        // A trail is difficult is there are three or more steep change
        boolean isDifficult = (numSteep >= 3);
        return isDifficult;
    }
    
    /**
     * Get an array that contains the changes of height between a adjacent 
     * markers.
     * @return an array that contains the changes of height between a adjacent 
     * markers
     */
    private int[] getMarkerChange() {
        int[] markersDelta = new int[markers.length-1];
        for(int i = 0; i < markers.length-1; i++) {
            markersDelta[i] = markers[i] - markers[i+1];
        }
        return markersDelta;
    }
}
