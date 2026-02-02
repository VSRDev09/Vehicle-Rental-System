package br.edu.ifba.inf008.plugins;

import br.edu.ifba.inf008.interfaces.IPlugin;
import br.edu.ifba.inf008.interfaces.ICore;
import br.edu.ifba.inf008.interfaces.IUIController;
import br.edu.ifba.inf008.plugins.models.ReportDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import br.edu.ifba.inf008.plugins.models.CustomerType;
import br.edu.ifba.inf008.plugins.models.VehicleType;
import br.edu.ifba.inf008.plugins.models.RentalStatus;
import br.edu.ifba.inf008.plugins.models.PaymentStatus;
import br.edu.ifba.dao.DataBaseConnection;
import br.edu.ifba.dao.Report2DAO;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

import java.util.List;

public class GeneralTablePlugin implements IPlugin {

    @Override
    public boolean init() {

        IUIController uiController = ICore.getInstance().getUIController();
        System.out.println("Inicializando o GeneralTablePlugin...");

        uiController.createMenuItem(
                "Relatório 2",
                "Tabela de Informações Gerais").setOnAction(event -> {

                    VBox vbox = new VBox(10);
                    Label title = new Label("Relatório 2 - Informações Gerais");
                    vbox.getChildren().add(title);

                    TableView<ReportDTO> table = new TableView<>();

                    TableColumn<ReportDTO, Integer> rentalIdCol = new TableColumn<>("Rental id");
                    rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));

                    TableColumn<ReportDTO, String> customerNameCol = new TableColumn<>("Customer Name");

                    
                    customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));

                    
                    customerNameCol.setCellFactory(col -> new TableCell<ReportDTO, String>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText("NULL");
                            } else {
                                setText(item);
                            }
                        }
                    });

                    TableColumn<ReportDTO, CustomerType> customerTypeCol = new TableColumn<>("Customer Type");
                    customerTypeCol.setCellValueFactory(new PropertyValueFactory<>("customerType"));

                    TableColumn<ReportDTO, String> vehicleCol = new TableColumn<>("Vehicle");
                    vehicleCol.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

                    TableColumn<ReportDTO, VehicleType> vehicleTypeCol = new TableColumn<>("Vehicle Type");
                    vehicleTypeCol.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));

                    TableColumn<ReportDTO, String> startDateCol = new TableColumn<>("Start Date");
                    startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

                    TableColumn<ReportDTO, Double> totalAmountCol = new TableColumn<>("Total Amount");
                    totalAmountCol.setCellValueFactory(new PropertyValueFactory<>("total_amount"));

                    TableColumn<ReportDTO, RentalStatus> rentalStatusCol = new TableColumn<>("Rental Status");
                    rentalStatusCol.setCellValueFactory(new PropertyValueFactory<>("rentalStatus"));

                    TableColumn<ReportDTO, PaymentStatus> paymentStatusCol = new TableColumn<>("Payment Status");
                    paymentStatusCol.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

                    table.getColumns().addAll(
                            rentalIdCol,
                            customerNameCol,
                            customerTypeCol,
                            vehicleCol,
                            vehicleTypeCol,
                            startDateCol,
                            totalAmountCol,
                            rentalStatusCol,
                            paymentStatusCol);

                    try {
                        Report2DAO dao = new Report2DAO(DataBaseConnection.getConnection());
                        List<ReportDTO> reportData = dao.findAll();
                        System.out.println("Registros encontrados: " + reportData.size());
                        ObservableList<ReportDTO> data = FXCollections.observableArrayList(reportData);
                        table.setItems(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    vbox.getChildren().add(table);

                    uiController.createTab("Relatório 2", vbox);

                });

        return true;
    }

}