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
public class SavingsAccount extends BankAccount {
    private final double rate = 0.025;
    private int savingNumber = 0;
    private String accountNumber;
    
    /**
     * Constructor for SavingsAccount class.
     * @param name the name of the owner of this savings account
     * @param amount the intial balance this savings account starts with
     */
    public SavingsAccount(String name, double amount) {
        super(name, amount);
        this.accountNumber = super.getAccountNumber() + "-" + savingNumber;
    }
    /**
     * Constructor for SavingsAccount class that creates a new savings 
     * account with the same owner as another specified savings account. 
     * This savings account's account number will have the same prefix 
     * as the old one.
     * @param oldAccount a savings account, the owner of it will also be the
     * owner of this new savings account.
     * @param amount the intial balance this savings account starts with
     */
    public SavingsAccount(SavingsAccount oldAccount, double begBal) {
        super(oldAccount, begBal);
        this.savingNumber = oldAccount.savingNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingNumber;
    }
    
    /**
     * Post the interest of this account.
     */
    public void postInterest() {
        double balance = super.getBalance();
        super.deposit(balance * rate);
    }
    
    /**
     * Get the account number of this savings account.
     */
    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }
}
