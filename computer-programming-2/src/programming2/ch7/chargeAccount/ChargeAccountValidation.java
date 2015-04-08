/*
 * ------------------------------------------------------
 * |           ChargeAccountValidation                  |
 * ------------------------------------------------------
 * | - validNumbers: int[]                              |
 * ------------------------------------------------------
 * | + ChargeAccountModification()                      |
 * | + isValid(accountNumber: int): boolean             |
 * ------------------------------------------------------
 */

package programming2.ch7.chargeAccount;

/**
 * Chapter 07 Programming Challenges 3
 * @author Shung-Hsi Yu ID#0906172
 * @version 20140302
 */
public class ChargeAccountValidation {
    private final int[] validNumbers = {11111, 22222, 33333,
                                44444, 55555, 66666, 77777, 88888, 
                                99999, 10101, 20202, 30303, 40404, 
                                50505, 60606, 70707, 80808, 90909};
    /**
     * Default constructor
     */
    public ChargeAccountValidation() {
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
