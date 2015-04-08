/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.square;

/**
 *
 * @author yus
 */
public class Square {
    private double sideLength;

    public Square() {
        this.sideLength = 0.0;
    }

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }
    
    public double getArea() {
        return getSideLength() * getSideLength();
    }

    public double getSideLength() {
        return sideLength;
    }
    
}
