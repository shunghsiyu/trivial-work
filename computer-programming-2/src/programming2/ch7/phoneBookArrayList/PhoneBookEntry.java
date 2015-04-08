/*                          UML
 * ----------------------------------------------------------
 * |                   PhoneBookEntry                       |
 * ----------------------------------------------------------
 * | - name: String                                         |
 * | - phoneNumber: String                                  |
 * ----------------------------------------------------------
 * | + PhoneBookEntry(name: String, phoneNumber: String)    |
 * | + getName(): String                                    |
 * | + getPhoneNumber: String                               |
 * | + setName(name: String): void                          |
 * | + setPhoneNumber(phoneNumber: String): void            |
 * ----------------------------------------------------------
 */

package programming2.ch7.phoneBookArrayList;

/**
 * Chapter 07 Programming Challenges 16.
 * @author Shung-Hsi Yu <syu07@nyit.edu> ID#0906172
 * @version Mar 9, 2014
 */
public class PhoneBookEntry {
    private String name;
    private String phoneNumber;

    /**
     * Constructor of the PhoneBookEntry class.
     * @param name the name of the entry.
     * @param phoneNumber the phone number of the entry.
     */
    public PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the name of the entry.
     * @return the name of this entry.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the entry.
     * @param name the new name of this entry.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the phone number of this entry.
     * @return the phone number of this entry.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of this entry.
     * @param phoneNumber the new phone number of this entry.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
