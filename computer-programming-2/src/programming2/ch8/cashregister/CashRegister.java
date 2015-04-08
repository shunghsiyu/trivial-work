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
    
    /**
     * Constructor for CashRegister class.
     * @param retailItem specified retailItem for this CashRegister instance
     * @param quantity quantity of the item
     */
    public CashRegister(RetailItem retailItem, int quantity) {
        this.retailItem = new RetailItem(retailItem);
        this.quantity = quantity;
    }
    
    /**
     * Get the subtotal of this CashRegister instance. Subtotal is the price
     * multiplied by the quantity of the item.
     * @return subtotal of this CashRegister instance
     */
    public double getSubTotal() {
        return retailItem.getPrice() * quantity;
    }
    
    /**
     * Get the tax that would be applied to the subtotal.
     * @return amount tax that will be applied
     */
    public double getTax() {
        return getSubTotal() * TAX_RATE;
    }
    
    /**
     * Get the total cost. Total cost is the subtotal plus tax.
     * @return the total cost of this CashRegister instance
     */
    public double getTotal() {
        return getSubTotal() + getTax();
    }
    
    /**
     * Get the receipt in tax for this CashRegister instance. The receipt 
     * includes the description, unit price, quantity of the item, and the 
     * subtotal, tax and total.
     * @reutrn receipt of this CashRegister instance.
     */
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
