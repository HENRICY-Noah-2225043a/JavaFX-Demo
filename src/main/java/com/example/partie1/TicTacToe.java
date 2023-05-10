package com.example.partie1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {
    private final Image rond_img = new Image(TicTacToe.class.getResource("Rond.png").toString());
    private final Image croix_img = new Image(TicTacToe.class.getResource("Croix.png").toString());
    private final Image vide_img = new Image(TicTacToe.class.getResource("Vide.png").toString());

    private final Random random = new Random();

    private final ImageView[][] imageViewArray = new ImageView[3][3];
    private final Label[] labelArray = new Label[9];

    @Override
    public void start(Stage primaryStage) {
        GridPane grille = new GridPane();

        for (int i = 0; i < 9; ++i) {
            Label label = new Label(" ");
            labelArray[i] = label;
            grille.add(label, i % 3, i / 3);

            ImageView vide = new ImageView(vide_img);
            imageViewArray[i / 3][i % 3] = vide;
            grille.add(vide, i % 3, i / 3);
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int nombre = random.nextInt(3);

                if (nombre == 1) {
                    imageViewArray[i][j].setImage(rond_img);
                    labelArray[i * 3 + j].setGraphic(new ImageView(rond_img));
                } else if (nombre == 2) {
                    imageViewArray[i][j].setImage(croix_img);
                    labelArray[i * 3 + j].setGraphic(new ImageView(croix_img));
                }
            }
        }

        grille.setGridLinesVisible(true);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(grille));
        primaryStage.show();
    }
}
