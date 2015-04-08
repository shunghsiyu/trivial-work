/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch7.nameSearch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author yus
 */
public class NameSearchProgramB {
    public static ArrayList<String> boyNames;
    
    public static void main(String[] args) {
        boyNames = readFrom("BoyNames.txt");
        
        File girlNameFile = tryOpenFile("GirlNames.txt");
        try {
            Scanner in = new Scanner(girlNameFile);
            while(in.hasNextLine()) {
                String girlName = in.nextLine();
                lookup(girlName, boyNames);
            }
        } catch (FileNotFoundException e) { }
        
        }
    
    private static void lookup(String nameToSearch, ArrayList<String> arrayListToSearch) {
        if(found(nameToSearch, arrayListToSearch)) {
            System.out.println(nameToSearch + " was also found in the most popular boy names list!");
        }
    }
    
    private static boolean found(String nameToSearch, ArrayList<String> arrayListToSearch) {
        for(String name: arrayListToSearch) {
            if(name.equalsIgnoreCase(nameToSearch)) {
                return true;
            }
        }
        return false;
    }
    
    private static ArrayList<String> readFrom(String filename) {
        ArrayList<String> list = new ArrayList<>();
        File file = tryOpenFile(filename);
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) { }
        return list;
    }
    
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


