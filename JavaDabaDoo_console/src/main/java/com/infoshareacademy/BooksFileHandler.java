package com.infoshareacademy;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksFileHandler {
    public final String BOOKS_IN_LIBRARY = "listBooks.txt";
    File file = new File(BOOKS_IN_LIBRARY);

    public List<Book> read() {
        List<Book> bookList = new ArrayList<>();


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

            }
        }
        return bookList;
    }

    public void save(List<Book> books) throws IOException {

        List<String> linesToSave = new ArrayList<>();
        Writer writer = new FileWriter(file);

        for (Book element : books) {
            String line = element.toCustomString();
            linesToSave.add(line);
        }

        for (String line : linesToSave) {
            writer.write(line);
        }
        writer.close();
    }

    public void add(Book book, List<Book> books) {

        books.add(book);

    }

    public void remove(Book book, List<Book> books) {

        books.remove(book);
        
    }
}


