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
public class CopyConstructorTester {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(2000);
        BankAccount accSame = acc;
        BankAccount accCopy = new BankAccount(acc);
        
        System.out.println("'acc = new BankAccount(2000);'");
        System.out.println("acc has the hash code value of " + acc.hashCode());
        System.out.println("    and a balance of " + acc.getBalance());
        System.out.println();
        System.out.println("'accSame = acc;'");
        System.out.println("accSame has the hash code value of " + accSame.hashCode());
        System.out.println("    and a balance of " + accSame.getBalance());
        System.out.println();
        System.out.println("'accCopy = new BankAccount(acc);'");
        System.out.println("accCopy has the hash code value of " + accCopy.hashCode());
        System.out.println("    and a balance of " + accCopy.getBalance());
        System.out.println();
        System.out.println("'acc == accSame' is: " + (acc == accSame));
        System.out.println("'acc == accCopy' is: " + (acc == accCopy));        
    }
}
