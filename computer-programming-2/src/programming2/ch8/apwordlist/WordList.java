/**
 * AP Word List.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.apwordlist;

import java.util.ArrayList;
import java.util.Arrays;


public class WordList {
    private final ArrayList myList;

    /**
     * Constructor of WordList class. Copies the input ArrayList.
     * @param myList array list of words as String
     */
    public WordList(ArrayList<String> myList) {
        this.myList = new ArrayList<>(myList);
    }

    /**
     * Constructor of WordList class. Copies the input array.
     * @param stringArray array of words as String
     */
    public WordList(String[] stringArray) {
        this.myList = new ArrayList<>(Arrays.asList(stringArray));
    }
    
    /**
     * Check how many word in this WordList instance has the specified length.
     * @param len specified word length to count
     * @return the number of words with the specified length
     */
    public int numWordsOfLength(int len) {
        int num = 0;
        for(Object o: myList) {
            // To be safe, checks if the element in the array list are
            // instance of String
            if(o instanceof String) {
                // Cast the element of the ArrayList to String
                String s = (String) o;
                if(len == s.length()) {
                    num = num + 1;
                }
            } else {
                throw new IllegalStateException("ArrayList myList should "
                        + "contain Strings");
            }
        }
        return num;
    }
    
    /**
     * Remove the word with the specified length from this WordList instance.
     * @param len specified word length to remove
     */
    public void removeWordsOfLength(int len) {
        // Start from the end of ArrayList so remove(int i) method will not 
        // affect the for loop
        for(int i = myList.size()-1; i >= 0; i--) {
            Object o = myList.get(i);
            // To be safe, checks if the element in the array list are
            // instance of String
            if(o instanceof String) {
                String s = (String) o;
                if(len == s.length()) {
                    myList.remove(i);
                }
            } else {
                throw new IllegalStateException("ArrayList myList should "
                        + "contain Strings");
            }
        }
    }
    
    /**
     * Get the String representation of this WordList instance.
     * @return String representation of this WordList instance
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object o: myList) {
            if(o instanceof String) {
                String s = (String) o;
                sb.append("\"");
                sb.append(s);
                sb.append("\", ");
            } else {
                throw new IllegalStateException("ArrayList myList should "
                        + "contain Strings");
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
