package com.infoshareacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BooksFileHandler {
    private String BOOKS_IN_LIBRARY = "listBooks.txt";

    public List<Book> read() {
        List<Book> bookList = new ArrayList<>();

        File file = new File(BOOKS_IN_LIBRARY);
        Scanner scanner = null;
        {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] split = line.split(";");
                long id = Long.parseLong(split[0]);
                String isbn = split[1];
                String title = split[2];
                String author = split[3];
                String language = split[4];
                String category = split[5];
                List<Integer> scores = new ArrayList<>();
                String[] bookScores = split[6].split(",");

                for (String bookScore : bookScores) {
                    scores.add(Integer.valueOf(bookScore));
                }

                LocalDateTime dateOfAdd = LocalDateTime.parse(split[7]);
                bookList.add(new Book(id, isbn, title, author, language, category, scores, dateOfAdd));
//          else (EOF <- end of file) adding new book to list (file ?)
            }
//          adding new file to listBooks.txt
//            while (!(scanner.hasNextLine())){
//                String newBook = new Scanner();
//                newBook = scanner.nextLine();
//            }
        }
    return bookList;
    }
}
