package com.linkedin.unnamedvariables.solution;


import java.util.List;

public class Demo {
    void main(String[] args) {
        System.out.println("=== Task 1: Get Book Summary ===");
        Book book1 = new Book("Learn Java with Projects", "Seán and Maaike", 500, 49.99);
        System.out.println(Library.getBookSummary(book1));

        System.out.println("\n=== Task 2: Load Book (with exception) ===");
        Book loaded1 = Library.loadBook("books.txt");
        System.out.println("Loaded: " + loaded1.title());
    }
}
