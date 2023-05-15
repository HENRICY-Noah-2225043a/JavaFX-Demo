package com.example.partie2.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Pendu extends Application {

    private Dico dico;
    private String mot;
    private char[] motCache;
    private int vies;
    private Label labelVies;
    private Label labelMotCache;

    private Button[] boutonsLettres;
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        dico = new Dico();
        vies = 7;
        mot = dico.getMot();
        motCache = new char[mot.length()];
        for (int i = 0; i < mot.length(); i++) {
            motCache[i] = '_';
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1200, 800);
        borderPane.setMinSize(600, 400);
        borderPane.setStyle("-fx-background-color: #AED6F1;");

        labelVies = new Label("Vies : " + vies);
        labelVies.setFont(new Font("Arial", 20));
        labelVies.setTextFill(Color.RED);
        labelVies.setWrapText(true);

        labelMotCache = new Label(new String(motCache));
        labelMotCache.setFont(new Font("Arial", 20));
        labelMotCache.setTextFill(Color.BLUE);
        labelMotCache.setWrapText(true);



        boutonsLettres = new Button[26];
        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            boutonsLettres[index] = new Button(String.valueOf(c));
            boutonsLettres[index].setStyle("-fx-background-color: #D6EAF8; -fx-font-size: 1.5em;");
            char finalC = c;
            boutonsLettres[index].setOnAction(event -> jouer(finalC));
        }

        HBox hBox = new HBox();
        hBox.getChildren().addAll(boutonsLettres);
        hBox.setAlignment(Pos.CENTER);

        imageView = new ImageView();
        imageView.setImage(new Image(Pendu.class.getResource("/com/example/partie2/exercice6/pendu" + vies + ".png").toExternalForm()));
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        VBox vBoxCenter = new VBox();
        vBoxCenter.getChildren().addAll(labelVies, labelMotCache, hBox);
        vBoxCenter.setAlignment(Pos.CENTER);

        Button boutonRecommencer = new Button("Recommencer");
        boutonRecommencer.setStyle("-fx-background-color: #D6EAF8; -fx-font-size: 1.5em;");
        boutonRecommencer.setOnAction(event -> recommencer());
        borderPane.setTop(imageView);
        borderPane.setCenter(vBoxCenter);
        borderPane.setBottom(boutonRecommencer);

        BorderPane.setAlignment(imageView, Pos.TOP_CENTER);
        BorderPane.setAlignment(boutonRecommencer, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Jeu du Pendu");
        primaryStage.show();
    }

    private void jouer(char c) {
        if (mot.contains(String.valueOf(c))) {
            for (int position : dico.getPositions(c, mot)) {
                motCache[position] = c;
            }
        } else {
            vies--;
            imageView.setImage(new Image(Pendu.class.getResource("/com/example/partie2/exercice6/pendu" + vies + ".png").toExternalForm()));
        }
        labelVies.setText("Vies : " + vies);
        labelMotCache.setText(new String(motCache));
        if (vies == 0 || new String(motCache).equals(mot)) {
            for (Button bouton : boutonsLettres) {
                bouton.setDisable(true);
            }
            if (new String(motCache).equals(mot)) {
                imageView.setImage(new Image(Pendu.class.getResource("/com/example/partie2/exercice6/penduWin.png").toExternalForm()));
            }
        }
    }

    private void recommencer() {
        vies = 7;
        mot = dico.getMot();
        motCache = new char[mot.length()];
        for (int i = 0; i < mot.length(); i++) {
            motCache[i] = '_';
        }
        labelVies.setText("Vies : " + vies);
        labelMotCache.setText(new String(motCache));
        for (Button bouton : boutonsLettres) {
            bouton.setDisable(false);
        }
        imageView.setImage(new Image(Pendu.class.getResource("/com/example/partie2/exercice6/pendu" + vies + ".png").toExternalForm()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


