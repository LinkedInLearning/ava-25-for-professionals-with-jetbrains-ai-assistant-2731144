# ScopedValue  

## The problem

You have a simple order processing system that uses `ThreadLocal` to track the current user. This has the typical ThreadLocal problems:
- You must remember to call `remove()`
- The value can leak to the next request
- Nothing prevents accidental mutation

---

## Given code (it's using `ThreadLocal`)

```java
public class OrderService {
    
    // OLD: Using ThreadLocal
    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();
    
    public static void main(String[] args) {
        // Simulate processing two orders
        processOrder("Ouidad", "ORD-001", 99.99);
        processOrder("Stephan", "ORD-002", 149.99);
    }
    
    static void processOrder(String username, String orderId, double amount) {
        // Set the user context
        CURRENT_USER.set(username);
        
        try {
            validateOrder(orderId, amount);
            saveOrder(orderId, amount);
            sendConfirmation(orderId);
        } finally {
            // Must remember to clean up!
            CURRENT_USER.remove();
        }
    }
    
    static void validateOrder(String orderId, double amount) {
        log("Validating order " + orderId);
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
    
    static void saveOrder(String orderId, double amount) {
        log("Saving order " + orderId + " for $" + amount);
    }
    
    static void sendConfirmation(String orderId) {
        log("Sending confirmation for order " + orderId);
    }
    
    static void log(String message) {
        // Read from ThreadLocal
        String user = CURRENT_USER.get();
        System.out.println("[User: " + user + "] " + message);
    }
}
```

---

## Your task

Refactor this code to use `ScopedValue` instead of `ThreadLocal`.

Follow these steps:
1. Import ScopedValue
2. Replace ThreadLocal with ScopedValue
3. Replace set() with where().run()
4. Update the log method to have a default `"unknown"` as a safe fallback