package programming2.ch7.nameSearch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 07 Programming Challenges 12.
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class NameSearchProgram {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Read the boy names and girls names from the two text file into an array, respectively.
        String[] boyNames = readFrom("BoyNames.txt");
        String[] girlNames = readFrom("GirlNames.txt");
        
        //Read the user input for a name to search in the arrays
        System.out.print("Please enter a name to search: ");
        String inputName = keyboard.next();
        
        //Try to find the input name in the two arrays and store the result
        boolean boyNameFound = found(inputName, boyNames);
        boolean girlNameFound = found(inputName, girlNames);
        
        //Display the result of the finding
        if(boyNameFound) {
            System.out.println(inputName + " was found in the most popular boy names list.");
        }
        if(girlNameFound) {
            System.out.println(inputName + " was found in the most popular girl names list.");
        }
        if(!boyNameFound && !girlNameFound) {
            System.out.println(inputName + " was not found.");
        }
    }
    
    /**
     * Try to find a name inside an array and the return of its finding.
     * @param nameToSearch a String of the name to search inside the specified array
     * @param arrayToSearch the specified array in which the name is searched
     * @return true if the name is found in the specified array, false if
     *         the name is not found in the specified array.
     */
    private static boolean found(String nameToSearch, String[] arrayToSearch) {
        for(String name: arrayToSearch) {
            if(name.equalsIgnoreCase(nameToSearch)) {
                return true;
            }
        }
        return false;
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


