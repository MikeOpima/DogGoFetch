package org.example.doggofetch.tabs.product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;

/**
 * ProductStatsTab
 * @author katkoe
 * @date 04.14.26
 *
 * sort products by category, display in pie chart
 */

public class ProductStatsTab extends Tab {
    private static ProductStatsTab instance;

    private PieChart pieChart;

    private ProductStatsTab()
    {
        this.setText("Product Statistics");
        BorderPane root = new BorderPane();
        pieChart = new PieChart();
        pieChart.setTitle("Product Tracking");
        pieChart.setLabelsVisible(true);
        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> {
            generateChart();
        });
        generateChart();
        root.setCenter(pieChart);
        root.setBottom(refresh);
        this.setContent(root);

    }

    public void generateChart(){
        ProductTable productTable = ProductTable.getInstance();
        CategoryTable categoryTable = CategoryTable.getInstance();

        // Another table mostly category
        ArrayList<Category> categories = categoryTable.getAllCategory();

        ArrayList<PieChart.Data> data = new ArrayList<>();
        for (Category category : categories) {
            double count = productTable.getProductCount(category.getId());

            if (count > 0) {
                data.add(new PieChart.Data(category.getName(), count));
            }
        }
        ObservableList<PieChart.Data> chartData
                = FXCollections.observableArrayList(data);
        pieChart.setData(chartData);
    }

    public static ProductStatsTab getInstance(){
        if (instance == null){
            instance = new ProductStatsTab();
        }
        return instance;
    }
}
