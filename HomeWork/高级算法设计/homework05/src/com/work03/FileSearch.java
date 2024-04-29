package com.work03;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        String searchDir = "path/to/search/directory";
        String searchPattern = "filename_pattern";

        searchFiles(searchDir, searchPattern);
    }

    public static void searchFiles(String directory, String pattern) {
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            System.out.println("Invalid directory: " + directory);
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file.getAbsolutePath(), pattern);
                } else if (file.getName().matches(pattern)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        }
    }
}

