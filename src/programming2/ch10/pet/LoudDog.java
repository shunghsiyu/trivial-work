/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.pet;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 27, 2014
 */
public class LoudDog extends Dog {
    public LoudDog(String myName) {
        super(myName);
    }

    @Override
    public String speak() {
        return String.format("%1$s %1$s", super.speak());
    }
}
