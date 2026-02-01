package br.edu.ifba.inf008.plugins.model;


public class ReportDTO {
    private int rental_id;
    private String customer_name;
    private CustomerType customerType;
    private String vehicle;
    private VehicleType vehicleType;
    private String startDate;
    private double total_amount;
    private RentalStatus rentalStatus;
    private PaymentStatus paymentStatus;

    public ReportDTO(
    int rental_id, 
    String customer_name, 
    CustomerType customerType, 
    String vehicle, 
    VehicleType vehicleType, 
    String startDate, 
    double total_amount, 
    RentalStatus rentalStatus, 
    PaymentStatus paymentStatus) {

    this.rental_id = rental_id;
    this.customer_name = customer_name;
    this.customerType = customerType;
    this.vehicle = vehicle;
    this.vehicleType = vehicleType;
    this.startDate = startDate;
    this.total_amount = total_amount;
    this.rentalStatus = rentalStatus;
    this.paymentStatus = paymentStatus;
}

public int getRental_id() {
    return rental_id;
}

public String getCustomerName() {
    return customer_name;
}

public CustomerType getCustomerType() {
    return customerType;
}

public String getVehicle() {
    return vehicle;
}

public VehicleType getVehicleType() {
    return vehicleType;
}

public String getStartDate() {
    return startDate;
}

public double getTotal_amount() {
    return total_amount;
}

public RentalStatus getRentalStatus() {
    return rentalStatus;
}

public PaymentStatus getPaymentStatus() {
    return paymentStatus;
}

}

