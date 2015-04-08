/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examreview;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 15, 2014
 */
public class CozaLozaWoza {
    public static void main(String[] args) {
        CozaLozaWoza test = new CozaLozaWoza();
        System.out.print(test);
    }

    private final int length = 110;
    private final int itemsPerLine = 11;
    private final int[] multiples = { 3, 5, 7};
    private String[] array;

    public CozaLozaWoza() {
        this.fillArray();
        for(int multiple: multiples) {
            this.clear(multiple);
        }
        this.Coza();
        this.Loza();
        this.Woza();
    }

    private void fillArray() {
        array = new String[length + 1];
        for(int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i);
        }
    }

    private void clear(int multiple) {
        for(int i = 0; i < array.length; i = i + multiple) {
            array[i] = "";
        }
    }

    private void Coza() {
        appendOnMultiple("Coza", 3);
    }

    private void Loza() {
        appendOnMultiple("Loza", 5);
    }

    private void Woza() {
        appendOnMultiple("Woza", 7);
    }

    private void appendOnMultiple(String toAppend, int multiple) {
        for(int i = 0; i < array.length; i = i + multiple) {
            array[i] = array[i] + toAppend;
        }
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        for(int i = 1; i < array.length; i++) {
            content.append(array[i]);
            content.append(" ");
            int remainder = i % itemsPerLine;
            if(remainder == 0) {
                content.append("\n");
            }
        }
        return content.toString();
    }
}