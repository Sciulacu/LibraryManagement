package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class Library {

    ArrayList<Shelf> shelves;
    ArrayList<Book> borrowed;
    ArrayList<Book> borrowBooks = new ArrayList<>();
    int costBorrow = 1;


    public Library() {
        this.shelves = new ArrayList<>();
        this.borrowed = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        this.shelves = new ArrayList<>();
        this.borrowed = new ArrayList<>();

        for (Book book : books) {
            addBook(book);
        }
    }

    public void printBooksInventory() {
//        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+=========+======+");
//        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "About", "Pcs");
//        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+=========+======+");
        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+======+");
        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "Pcs");
        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+======+");
        for (Shelf shelf : shelves) {
            shelf.printBooks();
        }
    }

    public void printTitle() {
        for (Shelf shelf : shelves) {
            shelf.printTitle();
        }
    }

    public void printSearchResult(String filter) {
        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+======+");
        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "Pcs");
        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+======+");
        for (Shelf shelf : shelves) {
            shelf.search(filter);
        }
    }

    public Book searchBookByTitle(String titleRequested) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchTitle(titleRequested);
            if (book != null) {
                return book;
            }
        }
        return null;
    }

    public void searchBookByAuthor(String authorRequested) {
        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+======+");
        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "Pcs");
        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+======+");
        for (Shelf shelf : shelves) {
            shelf.searchAuthor(authorRequested);
        }
    }

    public void searchBookByGenre(String genreRequested) {
        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+======+");
        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "Pcs");
        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+======+");
        for (Shelf shelf : shelves) {
            shelf.searchGenre(genreRequested);
        }
    }

    public void printGenres() {
        for (Shelf shelf : shelves) {
            shelf.printGenre();
        }
    }

    public void addBook(Book newBook) {

        boolean bookAdded = false;
        for (Shelf shelf : shelves) {
            if (newBook.getGenre().equals(shelf.genre)) {
                shelf.books.add(newBook);
                bookAdded = true;
                break;
            }
        }

        if (!bookAdded) {
            ArrayList<Book> newBookList = new ArrayList<>(); // Am creat un nou arraylist de carti.
            newBookList.add(newBook); // Am pus noua carte in lista.
            Shelf newShelf = new Shelf(newBookList, newBook.getGenre()); // Am creat un nou shelf cu genre-ul al noii carti si lista de mai sus.
            shelves.add(newShelf); // Am adaugat raftul la lista de rafturi.
        }
    }

    public void removeBookFromShelf(String title) {
        for (Shelf shelf : shelves) {
            shelf.removeBookToBorrow(title);
        }
    }

    public void borrowBook(String titleToBorrow) {
        // cautam cartea pe toate rafturile
        // in momentul in care am gasit cartea pe un raft, o luam de acolo si o punem in lista de borrowed books
        Book borrowedBook = searchBookByTitle(titleToBorrow);
        if (borrowedBook.getTitle().equals(titleToBorrow)) {
//            if (borrowedBook != null) {
            removeBookFromShelf(borrowedBook.getTitle());
            borrowed.add(borrowedBook);
//            }
        }
    }

    public void printBorrowedBooks() {
        System.out.println("\nBorrowed book(s):");
        System.out.println("\n+===============================+===============================+===============================+=====================+=======================+=========+======+");
        System.out.printf("| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-30s\033[0m| \033[32;1m%-20s\033[0m| \033[32;1m%-22s\033[0m| \033[32;1m%-8s\033[0m| \033[32;1m%-5s\033[0m|\n", "Title", "Author", "Publisher", "ISBN", "Genre", "Language", "Pcs");
        System.out.println("+===============================+===============================+===============================+=====================+=======================+=========+======+");
        // parcurgi lista de borrwed books si printezi fiecare carte de acolo
        for (Book book : borrowed) {
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public void returnBookToShelf(String title) {
        for (Shelf shelf : shelves) {
            shelf.returnBookFromBorrow(title);
        }
    }

    public void removeBookFromBorrow(String titleToReturn) {
        for (Book book : borrowed) {
            if (book.getTitle().equals(titleToReturn)) {
                borrowed.remove(book);
                break;
            }
        }
    }

    public void returnBookToLibrary(String titleToReturn) {
        Book returnBook = searchBookByTitle(titleToReturn);
        if (returnBook.getTitle().equals(titleToReturn)) {
            returnBookToShelf(returnBook.getTitle());
        }
    }

    //    public void borrowBook(String title, User user) {
//        Book book = searchBookByTitle(title);
//        if (book != null) {
//            removeBook(book.getTitle());
//            borrowBooks.add(book);
//            user.getBorrowedBookList().add(book);
//            // setam cartea ca fiind imprumutata
//            book.setBorrow(15);
//        }
//    }

    //        -------------------- Pentru ce a lucrat Seba ----------------------

    public void removeBook(String title) {
        for (Shelf shelf : shelves) {
            shelf.removeBook(title);
        }
    }

    public void borrowedBookByUser(String title, User user) {
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
