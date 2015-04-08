/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

---------------------

---------------------

 */

package programming2.ch6.testScores;

/**
 *
 * @author yus
 */
public class DriverProgram {
    public static void main(String[] args) {
        TestScores[] testScoreArray = new TestScores[3];
        
        testScoreArray[0] = new TestScores(34557);
        testScoreArray[0].setTest1(70);
        testScoreArray[0].setTest2(90);
        testScoreArray[0].setTest3(66);
        
        testScoreArray[1] = new TestScores(34456);
        testScoreArray[1].setTest1(80);
        testScoreArray[1].setTest2(90);
        testScoreArray[1].setTest3(75);
        
        testScoreArray[2] = new TestScores(78979);
        testScoreArray[2].setTest1(65);
        testScoreArray[2].setTest2(65);
        testScoreArray[2].setTest3(80);
        
        System.out.println("ID\t" +
                        "Test1\t" +
                        "Test2\t" +
                        "Test3\t" +
                        "Average");
        for(TestScores testScores : testScoreArray)
            printTestScores(testScores);
    }
    
    public static void printTestScores(TestScores testScores) {
        System.out.print(testScores.getId());
        System.out.print("\t" + (int) testScores.getTest1());
        System.out.print("\t" + (int) testScores.getTest2());
        System.out.print("\t" + (int) testScores.getTest3());
        System.out.print("\t" + testScores.getAverage());
        System.out.println();
    }
}
