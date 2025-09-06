// Base class
class Vehicle {
    // Protected instance variables
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    // Constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // Common methods
    public void startVehicle() {
        System.out.println(make + " " + model + " is starting.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " is stopping.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info: " + year + " " + make + " " + model + " | Fuel: " + fuelLevel);
    }
}

// Subclass Car
class Car extends Vehicle {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    
    public void startVehicle() {
        System.out.println("Car " + make + " " + model + " starts smoothly.");
    }
}

// Subclass Truck
class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

   
    public void startVehicle() {
        System.out.println("Truck " + make + " " + model + " rumbles to life.");
    }
}


class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    @Override
    public void startVehicle() {
        System.out.println("Motorcycle " + make + " " + model + " roars to life.");
    }
}


public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Corolla", 2020, 40);
        Vehicle truck = new Truck("Ford", "F-150", 2018, 70);
        Vehicle bike = new Motorcycle("Yamaha", "R15", 2022, 15);

        Vehicle[] vehicles = {car, truck, bike};

        
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
            v.startVehicle(); 
            v.refuel(10);
            v.stopVehicle();
            System.out.println();
        }

        /*
         * EXPLANATION:
         *
         * - How does this show reusability?
         *   The Vehicle class defines common properties/methods. Car, Truck, and Motorcycle reuse
         *   this code without rewriting it.
         *mMN
         * - How could this be extended for new vehicle types?
         *   Just create another subclass (e.g., Bus, ElectricCar) that extends Vehicle and overrides methods.
         *
         * - Benefits over writing separate classes:
         *   -> Avoids code duplication (all share common logic).
         *   -> Polymorphism allows treating all vehicles the same (array of Vehicle).
         *   -> Easier maintenance and extension (just add a new subclass).
         */
    }
}
