public class Car {
    // defining the instance variables
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor to intialize all the atributes
    Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.year = year;
        this.isRunning = false;
    }

    // instance methods
    void startEngine() {
        isRunning = true;
        System.out.println("Car has started. isRunning status: " + isRunning);

    }

    void stopEngine() {
        isRunning = false;
        System.out.println("Car has stopped. isRunning status: " + isRunning);

    }

    void displayInfo() {
       
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " +color);
        System.out.println("isRunning: "+isRunning);
    }
    int getAge(int currentYear){
        return currentYear-year;
        
    }

    public static void main(String[] args){
        Car c1=new Car("BMW", "X11", 2011, "PINK");
        Car c2=new Car("BYD", "BBHAIHD", 2022, "BLUE");
        Car c3=new Car("MARUTI SUZUKI", "KHASOIH", 2000, "RED");
        c1.startEngine();
        c1.stopEngine();
        c2.startEngine();
        c3.startEngine();
        System.out.println("Car 1 info:");
        c1.displayInfo();
        System.out.println("Age: "+c1.getAge(2025));
         System.out.println("Car 2 info:");
         c2.displayInfo();
          System.out.println("Age: "+c2.getAge(2025));
          System.out.println("Car 3 info:");
          c3.displayInfo();
           System.out.println("Age: "+c3.getAge(2025));
    }
    // In the real world, every car is an individual object with its own attributes 
// (brand, model, year, color, mileage, etc.) and behaviors (start, stop, display info).
// Even though all cars share common behaviors, the state of each car is different. 
// For example, one car may have its engine running while another is stopped.
// This is similar to how each object in programming maintains its own state 
// and provides methods to interact with it.


}