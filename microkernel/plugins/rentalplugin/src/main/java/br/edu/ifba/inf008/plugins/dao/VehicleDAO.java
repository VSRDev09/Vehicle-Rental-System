package br.edu.ifba.inf008.plugins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VehicleDAO {

    private Connection connection;

    public VehicleDAO(Connection connection) {
        this.connection = connection;
    }

    public void updateStatus(int vehicleId, String status) {
    String sql = "UPDATE vehicles SET status = ? WHERE vehicle_id = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, status);
        stmt.setInt(2, vehicleId);

        int rows = stmt.executeUpdate();
        System.out.println("Linhas atualizadas: " + rows);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
