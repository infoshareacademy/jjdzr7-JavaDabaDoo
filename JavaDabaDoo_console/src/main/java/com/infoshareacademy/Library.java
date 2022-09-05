package com.infoshareacademy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private Scanner sc = new Scanner(System.in);

    void controlLoop() {
        Option option;


        do {
            printOptions();
            option = getOption();
            switch (option) {
                case SEARCH_BOOK:
                    //function
                    break;
                case ADD_BOOK:
                    //function
                    break;
                case PRINT_BOOKS:
                    //function
                    break;
                case DETAILS_BOOK:
                    //function
                    break;
                case BORROW_BOOK:
                    //function
                    break;
                case PRINT_BORROWED:
                    //function
                    break;
                case PRINT_HISTORY:
                    //function
                    break;
                case PRINT_NEW_BOOKS:
                    //function
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Wrong option, please try again: ");
            }
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        System.out.println("Choose option: ");
        for (Option option : Option.values()) {
            System.out.println(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.values()[getInt()];
                optionOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again with the option's number:");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Number do not match the following options, try again.");
            }
        }

        return option;
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    private void exit() {

        //saving to file function
        System.out.println("Data has been successfully exported");

        sc.close();
        System.out.println("Program end, ciao!");
    }

    private enum Option {
        EXIT(0, "Exit"),
        SEARCH_BOOK(1, "Search book"),
        ADD_BOOK(2, "Add book"),
        PRINT_BOOKS(3, "Display all books"),
        DETAILS_BOOK(4, "Display book's details"),
        BORROW_BOOK(5, "Borrow book"),
        PRINT_BORROWED(6, "Display borrowed books"),
        PRINT_HISTORY(7, "Print borrow history"),
        PRINT_NEW_BOOKS(8, "Find book");


        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }


    }
}