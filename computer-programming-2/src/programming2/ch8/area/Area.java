/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.area;

import java.text.DecimalFormat;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 31, 2014
 */
public class Area {
    private static class Circle{
        private final double radius;
 
        public Circle(double radius) {
            this.radius = radius;
        }
 
        public double getRadius() {
            return this.radius;
        }
    }
 
    private static class Rectangle{
        private final double length;
        private final double width;
 
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }
 
        public double getLength() {
            return this.length;
        }
 
        public double getWidth() {
            return this.width;
        }
    }
 
    private static class Cylinder{
        private final double radius;
        private final double height;
 
        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }
 
        public double getRadius() {
            return this.radius;
        }
 
        public double getHeight() {
            return this.height;
        }
    }
 
    public static void main(String[] args) {
        Circle shape0 = new Circle(1);
        Circle shape1 = new Circle(5);
        Rectangle shape2 = new Rectangle(3, 6);
        Rectangle shape3 = new Rectangle(2.5, 5.5);
        Cylinder shape4 = new Cylinder(1, 1);
        Cylinder shape5 = new Cylinder(2, 2);
 
        int columnWidth = 10;
        printRow(columnWidth, "radius", "", "Area");
        printRow(columnWidth, "Circle", getInfo(shape0, columnWidth), getArea(shape0));
        printRow(columnWidth, "", getInfo(shape1, columnWidth), getArea(shape1));
 
        printRow(columnWidth, "length", "width", "Area");
        printRow(columnWidth, "Rectangle", getInfo(shape2, columnWidth), getArea(shape2));
        printRow(columnWidth, "", getInfo(shape3, columnWidth), getArea(shape3));
 
        printRow(columnWidth, "radius", "height", "Area");
        printRow(columnWidth, "Cylinder", getInfo(shape4, columnWidth), getArea(shape4));
        printRow(columnWidth, "", getInfo(shape5, columnWidth), getArea(shape5));
    }
 
    private static void printRow(int columnWidth, String item1, String item2, String item3) {
        System.out.format("%" + columnWidth + "s %" + columnWidth +
            "s %" + columnWidth + "s %" + columnWidth + "s",
             "", item1, item2, item3);
        System.out.println();
    }
 
    private static void printRow(int columnWidth, String item1, String item2, double item3) {
        System.out.format("%" + columnWidth + "s %" + columnWidth +
            "s %" + columnWidth + ".2f",
             item1, item2, item3);
        System.out.println();
    }
 
    private static double getArea(Circle circle) {
        return Math.pow(circle.getRadius(),2)*Math.PI;
    }
 
    private static double getArea(Rectangle rectangle) {
        return rectangle.getLength()*rectangle.getWidth();
    }
 
    private static double getArea(Cylinder cylinder) {
        return Math.pow(cylinder.getRadius(),2)*Math.PI*cylinder.getHeight();
    }
 
    private static String getInfo(Circle circle, int columnWidth) {
        return String.format("%" + columnWidth + ".0f %" + columnWidth +
         "s", circle.getRadius(), "");
    }
 
    private static String getInfo(Rectangle rectangle, int columnWidth) {
        return String.format("%" + columnWidth + "s %" + columnWidth +
         "s", rectangle.getLength(), rectangle.getWidth());
    }
 
    private static String getInfo(Cylinder cylinder, int columnWidth) {
        return String.format("%" + columnWidth + ".0f %" + columnWidth +
         ".0f", cylinder.getRadius(), cylinder.getHeight());
    }
}