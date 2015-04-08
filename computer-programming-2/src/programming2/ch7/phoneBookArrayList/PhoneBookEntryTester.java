/*
 *
 */

package programming2.ch7.phoneBookArrayList;

import java.util.ArrayList;

/**
 * Chapter 07 Programming Challenges 16.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 9, 2014
 */
public class PhoneBookEntryTester {
    public static void main(String[] args) {
        //Create an array list for PhoneBookEntry objects
        ArrayList<PhoneBookEntry> phoneBookArrayList = new ArrayList<PhoneBookEntry>();
        
        //Populate the array list with six entries
        phoneBookArrayList.add(new PhoneBookEntry("AAA", "800_222_4357"));
        phoneBookArrayList.add(new PhoneBookEntry("GMAC", "800_200_4622"));
        phoneBookArrayList.add(new PhoneBookEntry("Allstate Roadside", "800_869_7997"));
        phoneBookArrayList.add(new PhoneBookEntry("Sallie Mae", "888_272_5543"));
        phoneBookArrayList.add(new PhoneBookEntry("USAA", "800_531_2265"));
        phoneBookArrayList.add(new PhoneBookEntry("Merrill Lynch", "800_637_7455"));
        
        //The width to pad the Strings
        int width = 22;
        //Print the name and phone number of each entry
        for(PhoneBookEntry entry: phoneBookArrayList) {
            System.out.println(pad(entry.getName(), width) + entry.getPhoneNumber());
        }
    }
    
    //Turn a string into a certian length by filling it with trailing spaces
    private static String pad(String originalString, int length) {
        return String.format("%1$-" + length + "s", originalString);
    }
}
