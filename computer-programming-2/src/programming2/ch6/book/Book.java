/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming2.ch6.book;

/**
 *
 * @author yus
 */
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int copiesSold;

    /**
     * Constructor for Book class
     * @param title title of the book
     * @param author author of the book
     * @param publisher publisher of the book
     * @param copiesSold number of copies this this title has sold
     */
    public Book(String title, String author, String publisher, int copiesSold) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    /**
     * Get the title of the book
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Set the title of the book
     * @param title title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the book
     * @return author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the author of the book
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get the publisher of the book
     * @return publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
    
}
