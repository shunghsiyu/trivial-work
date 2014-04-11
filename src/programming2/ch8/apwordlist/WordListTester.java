/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.apwordlist;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */
public class WordListTester {
    public static void main(String[] args) {
        String[] animalArray = {"cat", "mouse", "frog", "dog", "dog"};
        WordList animals = new WordList(animalArray);
        
        System.out.println(animals.numWordsOfLength(4));
        System.out.println(animals.numWordsOfLength(3));
        System.out.println(animals.numWordsOfLength(2));
        
        animals.removeWordsOfLength(4);
        System.out.println(animals.toString());
        animals.removeWordsOfLength(3);
        System.out.println(animals.toString());
        animals.removeWordsOfLength(2);
        System.out.println(animals.toString());
    }
}
