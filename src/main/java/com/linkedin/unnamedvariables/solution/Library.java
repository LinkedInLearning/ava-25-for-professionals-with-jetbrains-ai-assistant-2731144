package com.linkedin.unnamedvariables.solution;

import java.util.List;
import java.util.ArrayList;

record Book(String title, String author, int pages, double price) {}

record Student(String name, int age, String major, double gpa) {}

public class Library {

    // Task 1 SOLUTION: Only use title and author, ignore pages and price
    static String getBookSummary(Object obj) {
        return switch (obj) {
            case Book(String title, String author, _, _) ->
                    "Book: " + title + " by " + author;
            default -> "Not a book";
        };
    }

    // Task 2 SOLUTION: Catch exception but don't use its details
    static Book loadBook(String filename) {
        try {
            // Simulate file operations that might throw an exception
            return new Book("Sample", "Author", 300, 19.99);
        } catch (Exception _) {
            // Using _ makes it explicit we're intentionally ignoring the exception
            System.out.println("Failed to load book, using default");
            return new Book("Default", "Unknown", 0, 0.0);
        }
    }
}
