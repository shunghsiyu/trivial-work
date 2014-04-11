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
public class Triangle{
    public static void main(String[] args) {
        Triangle(5);
    }

    public static void Triangle(int numRow) {
        for(int i = 0; i < numRow; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

}