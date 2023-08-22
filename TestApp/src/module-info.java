module HydroApp {
    requires javafx.controls;
	requires transitive javafx.graphics;
    requires transitive javafx.base;
	requires javafx.fxml;

    // Exporte le package nothingSpecial pour que le module javafx.graphics puisse y accéder
    exports nothingSpecial to javafx.graphics;
}