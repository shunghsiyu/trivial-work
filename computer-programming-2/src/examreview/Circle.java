/**
 * Computer Programming 2 Exam 1 Review: 3 - Circle.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;


public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this(1.0, "red");
    }

    public Circle(double radius) {
        this(radius, "red");
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea() {
        return Math.PI*Math.pow(getRadius(), 2);
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
