package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class Library {
    ArrayList<Shelf> shelves;
    private ArrayList<Book> borrowBooks;
    private ArrayList<User> userList;

    public ArrayList<User> getUserList() {
        return userList;
    }

    int costBorrow = 1;

    public Library(ArrayList<Shelf> shelves) {
        this.borrowBooks = new ArrayList<>();
        this.shelves = shelves;
        this.userList = new ArrayList<>();

    }


    public void printBorrowedBooks() {
        for (Book lendBook : borrowBooks) {
            lendBook.printDetails();
        }
    }

    public void printShelves() {
        for (Shelf shelf : shelves) {
            System.out.println(shelf.genre);
        }
    }

    public void printLibraryBooks() {
        for (Shelf shelf : shelves) {
            shelf.printShelfBooks();
            System.out.println();
        }
    }

    public void addBook(Book book) {
        boolean createNewShelf = true;
        for (Shelf shelf : shelves) {
            if (book.getGenre().equals(shelf.genre)) {
                shelf.addBookToShelf(book);
                createNewShelf = false;
            }
        }
        if (createNewShelf) {
            ArrayList<Book> newListOfBooks = new ArrayList<>();
            newListOfBooks.add(book);
            Shelf shelf = new Shelf(newListOfBooks, book.getGenre());
            shelves.add(shelf);
        }
    }

    public void addUser (User u) {
        userList.add(u);
    }

    public void printBookByTitle(String titleOfBook) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchBook(titleOfBook);
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public Book searchBookByTitle(String title) {
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks())
                if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public void searchAuthor(String author) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchAuthor(author);
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public void searchGenre(String genre) {
        for (Shelf shelf : shelves) {
            if (shelf.genre.equals(genre)) {
                shelf.printShelfBooks();
            }
        }
    }

    public void removeBook(String title) {
        for (Shelf shelf : shelves) {
            shelf.removeBook(title);
        }
    }

    public void borrowBook(String title, User user) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            removeBook(book.getTitle());
            borrowBooks.add(book);
            user.getBorrowedBookList().add(book);
            // setam cartea ca fiind imprumutata
            book.setBorrow(15);
        }
    }
}



