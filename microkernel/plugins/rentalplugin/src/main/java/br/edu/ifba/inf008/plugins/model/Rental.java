package br.edu.ifba.inf008.plugins.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {

    private Long id;

    private Client customer;
    private Vehicle vehicle;
    private VehicleType vehicleType;

    private double baseRate;
    private double insuranceFee;

    private LocalDate startDate;
    private LocalDate endDate;

    private String pickupLocation;

    private RentalStatus rentalStatus;
    private PaymentStatus paymentStatus;
    private RentalType rentalType;

    /* Construtor para nova locação */
    public Rental(
            Client customer,
            Vehicle vehicle,
            VehicleType vehicleType,
            double baseRate,
            double insuranceFee,
            LocalDate startDate,
            LocalDate endDate,
            String pickupLocation,
            RentalType rentalType
    ) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.baseRate = baseRate;
        this.insuranceFee = insuranceFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
        this.rentalType = rentalType;

        // defaults coerentes com o schema
        this.rentalStatus = RentalStatus.ACTIVE;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    /* Construtor completo (leitura do banco) */
    public Rental(
            Long id,
            Client customer,
            Vehicle vehicle,
            VehicleType vehicleType,
            double baseRate,
            double insuranceFee,
            LocalDate startDate,
            LocalDate endDate,
            String pickupLocation,
            RentalStatus rentalStatus,
            PaymentStatus paymentStatus,
            RentalType rentalType
    ) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.baseRate = baseRate;
        this.insuranceFee = insuranceFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
        this.rentalStatus = rentalStatus;
        this.paymentStatus = paymentStatus;
        this.rentalType = rentalType;
    }

    /* Getters */

    public Long getId() { return id; }
    public Client getCustomer() { return customer; }
    public Vehicle getVehicle() { return vehicle; }
    public VehicleType getVehicleType() { return vehicleType; }

    public double getBaseRate() { return baseRate; }
    public double getInsuranceFee() { return insuranceFee; }

    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public String getPickupLocation() { return pickupLocation; }

    public RentalStatus getRentalStatus() { return rentalStatus; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }

    public RentalType getRentalType() { return rentalType; }

    /* Regra de negócio permanece intacta */
    public double calculateTotal() {
    long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;

    double dailyValue = baseRate * days;
    double insuranceTotal = insuranceFee * days;
    double additionalFees = vehicleType.calculateAdditionalFees((int) days);

    return dailyValue + insuranceTotal + additionalFees;
}

}
