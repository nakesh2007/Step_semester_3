import java.util.*;

abstract class Vehicle {
    protected String vehicleId;
    protected String model;
    protected boolean available;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.available = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {

    public Sedan(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {

    public SUV(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 80;
    }
}

class Truck extends Vehicle {

    public Truck(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 100;
    }
}

class Customer {
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double charge;

    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.charge = vehicle.calculateCharge(days);
    }

    public void displayRental() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getModel());
        System.out.println("Days: " + days);
        System.out.println("Rental charge: $" + charge);
    }
}

class RentalService {

    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {

        if (!vehicle.isAvailable()) {
            System.out.println(
                vehicle.getModel() + " is currently unavailable."
            );
            return;
        }

        vehicle.setAvailable(false);

        Rental rental = new Rental(customer, vehicle, days);

        System.out.println(
            vehicle.getModel() +
            " rented successfully by " +
            customer.getName()
        );

        System.out.println(
            "Rental charge: $" +
            vehicle.calculateCharge(days)
        );
    }

    public void returnVehicle(Customer customer, Vehicle vehicle) {

        if (vehicle.isAvailable()) {
            System.out.println(
                vehicle.getModel() + " is already available."
            );
            return;
        }

        vehicle.setAvailable(true);

        System.out.println(
            vehicle.getModel() +
            " returned by " +
            customer.getName()
        );
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Customer customer1 = new Customer(1, "Customer 1");
        Customer customer2 = new Customer(2, "Customer 2");
        Customer customer3 = new Customer(3, "Customer 3");

        Vehicle sedanA = new Sedan("S1", "Sedan A");
        Vehicle suvB = new SUV("S2", "SUV B");

        RentalService service = new RentalService();
        service.rentVehicle(customer1, sedanA, 3);      
        service.rentVehicle(customer2, sedanA, 2);      
        service.returnVehicle(customer1, sedanA);
        service.rentVehicle(customer3, suvB, 5);
    }
}