package com.example.partie3.exercice7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Label counterLabel;

    private int counter = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counterLabel.setText(String.valueOf(counter));
    }

    @FXML
    public void increment() {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    @FXML
    public void decrement() {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }
}
