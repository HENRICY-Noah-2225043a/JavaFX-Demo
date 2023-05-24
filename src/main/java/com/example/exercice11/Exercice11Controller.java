package com.example.exercice11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

import java.util.Optional;

public class Exercice11Controller {

    @FXML
    private BorderPane chartContainer;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextField dateField;

    @FXML
    private TextField populationField;

    @FXML
    private ComboBox<String> chartTypeSelector;


    private ObservableList<XYChart.Data<String, Number>> data;



    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        XYChart.Series<String, Number> series = new XYChart.Series<>(data);
        series.setName("Evolution de la population");
        barChart.getData().add(series);



        chartTypeSelector.getItems().addAll("Bar Chart", "Line Chart");
        chartTypeSelector.setValue("Bar Chart");
    }


    @FXML
    private void addButtonClicked() {
        String date = dateField.getText().trim();
        String population = populationField.getText().trim();

        if (date.isEmpty() || population.isEmpty()) {
            showAlertDialog("Veuillez remplir tous les champs.");
            return;
        }

        try {
            double dateValue = Double.parseDouble(date);
            double populationValue = Double.parseDouble(population);

            boolean dateExists = false;
            for (XYChart.Data<String, Number> d : data) {
                double existingDate = Double.parseDouble(d.getXValue());
                if (dateValue < existingDate) {
                    showAlertDialog("La date entrée est inférieure à une date déjà présente.");
                    return;
                } else if (dateValue == existingDate) {
                    d.setYValue(populationValue);
                    dateExists = true;
                    break;
                }
            }
            if (!dateExists) {
                data.add(new XYChart.Data<>(String.valueOf(dateValue), populationValue));
            }

        } catch (NumberFormatException ex) {
            showAlertDialog("La date et la population doivent être des nombres.");
        }

        dateField.clear();
        populationField.clear();
    }




    @FXML
    private void chartTypeSelected() {
        String chartType = chartTypeSelector.getValue();

        if (!data.isEmpty()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Changement de type de graphique");
            alert.setHeaderText("Les données existantes seront perdues. Voulez-vous continuer ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                data.clear();
            } else {
                return;
            }
        }

        XYChart<String, Number> newChart;
        if (chartType.equals("Bar Chart")) {
            newChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        } else if (chartType.equals("Line Chart")) {
            newChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        } else {
            return; // Type de graphique non pris en charge, sortie de la méthode
        }

        newChart.getData().add(new XYChart.Series<>(data));
        chartContainer.setCenter(newChart);
    }


    private void showAlertDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
