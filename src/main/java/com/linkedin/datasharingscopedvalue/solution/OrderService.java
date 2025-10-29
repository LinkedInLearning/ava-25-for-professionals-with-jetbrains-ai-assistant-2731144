package com.linkedin.datasharingscopedvalue.solution;

import java.lang.ScopedValue;
import static java.lang.ScopedValue.where;

public class OrderService {

    // NEW: Using ScopedValue instead of ThreadLocal
    private static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();

    static void main(String[] args) {
        // Simulate processing two orders
        processOrder("Ouidad", "ORD-001", 99.99);
        processOrder("Stephan", "ORD-002", 149.99);
    }

    static void processOrder(String username, String orderId, double amount) {
        // NEW: Use where().run() to bind the value for this scope
        // No need for try-finally or manual cleanup!
        where(CURRENT_USER, username).run(() -> {
            validateOrder(orderId, amount);
            saveOrder(orderId, amount);
            sendConfirmation(orderId);
        });
        // Value is automatically unbound after run() completes
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
        // NEW: Use orElse() for safe reading with a fallback
        String user = CURRENT_USER.orElse("unknown");
        System.out.println("[User: " + user + "] " + message);
    }
}


