package br.edu.ifba.inf008.plugins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifba.inf008.plugins.model.Rental;

public class RentalDAO {

    private final Connection connection;

    public RentalDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Rental rental) {

    String sql =
    "INSERT INTO rentals (" +
    "customer_id, vehicle_id, rental_type, start_date, scheduled_end_date, " +
    "pickup_location, initial_mileage, base_rate, insurance_fee, total_amount, " +
    "rental_status, payment_status" +
    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

    stmt.setInt(1, rental.getCustomer().getId());
    stmt.setInt(2, rental.getVehicle().getId());

    
    stmt.setString(3, rental.getRentalType().name());

    stmt.setTimestamp(4, java.sql.Timestamp.valueOf(
        rental.getStartDate().atStartOfDay()
    ));
    stmt.setTimestamp(5, java.sql.Timestamp.valueOf(
        rental.getEndDate().atStartOfDay()
    ));

    stmt.setString(6, rental.getPickupLocation());

    
    stmt.setDouble(7, rental.getVehicle().getMileage());

    stmt.setDouble(8, rental.getBaseRate());
    stmt.setDouble(9, rental.getInsuranceFee());
    stmt.setDouble(10, rental.calculateTotal());

    stmt.setString(11, rental.getRentalStatus().name());
    stmt.setString(12, rental.getPaymentStatus().name());

    stmt.executeUpdate();
}
 catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Erro ao inserir locação", e);
    }
}

}
