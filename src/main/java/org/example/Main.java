package org.example;

import org.example.fileSearch.FileSearch;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\uD83D\uDC4B Welcome to the File Search Program!\n\n" +
                "This tool allows you to quickly and easily search for files on your system.\n" +
                "Simply enter the name or keyword of the file you're looking for,\n" +
                "and the program will scan your directories to find matching results.\n");

        System.out.print("Enter the directory from which to start the search: ");
        File startingPath = new File(scanner.nextLine());

        System.out.print("Search by (1) File Name or (2) Creation Date? Enter 1 or 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        FileSearch fileSearch = null;
        if (choice == 1) {
            System.out.print("Enter the file name or keyword: ");
            String fileName = scanner.nextLine();
            fileSearch = new FileSearch(fileName, startingPath);
            fileSearch.search();
        } else if (choice == 2) {
            System.out.print("Enter the creation date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            LocalDate searchDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            fileSearch = new FileSearch(searchDate, startingPath);
            fileSearch.search();
        } else {
            System.out.println("Invalid choice! Exiting.");
            scanner.close();
            return;
        }
        scanner.close();
    }
}