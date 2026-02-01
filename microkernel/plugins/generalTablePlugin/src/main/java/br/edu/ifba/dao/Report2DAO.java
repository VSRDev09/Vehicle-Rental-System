package br.edu.ifba.dao;

import br.edu.ifba.inf008.plugins.model.ReportDTO;
import br.edu.ifba.inf008.plugins.model.CustomerType;
import br.edu.ifba.inf008.plugins.model.VehicleType;
import br.edu.ifba.inf008.plugins.model.RentalStatus;
import br.edu.ifba.inf008.plugins.model.PaymentStatus;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Report2DAO {

    private final Connection connection;

    public Report2DAO(Connection connection) {
        this.connection = connection;
    }

    public List<ReportDTO> findAll() {

        List<ReportDTO> list = new ArrayList<>();

        try (InputStream is = getClass().getResourceAsStream("/sql/report2.sql")) {

            if (is == null) {
                throw new RuntimeException("Arquivo report2.sql não encontrado");
            }

            String sql = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    ReportDTO dto = new ReportDTO(
                        rs.getInt("rental_id"),
                        rs.getString("customer_name"),
                        CustomerType.valueOf(rs.getString("customer_type").trim().toUpperCase()),
                        rs.getString("vehicle"),
                        VehicleType.valueOf(rs.getString("vehicle_type").trim().toUpperCase()),
                        rs.getString("start_date"),
                        rs.getDouble("total_amount"),
                        RentalStatus.valueOf(rs.getString("rental_status").trim().toUpperCase()),
                        PaymentStatus.valueOf(rs.getString("payment_status").trim().toUpperCase())
                    );

                    list.add(dto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
