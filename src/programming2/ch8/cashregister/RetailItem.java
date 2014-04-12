/**
 * Chapter 8 Programming Challenges 6.
 * @author Shung-Hsi Yu, syu07@nyit.edu, ID# 0906172
 */

/*
                               UML
----------------------------------------------------------------------
|                            RetailItem                              |
----------------------------------------------------------------------
| - description: String                                              |
| - unitsOnHand: int                                                 |
| - price: double                                                    |
----------------------------------------------------------------------
| + RetailItem(retailItemToCopy: RetailItem)                         |
| + RetailItem(description: String, unitsOnHand: int, price: double) |
| + getDescription(): String                                         |
| + setDescription(description: String): void                        |
| + getUnitsOnHand(): int                                            |
| + setUnitsOnHand(unitsOnHand: int): void                           |
| + getPrice(): double                                               |
| + setPrice(price: double): void                                    |
----------------------------------------------------------------------
*/

package programming2.ch8.cashregister;


public class RetailItem {
    private String description;
    private int unitsOnHand;
    private double price;

    /**
     * Copy constructor for RetailItem class.
     * @param retailItemToCopy 
     */
    public RetailItem(RetailItem retailItemToCopy) {
        this(retailItemToCopy.getDescription(), 
                retailItemToCopy.getUnitsOnHand(), retailItemToCopy.getPrice());
    }

    /**
     * Constructor for RetailItem class.
     * @param description description of the item
     * @param unitsOnHand number of items the owner has
     * @param price price of the item
     */
    public RetailItem(String description, int unitsOnHand, double price) {
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
    }

    /**
     * Get the description of the item.
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the item.
     * @param description description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the number of items the owner has.
     * @return the number of items the owner has
     */
    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    /**
     * Set the number of items the owner has.
     * @param unitsOnHand the number of items the owner has
     */
    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    /**
     * Get the price of the item.
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the item.
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
