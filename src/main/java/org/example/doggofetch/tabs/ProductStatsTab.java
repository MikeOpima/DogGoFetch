package org.example.doggofetch.tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.tables.ProductTable;

import java.util.ArrayList;

public class ProductStatsTab extends Tab {
    private static ProductStatsTab instance;

    private PieChart pieChart;

    private ProductStatsTab()
    {
        this.setText("Product Statistics");
        BorderPane bp = new BorderPane();
        pieChart = new PieChart();
        pieChart.setTitle("Product Tracking");
        pieChart.setLabelsVisible(true);
        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> {
            generateChart();
        });

    }

    public void generateChart(){
        ProductTable productTable = ProductTable.getInstance();
        // Another table mostly category
        ArrayList<Product> products = productTable.getAllProducts();

        ArrayList<PieChart.Data> pieChartData = new ArrayList<>();
        for (Product product : products) {
            double count = productTable.getProductCount(product.getId());

            if (count > 0) {
                pieChartData.add(new PieChart.Data(product.getName(), count));
            }
        }
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(pieChartData);
        pieChart.setData(chartData);
    }

    public static ProductStatsTab getInstance(){
        if (instance == null){
            instance = new ProductStatsTab();
        }
        return instance;
    }
}
