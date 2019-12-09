package ro.jademy.librarymgmt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {
    public static ArrayList<Book> getBooksFromFile(String fileName) {
        ArrayList<Book> books = new ArrayList<>();
        Path filePath = Paths.get("/Users/fcb/IdeaProjects/LibraryManagement/src//main/java/ro/jademy/librarymgmt/" + fileName);

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String row = br.readLine();

            while (row != null) {
                String[] attributes = row.split(",");
                Book book = createBook(attributes);
                books.add(book);
                row = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return books;
    }

    public static Book createBook(String[] metadata) {
        String title = metadata[0];
        String author = metadata[1];
        String publisher = metadata[2];
        String isbn = metadata[3];
        int numberOfPages = Integer.parseInt(metadata[4]);
        String language = metadata[5];
        String genre = metadata[6];
        String link = metadata[7];
        int quantity = Integer.parseInt(metadata[8]);

        return new Book(title, author, publisher, isbn, numberOfPages, language, genre, link, quantity);
    }

    public static ArrayList<Book> updateFile (File fileName, ArrayList<Book> bookList, boolean append) {
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                bw.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getIsbn() + "," + book.getNumberOfPages() + "," + book.getLanguage() + "," + book.getGenre() + "," + book.getLink() + "," + book.getInventory());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}
