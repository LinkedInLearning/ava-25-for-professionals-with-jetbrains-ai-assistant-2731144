# Flexible constructor bodies

## Given Classes

```java
class Vehicle {
    private String licensePlate;
    private int year;
    
    Vehicle(String licensePlate, int year) {
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

class ElectricCar extends Vehicle {
    private int batteryCapacity;  // in kWh
    private String chargingType;  // "FAST" or "STANDARD"
}
```

---

## Your Task

Add a constructor to the `ElectricCar` class with the following requirements:

### Requirements
1. The signature must be `ElectricCar(String licensePlate, int year, int batteryCapacity)`

2. **Validation (in prologue, before `super()`):**
    - Year must be 2010 or later
    - Battery capacity must be between 40 and 200 kWh
    - If validation fails, throw `IllegalArgumentException` with a descriptive message

3. **Field Initialization (in prologue, before `super()`):**
    - Initialize `batteryCapacity` field with the parameter value
    - Initialize `chargingType` based on battery capacity:
        - If capacity >= 75 kWh: `"FAST"`
        - Otherwise: `"STANDARD"`

4. **Superclass Constructor Call:**
    - Call the `Vehicle` constructor with appropriate arguments

5. **Additional Output (in epilogue, after `super()`):**
    - Print: `"Electric car configured with [X] kWh battery and [TYPE] charging"`

---

## Expected Behavior

### Valid Input:
```java
ElectricCar car1 = new ElectricCar("ABC-123", 2022, 85);
```
**Output:**
```
Vehicle registered: ABC-123
Electric car configured with 85 kWh battery and FAST charging
```

### Invalid Input (fail fast):
```java
ElectricCar car2 = new ElectricCar("XYZ-789", 2005, 60);
```
**Output:**
```
IllegalArgumentException: Year must be 2010 or later
```
(Note: The superclass constructor should NOT be called)

---

## Hints

- Remember: In the part before `super()`, you can only assign to uninitialized fields
- Use inline logic (like ternary operators) or static methods for calculations
- The part before invoking `super()` allows validation to fail fast before any superclass work is done
- Fields initialized there will have valid values even if the superclass constructor calls overridden methods
