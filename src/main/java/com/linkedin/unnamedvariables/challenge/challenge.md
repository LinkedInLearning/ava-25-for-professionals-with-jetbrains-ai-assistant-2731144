# Unnamed variables 

## Given Code (Before Refactoring)

```java
record Book(String title, String author, int pages, double price) {}

record Student(String name, int age, String major, double gpa) {}

class Library {

    // Method 1: Get book summary
    static String getBookSummary(Object obj) {
        return switch (obj) {
            case Book(String title, String author, int pages, double price) -> "Book: " + title + " by " + author;
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
}
```

---

## Your tasks

### Task 1: Refactor `getBookSummary`
The method only uses `title` and `author`. Refactor it to use unnamed variables for `pages` and `price`.

---

### Task 2: Refactor `loadBook`
The exception is caught but never used. Make this explicit using an unnamed variable.

---

