/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch10.lab10;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 16, 2014
 */
public class CheckingAccount extends BankAccount {
    public static final double FEE = 0.15;
    
    /**
     * Constructor for the CheckingAccount class.
     * @param name the name of the checking account owner
     * @param amount the initial amount this checking account starts with
     */
    public CheckingAccount(String name, double amount) {
        super(name, amount);
        String oldAccountNumber = super.getAccountNumber();
        super.setAccountNumber("10" + oldAccountNumber);
    }
    
    /**
     * Withdraw the specified fee from this checking account. 
     * A fee will be applied.
     * @param amount the amount of money to withdraw
     */
    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + FEE);
    }
}
