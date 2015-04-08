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
        // Create a new RetailItem instance of jacket
        RetailItem retailItem = new RetailItem("Jacket", 8, 59.95);
        // Create a new CashRegister instance for two jackets
        CashRegister cashRegister = new CashRegister(retailItem, 2);
        // Get the receipt from the CashRegister instance
        String receipt = cashRegister.getReceipt();
        
        // Prepare file to write to
        File receiptFile = new File("receipt.txt");
        try (PrintWriter output = new PrintWriter(receiptFile)) {
            // Write the receipt to file
            output.append(receipt);
        } catch (FileNotFoundException ex) {
            // Print error
            System.out.println("Can't write to file " + 
                    receiptFile.getAbsolutePath());
            System.out.println("File not found");
        }
        
        // Also print the receipt on the screen
        System.out.println(receipt);
    }
}
