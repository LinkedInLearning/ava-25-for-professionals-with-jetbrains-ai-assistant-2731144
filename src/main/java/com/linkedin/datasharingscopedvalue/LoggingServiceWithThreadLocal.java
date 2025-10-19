package com.linkedin.datasharingscopedvalue;

public class LoggingServiceWithThreadLocal {
    private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();

    void main(String[] args) {
        startRequest("REQ-42");
        handleRequest();
        endRequest();
    }

    static void startRequest(String id) {
        REQUEST_ID.set(id);
    }

    static void endRequest() {
        REQUEST_ID.remove(); // must remember to clear
    }

    static void handleRequest() {
        log("start");
        doWork();
        log("done");
    }

    static void doWork() {
        log("doing work...");
    }

    static void log(String msg) {
        System.out.println("[" + REQUEST_ID.get() + "] " + msg);
    }
}

