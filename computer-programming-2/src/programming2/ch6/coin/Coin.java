/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.coin;

import java.util.Random;

/**
 *
 * @author yus
 */
public class Coin {
    private String sideUp;
    final private Random random;

    //Construct a coin instance with its sideUp randomly determined
    public Coin() {
        this.random = new Random();
        sideUp = headsOrTails();
    }

    //Get which side of the coin is facing up right now
    public String getSideup() {
        return sideUp;
    }
    
    //Toss this coin instance to randomly determine which side is facing up
    public void toss() {
       sideUp = headsOrTails();
    }
    
    //Return either "heads" or "tails" randomly
    private String headsOrTails() {
        if (random.nextInt(2) == 0) {
            return "heads";
        } else {
            return "tails";
        }
    }
}
