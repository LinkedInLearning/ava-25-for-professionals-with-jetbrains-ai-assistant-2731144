package com.linkedin.datasharingscopedvalue;

import static java.lang.ScopedValue.where;

public class LoggingServiceWithoutThreadLocal {
    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

    void main(String[] args) {
        where(REQUEST_ID, "REQ-42").run(() -> handleRequest());
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

