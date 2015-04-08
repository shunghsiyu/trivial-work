/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.circle;

/**
 *
 * @author yus
 */
public class Circle {
    private double radius;
    final double PI = 3.14159;

    //Construct a circle with the input radius
    public Circle(double radius) {
        this.radius = radius;
    }
    
    //Get the radius of this circle instance
    public double getRadius() {
        return radius;
    }

    //Set the radius of this circle instance
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    //Get the area of this circle instance
    public double getArea() {
        return PI*radius*radius;
    }
    
    //Get the diameter of this circle instance
    public double getDiameter() {
        return radius*2;
    }
    
    //Get the circumference of this circle instance
    public double getCircumference() {
        return 2*PI*radius;
    }
}
