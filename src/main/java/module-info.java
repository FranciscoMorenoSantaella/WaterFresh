module Santaellamorenofrancisco.es.Fauct {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens Santaellamorenofrancisco.es.Fauct to javafx.fxml;
    exports Santaellamorenofrancisco.es.Fauct;
}
