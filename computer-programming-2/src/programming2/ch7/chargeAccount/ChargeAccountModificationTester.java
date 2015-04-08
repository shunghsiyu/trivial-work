/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch7.chargeAccount;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chapter 07 Programming Challenges 3B
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class ChargeAccountModificationTester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Create a reference for the ChargeAccountModification class instance
        ChargeAccountModification validator = null;
        //The name of the file containing the valid numbers
        String validNumberFilename = "validnumbers.txt";
        
        //Try to open the file containing the valid numbers
        //and repeatedly ask user to type the correct path to the file
        //if it cannot be found.
        do {
            File validNumberFile = new File(validNumberFilename);
            try {
                validator = new ChargeAccountModification(validNumberFile);
            } catch (FileNotFoundException e) {
                System.out.println("Cannot find file '" + validNumberFile.getAbsolutePath() + "'!");
                System.out.print("Please enter the absolute path to file: ");
                validNumberFilename = keyboard.nextLine();
            }
        } while(validator == null);
        
        //Read charge account number from user input
        System.out.print("Please enter a charge account number: ");
        String input = keyboard.next();
        
        //Initialize a boolean to false. In case the input couldn't be converted
        //into an integer, the input account number is taken as invalid.
        boolean valid = false;
        try {
            int inputNumber = Integer.valueOf(input);
            valid = validator.isValid(inputNumber);
        } catch (NumberFormatException e) { }
        
        if(valid) {
            System.out.println("Good! The charge account number " + input + " is valid!");
        }
        else {
            System.out.println("The charge account number " + input + " is NOT valid!");
        }
    }
}
