/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.coin;

/**
 *
 * @author yus
 */
public class driving_program {
    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println("A coin instance is created with sideUp: " + coin.getSideup());
        
        int numHeads = 0;
        int numTails = 0;
        int loop = 20;
        for(int i = 0; i < loop; i++) {
            coin.toss();
            System.out.println("Coin is tossed, now with sideUp: " + coin.getSideup());
            if(coin.getSideup().equalsIgnoreCase("heads")) {
                numHeads = numHeads + 1;
            } else if (coin.getSideup().equalsIgnoreCase("tails")) {
                numTails = numTails + 1;
            } else {
                System.out.println("Something went wrong");
            }
        }
        
        System.out.println("After " + loop + " tosses, here are the results:");
        System.out.println("Number tosses with heads: " + numHeads);
        System.out.println("Number tosses with tails: " + numTails);
    }
}
