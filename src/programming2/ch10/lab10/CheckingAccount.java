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

    public CheckingAccount(String name, double amount) {
        super(name, amount);
        String oldAccountNumber = super.getAccountNumber();
        super.setAccountNumber("10" + oldAccountNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + FEE);
    }
}