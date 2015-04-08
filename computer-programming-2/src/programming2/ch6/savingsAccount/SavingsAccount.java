/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
---------------------------------------------------
|                 SavingsAccount                  |
---------------------------------------------------
| - balance: double                               |
| - annualInterestRate: double                    |
---------------------------------------------------
| + SavingsAccount(startBalance: double,          |
|                  annualInterestRate: double)    |
| + getBalance(): double                          |
| + withdrawal(withdrawalAmount: double): void    |
| + desposit(despositAmount: double): void        |
| + getAnnualInterestRate(): double               |
| + getMonthlyInterestRate(): double              |
| + addInterest(): void                           |
---------------------------------------------------
*/

package programming2.ch6.savingsAccount;

/**
 *
 * @author Shung-Hsi Yu ID#0906172
 */
public class SavingsAccount {
    private double balance;
    private double annualInterestRate;

    public SavingsAccount(double startBalance, double annualInterestRate) {
        this.balance = startBalance;
        this.annualInterestRate = annualInterestRate;
    }
    
    public double getBalance() {
        return balance;
    }

    public void withdrawal(double withdrawalAmount) {
        this.balance = balance - withdrawalAmount;
    }
    
    public void deposit(double depositAmount) {
        this.balance = balance + depositAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate/12.0;
    }

    public void addInterest() {
        this.addInterest("simple");
    }
    
    public void addInterest(String interestType) {
        if(interestType.equalsIgnoreCase("compound"))
            this.deposit(balance * Math.pow(annualInterestRate, 1/12.0));
        else
            this.deposit(balance * getMonthlyInterestRate());
    }
}
