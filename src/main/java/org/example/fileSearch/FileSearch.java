package org.example.fileSearch;

import java.io.File;

public class FileSearch {
    private String fileName;
    private File directory;

    public FileSearch(String fileName, File directory) {
        this.fileName = fileName;
        this.directory = directory;
    }

    public void search() {
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directory.getAbsolutePath());
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearch search = new FileSearch(fileName, file);
                    search.search();
                } else if (file.getName().equalsIgnoreCase(fileName) || file.getName().contains(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        }
    }
}
