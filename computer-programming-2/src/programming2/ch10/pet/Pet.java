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
public abstract class Pet {
    private String myName;

    public Pet(String myName) {
        this.myName = myName;
    }

    public String getName() {
        return myName;
    }

    public abstract String speak();
}
