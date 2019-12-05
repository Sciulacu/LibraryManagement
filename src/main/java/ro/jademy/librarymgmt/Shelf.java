package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class Shelf {

    ArrayList<Book> books;
    String genre;

    public Shelf() {

    }

    public Shelf(ArrayList<Book> books, String genre) {
        this.books = books;
        this.genre = genre;
    }


    public void printBooks() {
        System.out.printf("  \033[34;1m%-151s\033[0m\n", genre);
        System.out.println("+-------------------------------+-------------------------------+-------------------------------+---------------------+-----------------------+---------+------+");
//        for (int i = 0; i < books.size(); i++) {
//            Book book = books.get(i);
//        int maxLength = 0;
//        for (int i = 0; i < books.size(); i++) {
//            Book book = books.get(i);
        for (Book book : books) {
                book.printDetails();
        }

    }

    public void printTitle() {
        for (Book book : books) {
            book.printTitles();
        }
    }

    public void printGenre() {
        System.out.println("Genre: " + genre);
    }

    public void search(String searchRequest) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchRequest.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(searchRequest.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchRequest.toLowerCase()) ||
                    book.getIsbn().toLowerCase().contains(searchRequest.toLowerCase()) ||
                    book.getPublisher().toLowerCase().contains(searchRequest.toLowerCase())) {
                book.printDetails();
            }
        }
    }


    public Book searchTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void searchAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                book.printDetails();
            }
        }
    }

    public void searchGenre(String genre) {
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                book.printDetails();
            }
        }
    }

    public void removeBookToBorrow(String titleToRemove) {
        for (Book book : books) {
            if (book.getTitle().equals(titleToRemove)) {
                book.setInventory(book.getInventory() - 1);
                break;
            }
        }
    }

    public void returnBookFromBorrow(String titleToReturn) {
        for (Book book : books) {
            if (book.getTitle().equals(titleToReturn)) {
                book.setInventory(book.getInventory() + 1);
                break;
            }
        }
    }

    //        -------------------- Pentru ce a lucrat Seba ----------------------

    public void removeBook(String title) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                //book.printDetails();
                bookToRemove = book;
                break;
            }
        }
        books.remove(bookToRemove);
    }
}
