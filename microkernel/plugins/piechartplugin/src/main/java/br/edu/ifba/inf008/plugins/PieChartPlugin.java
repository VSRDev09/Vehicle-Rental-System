package br.edu.ifba.inf008.plugins;

import br.edu.ifba.inf008.interfaces.IPlugin;
import br.edu.ifba.inf008.interfaces.ICore;
import br.edu.ifba.inf008.interfaces.IUIController;

import br.edu.ifba.inf008.plugins.dao.Report1DAO;
import br.edu.ifba.inf008.plugins.dao.Report1DAO.FuelReport;

import javafx.application.Platform;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class PieChartPlugin implements IPlugin {

    @Override
    public boolean init() {

        IUIController uiController = ICore.getInstance().getUIController();
        System.out.println("Inicializando o PieChartPlugin...");

        
        MenuItem menuItem = uiController.createMenuItem(
            "Relatório 1",
            "Gráfico de Pizza"
        );

        menuItem.setOnAction(e -> {

           
            Report1DAO dao = new Report1DAO();
            List<FuelReport> dados = dao.getReportData();

           
            PieChart pieChart = new PieChart();
            pieChart.setTitle("Distribuição dos veículos por tipo de Combustível");
            pieChart.setPrefSize(500, 400);
            pieChart.setLegendVisible(false); 
            pieChart.setLabelsVisible(true);
            pieChart.setStartAngle(90);

            
            for (FuelReport fr : dados) {
                PieChart.Data slice = new PieChart.Data(fr.fuelType, fr.vehicleCount);
                pieChart.getData().add(slice);
            }

           
            Platform.runLater(() -> {
                for (int i = 0; i < dados.size(); i++) {
                    PieChart.Data slice = pieChart.getData().get(i);
                    String color = dados.get(i).chartColor;
                    slice.getNode().setStyle("-fx-pie-color: " + color + ";");
                }
            });

           
            Label titulo = new Label("Gráfico de Pizza por tipo de Combustível");
            titulo.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
            );

            
            HBox legenda = new HBox(10); 
            for (FuelReport fr : dados) {
                Rectangle rect = new Rectangle(15, 15, Color.web(fr.chartColor));
                Label lbl = new Label(fr.fuelType);
                HBox item = new HBox(5, rect, lbl); 
                legenda.getChildren().add(item);
            }

           
            VBox layout = new VBox(10, titulo, pieChart, legenda);
            layout.setStyle("-fx-padding: 10;");

        
            uiController.createTab("Gráfico do tipo de combustível", layout);
        });

        return true;
    }
}
