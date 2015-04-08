/**
 * Computer Programming 2 Exam 1 Review: 3 - TestCircle.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;


public class TestCircle {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle();
        circles[1] = new Circle(2.0);
        circles[2] = new Circle(3.0, "blue");
        
        for(Circle circle: circles) {
            System.out.println("The circle has radius of " + circle.getRadius() +
                    " color " + circle.getColor() + " and area of " +
                    circle.getArea());
        }
    }
}
