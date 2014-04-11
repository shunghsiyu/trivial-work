/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.apwordlist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */
public class WordList {
    private final ArrayList myList;

    public WordList(ArrayList<String> myList) {
        this.myList = new ArrayList<>(myList);
    }
    
    public WordList(String[] stringArray) {
        this.myList = new ArrayList<>(Arrays.asList(stringArray));
    }
    
    public int numWordsOfLength(int len) {
        int num = 0;
        for(Object o: myList) {
            if(o instanceof String) {
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
    
    public void removeWordsOfLength(int len) {
        for(int i = myList.size()-1; i >= 0; i--) {
            Object o = myList.get(i);
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
