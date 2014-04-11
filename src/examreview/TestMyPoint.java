/**
 * Computer Programming 2 Exam 1 Review: 4 - TestMyPoint
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;


public class TestMyPoint {
    public static void main(String[] args) {
        // Test program
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);
        // Testing the overloaded method distance()
        System.out.println(p1.distance(p2)); // using distance(MyPoint another)
        System.out.println(p1.distance(5, 6)); // using distance(int x, int y)
    }
}
