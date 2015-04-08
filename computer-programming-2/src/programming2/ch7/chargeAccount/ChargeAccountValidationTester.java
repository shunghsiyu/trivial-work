/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch7.chargeAccount;
import java.util.Scanner;

/**
 * Chapter 07 Programming Challenges 3
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class ChargeAccountValidationTester {
    public static void main(String[] args) {
        //Create a new ChargeAccountValidation instance
        ChargeAccountValidation validator = new ChargeAccountValidation();
        
        Scanner keyboard = new Scanner(System.in);
        
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
