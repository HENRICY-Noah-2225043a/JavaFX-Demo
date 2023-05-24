module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.partie2;
    exports com.example.partie1;
    exports com.example.partie2.exercice5;
    exports com.example.partie2.exercice6;

    opens com.example.partie3 to javafx.fxml;
    exports com.example.partie3;

    opens com.example.partie3.exercice7 to javafx.fxml;
    exports com.example.partie3.exercice7;

    opens com.example.partie3.exercice8 to javafx.fxml;
    exports com.example.partie3.exercice8;

    exports com.td2.exercice1;

    opens com.example.exercice11 to javafx.fxml;
    exports com.example.exercice11;
}