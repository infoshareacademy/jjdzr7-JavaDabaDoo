package com.infoshareacademy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFileHandler {

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {

        Scanner scanner = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            this.firstName = firstName;
            String firstName = split[0];
            this.lastName = lastName;
            String lastName = split[1];
        }
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    private String BOOKS_IN_LIBRARY = "lista.txt";
    public List<Book> read(){
        List<Book> bookList = new ArrayList<>();
        Scanner scanner = null;
        {
            try {
                scanner = new Scanner("lista.txt");
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] split = line.split(";");
                long id = Long.parseLong(split[4]);
                String isbn = split[5];
                String title = split[6];
                String author = split[7];
                String language = split[8];
                String category = split[9];
                List<Integer> scores = new ArrayList<>();
                String[] bookScores = split[10].split(",");

                for (String bookScore : bookScores) {
                    scores.add(Integer.valueOf(bookScore));
                }

                LocalDateTime dateOfAdd = LocalDateTime.parse(split[11]);
                bookList.add(new Book(id, isbn, title, author, language, category, scores, dateOfAdd));
            }
            return bookList;
        }
    }
    private String BOOKS_IN_HISTORY = "lista.txt";
    public List<Book> read(){
        List<Book> bookList2 = new ArrayList<>();
        Scanner scanner = null;
        {
            try{
                    scanner = new Scanner("lista2.txt");
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    String[] split = line.split(";");
                    long id2 = Long.parseLong(split[13]);
                    String isbn2 = split[14];
                    String title2 = split[15];
                    String author2 = split[16];
                    String language2 = split[17];
                    String category2 = split[18];
                    List<Integer> scores2 = new ArrayList<>();
                    String[] bookScores = split[19].split(",");

                    for (String bookScore : bookScores) {
                        scores2.add(Integer.valueOf(bookScore));
                    }

                    LocalDateTime dateOfAdd = LocalDateTime.parse(split[20]);
                    bookList2.add(new Book(id2, isbn2, title2, author2, language2, category2, scores2, dateOfAdd));
                }
                return bookList2;
            }
        }


    }
