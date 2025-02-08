package org.example;

import org.example.fileSearch.FileSearch;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\uD83D\uDC4BWelcome to the File Search Program!\n\n" +
                "This tool allows you to quickly and easily search for files on your system.\n" +
                "Simply enter the name or keyword of the file you're looking for,\n" +
                "and the program will scan your directories to find matching results.\n");
        System.out.print("Enter the directory from which to start the search: ");
        File startingPath = new File(scanner.nextLine());
        System.out.print("Please enter the name or keyword of the file you're looking for: ");
        String input = scanner.nextLine();

        FileSearch fileSearch = new FileSearch(input, startingPath);
        fileSearch.search();
        scanner.close();
    }
}