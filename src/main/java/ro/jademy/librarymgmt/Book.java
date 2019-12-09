package ro.jademy.librarymgmt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int numberOfPages;
    private String language;
    private String genre;
    private int inventory;
    private Date borrowDate;
    private Date returnDate;
    private String link;

    public Book(String title, String author, String publisher, String isbn, int numberOfPages, String language, String genre,
                String link, int inv) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.genre = genre;
        this.link = link;
        this.inventory = inv;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getLink() {return link; }

    public void setLink(String link) {this.link = link; }

    public void setBorrow(int days) {
        borrowDate = new Date();
        returnDate = setReturnDate(days);
    }

    public Date setReturnDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(borrowDate);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    //    public void printDetails() {
//        System.out.printf("| %-30.30s| %-30s| %-30s| %-20s| %-22.22s| %-8s| %-8s|%6s|\n", title, author, publisher, isbn, genre, language, link, inventory);
//        System.out.println("+-------------------------------+-------------------------------+-------------------------------+---------------------+-----------------------+---------+---------+------+");
//
//    }
    public void printDetails() {
        System.out.printf("| %-30.30s| %-30s| %-30s| %-20s| %-20s| %-20.20s|%6s|%n", title, author, publisher, isbn, language, genre, inventory);
        System.out.println("+-------------------------------+-------------------------------+-------------------------------+---------------------+---------------------+---------------------+------+");

    }

    public void printTitles() {
        System.out.println("Title: " + getTitle());

    }
}
