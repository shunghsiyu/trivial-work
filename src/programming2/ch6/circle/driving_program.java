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
public class driving_program {
    
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        circles[0] = new Circle(0);
        circles[1] = new Circle(0.5);
        circles[2] = new Circle(1);
        circles[3] = new Circle(1.5);
        circles[4] = new Circle(2);
        
        int padding = 18;
        System.out.print(pad("Radius", padding));
        System.out.print(pad("Diameter", padding));
        System.out.print(pad("Perimeter", padding));
        System.out.println(pad("Area", padding));
        System.out.println(pad("",padding*4).replace(' ', '-'));
        for(Circle circle : circles) {
            System.out.print(pad(Double.toString(circle.getRadius()), padding));
            System.out.print(pad(Double.toString(circle.getDiameter()), padding));
            System.out.print(pad(Double.toString(circle.getCircumference()), padding));
            System.out.println(pad(Double.toString(circle.getArea()), padding));
        }
        
    }
    
    //Turn a string into a certian length by filling it with trailing spaces
    public static String pad(String originalString, int length) {
        return String.format("%1$-" + length + "s", originalString);
    }
}
