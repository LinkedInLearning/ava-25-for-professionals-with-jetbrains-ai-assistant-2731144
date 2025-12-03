package com.linkedin.flexibleconstructors.challenge;

public class ElectricCar extends Vehicle {
    private int batteryCapacity;  // in kWh
    private String chargingType;  // "FAST" or "STANDARD"

    public ElectricCar(String licensePlate, int year, int batteryCapacity) {
        // TODO: Add your prologue here
        //   1. Validate year
        //   2. Validate batteryCapacity
        //   3. Initialize this.batteryCapacity
        //   4. Initialize this.chargingType

        // TODO: Call super constructor
        super(licensePlate, year);

        // TODO: Add your epilogue here
        //   - Print configuration message
    }
}
