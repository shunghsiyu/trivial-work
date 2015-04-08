/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch7.worldseriesChampions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 07 Programming Challenges 14.
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class WorldSeriesChampions {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Read the name of the winning teams into an array
        String[] winningTeamList = readFrom("WorldSeriesWinners.txt");
        
        //Read the user input for a team name
        System.out.print("Enter the name of a team: ");
        String inputTeamName = keyboard.nextLine();
        
        //Count the number of times that team won the world series
        int numWins = count(inputTeamName, winningTeamList);
        
        //Display the result
        if(numWins > 0) {
            System.out.println("The " + inputTeamName + " have won the World Series " +
                            numWins + " times.");
        } else {
            System.out.println("The " + inputTeamName + " have never won the World Series.");
        }
    }
    
    /**
     * Lookup and count the number of times the specified team has won the world series.
     * @param teamnameToSearch the name of the team to lookup
     * @param winningTeamList the array containing the world series champions
     * @return the number of times the specified team has won the world series.
     */
    private static int count(String teamnameToSearch, String[] winningTeamList) {
        int count = 0;
        for(String name: winningTeamList) {
            if(name.equalsIgnoreCase(teamnameToSearch)) {
                count = count + 1;
            }
        }
        return count;
    }
    
    /**
     * Try to open a file using tryOpenFile method, then return an array with
     * each line in the file as individual elements.
     * @param filename filename of the file to read from.
     * @return an array of strings read from the specified file.
     */
    private static String[] readFrom(String filename) {
        ArrayList<String> list = new ArrayList<>();
        File file = tryOpenFile(filename);
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) { }
        return list.toArray(new String[list.size()]);
    }
    
    /**
     * Try to open a file and repeatedly ask the user to type the correct path
     * if the file cannot be found.
     * @param filename filename of the file to be opened.
     * @return File class instance of an exist file.
     */
    private static File tryOpenFile(String filename) {
        File file = new File(filename);
        while(!file.exists()) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Cannot find file '" + file.getAbsolutePath() + "'!");
            System.out.print("Please enter the absolute path to file: ");
            filename = keyboard.nextLine();
            file = new File(filename);
        }
        return file;
    }
}
