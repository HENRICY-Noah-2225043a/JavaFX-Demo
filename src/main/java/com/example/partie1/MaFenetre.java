package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MaFenetre extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Création du conteneur principal
        VBox vbox = new VBox();


        // Création du conteneur correspondant à la ligne de contrôle haut dessus du tableau
        HBox topControls = new HBox();
        topControls.setAlignment(Pos.TOP_LEFT);
        topControls.setPrefWidth(Double.MAX_VALUE);
        // Creation du Menu
        MenuItem new_item, open, save, close;
        new_item = new MenuItem("New");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        close = new MenuItem("Close");

        Menu file = new Menu("File");
        file.getItems().addAll(new_item, open, save, close);

        MenuItem cut, copy, paste;
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");

        Menu edit = new Menu("Edit");
        edit.getItems().addAll(cut, copy, paste);

        Menu help = new Menu("Help");

        MenuBar menu = new MenuBar(file, edit, help);
        HBox.setHgrow(menu, Priority.ALWAYS);

        topControls.getChildren().addAll(menu);

        // Creation de tout les boutons
        VBox Buttons = new VBox();
        Buttons.setMaxHeight(Double.MAX_VALUE);
        Buttons.setPrefHeight(6000);
        Buttons.setMinWidth(75);
        Buttons.setMinHeight(300);
        Buttons.setAlignment(Pos.CENTER);
        Text Boutons = new Text("Boutons:");
        Button bouton1, bouton2, bouton3;
        bouton1 = new Button("Bouton1");
        bouton2 = new Button("Bouton2");
        bouton3 = new Button("Bouton3");

        // Boutons Submit et Cancel
        Buttons.getChildren().addAll(Boutons, bouton1, bouton2, bouton3);
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        HBox buttonContainer = new HBox(submitButton, cancelButton);
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);

        Buttons.setSpacing(10);
        VBox.setMargin(buttonContainer, new Insets(10, 0, 0, 0));

        //Formulaire du milieu
        VBox form = new VBox();
        form.setAlignment(Pos.CENTER);
        form.setMaxWidth(Double.MAX_VALUE - Buttons.getWidth());
        form.setPrefWidth(6000);
        GridPane formulaire = new GridPane();
        formulaire.setAlignment(Pos.CENTER);


        TextField name, email, passwd;
        name = new TextField();
        email = new TextField();
        passwd = new TextField();

        formulaire.add(new Label("Name :"), 0, 0);
        formulaire.add(name, 1, 0);
        formulaire.add(new Label("Email :"), 0, 1);
        formulaire.add(email, 1, 1);
        formulaire.add(new Label("Password :"), 0, 2);
        formulaire.add(passwd, 1, 2);
        formulaire.setVgap(10);
        formulaire.setHgap(10);
        form.getChildren().addAll(formulaire, buttonContainer);

        // HBox du centre de la fenêtre
        HBox centre = new HBox();
        centre.setMinHeight(300);
        centre.setMinWidth(300);
        centre.getChildren().addAll(Buttons, new Separator(Orientation.VERTICAL) ,form);


        //Bas de la page
        Separator bottomSeparator = new Separator(Orientation.HORIZONTAL);
        Label bottomLabel = new Label("Ceci est un label de bas de page");
        VBox bottomContainer = new VBox(bottomSeparator, bottomLabel);

        VBox.setVgrow(bottomContainer, Priority.ALWAYS);
        bottomContainer.setAlignment(Pos.BOTTOM_CENTER);

        // Ajout des contrôleurs au conteneur principal
        vbox.getChildren().addAll(topControls, centre, bottomContainer);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);


        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        primaryStage.setMinWidth(Buttons.getMinWidth() + centre.getMinWidth());
        primaryStage.setMinHeight(centre.getMinHeight()+ topControls.getMinHeight()+ 100);
        primaryStage.setTitle("Premier exemple en manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
