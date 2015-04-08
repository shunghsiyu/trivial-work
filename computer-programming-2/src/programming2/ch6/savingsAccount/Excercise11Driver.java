/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.savingsAccount;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Shung-Hsi Yu ID#0906172
 */
public class Excercise11Driver {
    
    public static void main(String[] args) {
        File depositFile = tryOpenFile("Deposits.txt");
        File withdrawalFile = tryOpenFile("Withdrawals.txt");
        
        int padding = 18;
        String[] table = {"Starting Balance", "Annual int. rate", "Months",
                          "Deposits", "Withdrawals", "Interest earned", "Ending balance"};
        for(String item: table)
            System.out.print(middle(item, padding));
        System.out.println();
        
        int numRun = 3;
        for(int run = 0; run < numRun; run++) {
            int months = 1;
            double startingBalance = 500;
            double annualInterestRate = 0.12*run;
            SavingsAccount account = new SavingsAccount(startingBalance, annualInterestRate);
            
            System.out.print(middle(account.getBalance(),padding));
            
            System.out.print(middle(account.getAnnualInterestRate(),padding));
            
            System.out.print(middle(months,padding));
            
            double totalDeposit = depositAll(account, depositFile);
            System.out.print(middle(totalDeposit,padding));
            
            double totalWithdrawal = withdrawalAll(account, withdrawalFile);
            System.out.print(middle(totalWithdrawal,padding));
            
            double balanceBeforeInterest = account.getBalance();
            account.addInterest();
            String interestEarned = String.format("%1$1.2f", account.getBalance()-balanceBeforeInterest);
            System.out.print(middle(interestEarned,padding));
            
            String balance = String.format("%1$1.2f", account.getBalance());
            System.out.println(middle(balance,padding));
        }
    }
    
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
    
    private static File tryOpenFile(String filename) {
        File file = new File(filename);
        while(!file.exists()) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Cannot find file '" + file.getAbsolutePath() + "'!");
            System.out.print("Please enter the absolute path to file: ");
            filename = keyboard.nextLine();
            file = new File(filename);
        }
        return file;
    }
    
    private static double depositAll(SavingsAccount account, File depositFile) {
        return transactAll(account, depositFile, "deposit");
    }
    
    private static double withdrawalAll(SavingsAccount account, File withdrawalFile) {
        return transactAll(account, withdrawalFile, "withdrawal");
    }
    
    private static double transactAll(SavingsAccount account, File readFile, String action) {
        double total = Double.NaN;
        
        try {
            Scanner fileReader = new Scanner(readFile);
            total = 0;
            while(fileReader.hasNextDouble()) {
                double amount = fileReader.nextDouble();

                if(action.equalsIgnoreCase("deposit"))
                    account.deposit(amount);
                else if(action.equalsIgnoreCase("withdrawal"))
                    account.withdrawal(amount);

                total = total + amount;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file '" + readFile.getAbsolutePath() + "'!");
        }
        
        return total;
    }
}
