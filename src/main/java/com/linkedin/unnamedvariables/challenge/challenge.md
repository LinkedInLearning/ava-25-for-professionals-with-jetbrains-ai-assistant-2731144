# Unnamed variables 

## Given Code (Before Refactoring)

```java
record Book(String title, String author, int pages, double price) {}

record Student(String name, int age, String major, double gpa) {}

class Library {
    
    // Method 1: Get book summary
    static String getBookSummary(Object obj) {
        return switch (obj) {
            case Book(String title, String author, int pages, double price) -> 
                "Book: " + title + " by " + author;
            default -> "Not a book";
        };
    }
    
    // Method 2: Load book from file
    static Book loadBook(String filename) {
        try {
            // Simulate file operations
            // ...
            return new Book("Sample", "Author", 300, 19.99);
        } catch (Exception e) {
            // We don't actually use the exception details
            System.out.println("Failed to load book, using default");
            return new Book("Default", "Unknown", 0, 0.0);
        }
    }
```

---

## Your tasks

### Task 1: Refactor `getBookSummary`
The method only uses `title` and `author`. Refactor it to use unnamed variables for `pages` and `price`.

**Hint:** Use `_` for the variables you don't need.

---

### Task 2: Refactor `loadBook`
The exception is caught but never used. Make this explicit using an unnamed variable.

**Hint:** Replace the exception variable name with `_`.

---


## Solution Template

```java
class Library {
    
    // Task 1: Refactor this method
    static String getBookSummary(Object obj) {
        return switch (obj) {
            case Book(String title, String author, /* TODO */) -> 
                "Book: " + title + " by " + author;
            default -> "Not a book";
        };
    }
    
    // Task 2: Refactor this method
    static boolean isEligibleForHonors(Object obj) {
        return switch (obj) {
            case Student(/* TODO */) -> 
                gpa >= 3.5;
            default -> false;
        };
    }
    
    // Task 3: Refactor this method
    static Book loadBook(String filename) {
        try {
            // ...
            return new Book("Sample", "Author", 300, 19.99);
        } catch (Exception /* TODO */) {
            System.out.println("Failed to load book, using default");
            return new Book("Default", "Unknown", 0, 0.0);
        }
    }
    
    // Task 4: Refactor this method (optional challenge)
    static void processStudents(Student[] students) {
        // TODO: Consider a better approach
    }
}
```

---
