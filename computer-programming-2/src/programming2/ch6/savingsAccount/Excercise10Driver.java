/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.savingsAccount;

/**
 *
 * @author Shung-Hsi Yu ID#0906172
 */

public class Excercise10Driver {
    public static void main(String[] args) {
        SavingsAccount[] savingsAccounts = new SavingsAccount[3];
        
        double startingBalance = 500;
        savingsAccounts[0] = new SavingsAccount(startingBalance, 0.0);
        savingsAccounts[1] = new SavingsAccount(startingBalance, 0.12);
        savingsAccounts[2] = new SavingsAccount(startingBalance, 0.24);
        
        
        int months = 1;
        double depositAmount = 100;
        double withdrawalAmount = 50;
        for(SavingsAccount account: savingsAccounts) {
            account.deposit(depositAmount);
            account.withdrawal(withdrawalAmount);
        }
        
        int padding = 18;
        String[] table = {"Starting Balance", "Annual int. rate", "Months",
                          "Deposits", "Withdrawals", "Interest earned", "Ending balance"};
        for(String item: table)
            System.out.print(middle(item, padding));
        System.out.println();
        
        for(SavingsAccount account: savingsAccounts) {
            System.out.print(middle(startingBalance,padding));
            System.out.print(middle(account.getAnnualInterestRate(),padding));
            System.out.print(middle(months,padding));
            System.out.print(middle(depositAmount,padding));
            System.out.print(middle(withdrawalAmount,padding));
            double balanceBeforeInterest = account.getBalance();
            for(int i = 0; i < months; i++)
                account.addInterest();
            System.out.print(middle(account.getBalance()-balanceBeforeInterest,padding));
            System.out.print(middle(account.getBalance(),padding));
            System.out.println();
        }
        
    }
    
    //Turn a string into a certian length by filling it with trailing spaces
    private static String middle(Object originalString, int length) {
        String s = String.valueOf(originalString);
        if(length > s.length()) {
            int right = s.length() + ((length - s.length() )/2);
            int left = length;
            s = String.format("%1$-" + right + "s", s);
            s = String.format("%1$" + left + "s", s);
        }
        return s;
    }
}
