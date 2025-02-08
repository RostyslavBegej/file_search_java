package org.example.fileSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.ZoneId;

public class FileSearch {
    private String fileName;
    private File directory;
    private LocalDate searchDate;

    public FileSearch(String fileName, File directory) {
        this.fileName = fileName;
        this.directory = directory;
    }

    public FileSearch(LocalDate searchDate, File directory) {
        this.searchDate = searchDate;
        this.directory = directory;
    }

    public void search() {
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directory.getAbsolutePath());
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return; // Prevent NullPointerException

        for (File file : files) {
            if (file.isDirectory()) {
                new FileSearch(fileName, file).search();
                new FileSearch(searchDate, file).search();
            } else {
                boolean nameMatch = (fileName != null && (file.getName().equalsIgnoreCase(fileName) || file.getName().contains(fileName)));
                boolean dateMatch = false;

                if (searchDate != null) {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                        FileTime creationTime = attrs.creationTime();
                        LocalDate creationDate = creationTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        dateMatch = creationDate.equals(searchDate);
                    } catch (IOException e) {
                        System.out.println("Error reading creation date for: " + file.getName());
                    }
                }

                if (nameMatch) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
                if (dateMatch) {
                    System.out.println("File created on " + searchDate + ": " + file.getAbsolutePath());
                }
            }
        }
    }
}
