package br.edu.ifba.inf008.plugins.model;

//import java.util.concurrent.atomic.AtomicInteger;

public class Vehicle {

    //private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final int id;
    private String make;
    private String model;
    private int year;
    private FuelType fuelType;
    private Transmission transmission;
    private double mileage;
    private String status;
    private String type;

    public Vehicle(
            int id,
            String make,
            String model,
            int year,
            FuelType fuelType,
            Transmission transmission,
            double mileage,
            String status,
            String type
    ) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.mileage = mileage;
        this.status = status;
        this.type = type;
    }

    public int getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public FuelType getFuelType() { return fuelType; }
    public Transmission getTransmission() { return transmission; }
    public double getMileage() { return mileage; }
    public String getStatus() { return status; }
    public String getType() { return type; }

}
