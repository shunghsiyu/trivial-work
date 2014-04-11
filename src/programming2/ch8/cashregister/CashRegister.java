/**
 * Chapter 8 Programming Challenges 6.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Apr 9, 2014
 */

/*
                          UML
----------------------------------------------------------
|                      CashRegister                      |
----------------------------------------------------------
| $ TAX_RATE: double                                     |
| - retailItem: RetailItem                               |
| - quantity: int                                        |
---------------------------------------------------------|
| + CashRegister(retailItem: RetailItem, quantity: int)  |
| + getSubTotal(): double                                |
| + getTax(): double                                     |
| + getTotal(): double                                   |
| + getReceipt(): String                                 |
----------------------------------------------------------
*/

package programming2.ch8.cashregister;


public class CashRegister {
    public static final double TAX_RATE = 0.06; 
    private final RetailItem retailItem;
    private final int quantity;

    public CashRegister(RetailItem retailItem, int quantity) {
        this.retailItem = new RetailItem(retailItem);
        this.quantity = quantity;
    }
    
    public double getSubTotal() {
        return retailItem.getPrice() * quantity;
    }
    
    public double getTax() {
        return getSubTotal() * TAX_RATE;
    }
    
    public double getTotal() {
        return getSubTotal() + getTax();
    }
    
    public String getReceipt() {
        int columnSpace = 12;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SALES RECEIPT%n"));
        sb.append(String.format("%-" + columnSpace + "s %s%n", "Item:",
                retailItem.getDescription()));
        sb.append(String.format("%-" + columnSpace + "s $%.2f%n", "Unit Price:",
                retailItem.getPrice()));
        sb.append(String.format("%-" + columnSpace + "s %d%n", "Quantity:",
                quantity));
        sb.append(String.format("%-" + columnSpace + "s $%.2f%n", "Subtotal:",
                getSubTotal()));
        sb.append(String.format("%-" + columnSpace + "s $%.2f%n", "Sales Tax:",
                getTax()));
        sb.append(String.format("%-" + columnSpace + "s $%.2f%n", "Total:",
                getTotal()));
        return sb.toString();
    }
}
