/**
 * Computer Programming 2 Exam 1 Review: 1 - Fibonacci Program.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 13, 2014
 */

package examreview;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        System.out.println("The first " + end + " Fibonacci numbers are:");
        System.out.println(Fibonacci.getSequence(start, end));
        System.out.println("The average is " + 
                Fibonacci.getSequenceAverage(start, end));
    }
    
    public static BigInteger getNumber(int n) {
        BigInteger number;
        if(n <= 0) {
            number = BigInteger.ZERO;
        } else if (n <= 2) {
            number = BigInteger.ONE;
        } else {
            number = getNumber(n-1).add(getNumber(n-2));
        }
        return number;
    }
    
    public static String getSequence(int start, int end) {
        StringBuilder sequence = new StringBuilder();
        for(int i = start; i <= end; i++) {
            sequence.append(getNumber(i));
            sequence.append(" ");
        }
        return sequence.toString();
    }
    
    public static double getSequenceAverage(int start, int end) {
        BigInteger number = BigInteger.ZERO;
        for(int i = start; i <= end; i++) {
            number = number.add(getNumber(i));
        }
        int count = end - start + 1;
        return number.doubleValue()/count;
    }
}
