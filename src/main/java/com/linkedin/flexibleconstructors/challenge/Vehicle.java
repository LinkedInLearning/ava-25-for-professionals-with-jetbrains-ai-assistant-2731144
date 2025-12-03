package com.linkedin.flexibleconstructors.challenge;

class Vehicle {
    private String licensePlate;
    private int year;

    public Vehicle(String licensePlate, int year) {
        this.licensePlate = licensePlate;
        this.year = year;
        System.out.println("Vehicle registered: " + licensePlate);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }
}
