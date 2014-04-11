/**
 * Chapter 8 Programming Challenges 6.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

package programming2.ch8.cashregister;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CashRegisterTester {
    public static void main(String[] args) {
        RetailItem retailItem = new RetailItem("Jacket", 8, 59.95);
        CashRegister cashRegister = new CashRegister(retailItem, 2);
        String receipt = cashRegister.getReceipt();
        
        File receiptFile = new File("receipt.txt");
        try (PrintWriter output = new PrintWriter(receiptFile)) {
            output.append(receipt);
        } catch (FileNotFoundException ex) {
            System.out.println("Can't write to file " + 
                    receiptFile.getAbsolutePath());
            System.out.println("File not found");
        }
        
        System.out.println(receipt);
    }
}
