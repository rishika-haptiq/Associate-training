package com.store;

public class Driver {
    private final String name;
    private boolean isAvailable;

    public Driver(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }

    public synchronized void assign() {
        isAvailable = false;
    }

    public String getName() {
        return name;
    }
}
