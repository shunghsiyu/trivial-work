/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.pet;

import java.util.ArrayList;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 27, 2014
 */
public class Kennel {
    private ArrayList petList;

    public Kennel() {
        petList = new ArrayList();
    }
    
    public void addPet(Pet pet) {
        petList.add(pet);
    }
    
    public void allSpeak() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Object o: petList) {
            Pet pet = (Pet) o;
            sb.append(String.format("%s: %s%n", pet.getName(), pet.speak()));
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
