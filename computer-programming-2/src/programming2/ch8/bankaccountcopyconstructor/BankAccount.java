/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch8.bankaccountcopyconstructor;

/**
 *
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 31, 2014
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(BankAccount bankAccountToCopy) {
        this(bankAccountToCopy.getBalance());
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
