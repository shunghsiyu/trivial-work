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

    public SavingsAccount(String name, double amount) {
        super(name, amount);
        this.accountNumber = super.getAccountNumber() + "-" + savingNumber;
    }
    
    public SavingsAccount(SavingsAccount oldAccount, double begBal) {
        super(oldAccount, begBal);
        this.savingNumber = oldAccount.savingNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingNumber;
    }

    public void postInterest() {
        double balance = super.getBalance();
        super.deposit(balance * rate);
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }
}