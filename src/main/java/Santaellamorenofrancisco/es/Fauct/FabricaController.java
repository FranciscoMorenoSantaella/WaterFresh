package Santaellamorenofrancisco.es.Fauct;

import java.io.IOException;

import Santaellamorenofrancisco.es.Fauct.model.Bottle;
import Santaellamorenofrancisco.es.Fauct.model.Factory;
import Santaellamorenofrancisco.es.Fauct.model.Pipe;
import Santaellamorenofrancisco.es.Fauct.model.Well;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FabricaController {
	
	@FXML 
	Button b1;
	
	@FXML
	static Text pozo;
	
	@FXML
	static Text  bottle;
	
	@FXML
	static Text factory;

	@FXML
	void openWithAction(ActionEvent event) {
		

		// Task nos permite que sean observables los cambios.
		Task task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {

				Well w1 = new Well(0);
				Factory f1 = new Factory(w1);
				Bottle b1 = new Bottle(w1, 1, 10);
				b1.start();
				f1.start();
				return null;
			}

		};

		// Al pulsar el boton se inicia la task que hace que los campos de texto sean
		// observables
		new Thread(task).start();
	}

	@FXML
	private void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
}