/*
 * ------------------------------------------------------
 * |            ChargeAccountModification               |
 * ------------------------------------------------------
 * | - validNumbers: ArrayList<Integer>                 |
 * ------------------------------------------------------
 * | + ChargeAccountModification(validNumberFile: File) |
 * | + isValid(accountNumber: int): boolean             |
 * ------------------------------------------------------
 */

package programming2.ch7.chargeAccount;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Chapter 07 Programming Challenges 3B
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class ChargeAccountModification {
    private final ArrayList<Integer> validNumbers;
    
    /**
     * Constructor that takes a file object pointing to the text file containing
     * valid account numbers as parameter.
     * @param validNumberFile the file containing the valid account numbers
     * @throws FileNotFoundException 
     */
    public ChargeAccountModification(File validNumberFile) throws FileNotFoundException {
        validNumbers = new ArrayList<>();
        Scanner in = new Scanner(validNumberFile);
        while(in.hasNextInt()) {
            validNumbers.add(in.nextInt());
        }
    }
    
    /**
     * Checks whether or not a charge account number is valid.
     * @param accountNumber the charge account number to validate.
     * @return true is the account number is valid, false if the account number 
     *         is not valid.
     */
    public boolean isValid(int accountNumber) {
        for(int validNumber: validNumbers) {
            if(accountNumber == validNumber) {
                return true;
            }
        }
        return false;
    }
    
}
