package com.example.partie2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CouleurFond extends Application {

    private int compteurVert = 0;
    private int compteurRouge = 0;
    private int compteurBleu = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane racine = new BorderPane();


        Label label = new Label("Compteur de couleur");
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPrefWidth(50000);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: rgba(211, 211, 211, 0.5); -fx-padding: 10;"); // Couleur grisée du label

        HBox labelBox = new HBox(label);
        labelBox.setAlignment(Pos.CENTER);
        racine.setTop(labelBox);


        Pane pane = new Pane();
        racine.setCenter(pane);


        Button btnVert = new Button("Vert");
        btnVert.setOnAction(event -> {
            compteurVert++;
            pane.setStyle("-fx-background-color: green");
            label.setText("Vert choisi " + compteurVert + " fois");
        });

        Button btnRouge = new Button("Rouge");
        btnRouge.setOnAction(event -> {
            compteurRouge++;
            pane.setStyle("-fx-background-color: red");
            label.setText("Rouge choisi " + compteurRouge + " fois");
        });

        Button btnBleu = new Button("Bleu");
        btnBleu.setOnAction(event -> {
            compteurBleu++;
            pane.setStyle("-fx-background-color: blue");
            label.setText("Bleu choisi " + compteurBleu + " fois");
        });

        HBox hbox = new HBox(btnVert, btnRouge, btnBleu);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        racine.setBottom(hbox);


        Scene scene = new Scene(racine, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
