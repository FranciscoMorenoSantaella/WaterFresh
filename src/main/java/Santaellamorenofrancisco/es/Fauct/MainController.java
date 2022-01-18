package Santaellamorenofrancisco.es.Fauct;

import java.io.IOException;

import Santaellamorenofrancisco.es.Fauct.model.Bottle;
import Santaellamorenofrancisco.es.Fauct.model.Factory;
import Santaellamorenofrancisco.es.Fauct.model.Well;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML
	Button b1;

	@FXML
	Button b2;

	@FXML
	private void switchToTuberias() throws IOException {
		App.setRoot("tuberiasJoin");
	}

	@FXML
	private void ejecutarFabrica() throws IOException {

		Well w1 = new Well(0);
		Factory f1 = new Factory(w1);
		Bottle b1 = new Bottle(w1, 1, 10);
		b1.start();
		f1.start();
	}
}
