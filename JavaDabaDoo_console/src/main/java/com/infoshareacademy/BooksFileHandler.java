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
            element.toCustomString();
            linesToSave.add(element.toCustomString());
            for (String line : linesToSave) {
                writer.write(line);
            }
        }
    }
    // przeiterować listę books i każdy element zamienić na stringa za pomocą metody toCustomString
    // i wynik tej pętli zapisać do listy Stringów
    // listę stringów przeiterować i każdy element zapisać jako linię do pliku
    public void add(List<Book> books) {


    }
}


