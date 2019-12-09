package ro.jademy.librarymgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = FileIO.getBooksFromFile("books.txt");
        Library library = new Library(books);

        library.printBooksInventory();


        // ------------------- Register new book ------------------


//        boolean check = false;
//        do {
//            System.out.println("\nPlease enter the new book details: ");
//            System.out.print("\nTitle: ");
//            String title = sc.nextLine();
//            System.out.print("Author: ");
//            String author = sc.nextLine();
//            System.out.print("Publisher: ");
//            String publisher = sc.nextLine();
//            System.out.print("ISBN: ");
//            String isbn = sc.nextLine();
//            System.out.print("No of pages: ");
//            int numberOfPages = sc.nextInt();
//            sc.nextLine();
//            System.out.print("Language: ");
//            String language = sc.nextLine();
//            System.out.print("Genre: ");
//            String genre = sc.nextLine();
//            System.out.print("Link: ");
//            String link = sc.nextLine();
//            System.out.print("Stock: ");
//            int quantity = sc.nextInt();
//            sc.nextLine();
//            Book book = new Book(title, author, publisher, isbn, numberOfPages, language, genre, link, quantity);
//            library.addBook(book);
//
//            System.out.println("Do you want to register one more book?");
//            String answer = sc.nextLine();
//            while (!answer.equals("y") && !answer.equals("n")) {
//                System.out.println("\"y\"" + " " + "or" + " " + "\"n\"");
//                answer = sc.nextLine();
//            }
//            if (answer.equals("n")) {
//                check = true;
//            }
//        } while (!check);
//        System.out.println("\nRegister completed!");
//        library.printBooksInventory();


//        -------------------------- Search --------------------------------

        System.out.print("\nWhat books do you want to find: ");
        String asked = sc.nextLine();
        library.printSearchResult(asked);


//        -------------------------- Search by Author --------------------------------

        System.out.print("\nFind books of: ");
        String writer = sc.nextLine();
        library.searchBookByAuthor(writer);

//        -------------------------- Search by Genre --------------------------------

        System.out.print("\nFind books of genre: ");
        String genreAsked = sc.nextLine();
        library.searchBookByGenre(genreAsked);

//        ------------------------ Borrow book ------------------------------

        System.out.print("\nWhat book do you want to borrow: ");
        String titleToBorrow = sc.nextLine();
        library.borrowBook(titleToBorrow);
        library.printBorrowedBooks();
        library.printBooksInventory();

//        --------------- Return borrowed book ---------------------------

        System.out.print("\nWhat book do you want to return: ");
        String titleToReturn = sc.nextLine();
        library.removeBookFromBorrow(titleToReturn);
        library.returnBookToLibrary(titleToReturn);
        library.printBorrowedBooks();
        library.printBooksInventory();


//        ------------------ Update file at the end of program ---------------

        File fileName = new File("/Users/fcb/IdeaProjects/LibraryManagement/src/main/java/ro/jademy/librarymgmt/" + "books.txt");
        FileIO.updateFile(fileName, books, false);

//        -------------------- Pentru ce a lucrat Seba ----------------------


//        List<String> genreList1 = new ArrayList<>();
//        genreList1.add("Novelty");
//        genreList1.add("Romance");
//        List<String> genreList2 = new ArrayList<>();
//        genreList2.add("SF");
//        genreList2.add("History");
//        User bob = new User("Bob", 20, 1, 23123, genreList1);
//        User ana = new User("Ana", 16, 2, 38198,genreList2);
//
//
//
//
//        library.borrowedBookByUser("Lolita", ana);
////        library.printLibraryBooks();
//        System.out.println("\n\n" + bob.getLikedGenres());
//        System.out.println(ana.getBorrowedBookList());
//
//        System.out.println("===================");
    }
}
