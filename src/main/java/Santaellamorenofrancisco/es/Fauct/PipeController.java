package Santaellamorenofrancisco.es.Fauct;

import java.io.IOException;
import java.time.Duration;
import java.util.Observable;

import Santaellamorenofrancisco.es.Fauct.model.Pipe;
import Santaellamorenofrancisco.es.Fauct.model.Well;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PipeController {
	@FXML
	private Text t1;

	@FXML
	private Text t2;

	@FXML
	private Text t3;

	@FXML
	private Text t4;

	@FXML
	private Text t5;

	@FXML
	private Button vaciar;

	@FXML
	private Button rellenar;
	
	@FXML
	private Button volver;


	// Esta variable es con la que cooperan los hilos
	public static int cantidad = (int) (Math.random() * 100 + 1);

	@FXML
	void initialize() {
		//Iniciamos la cantidad con un numero aleatorio entre 8 y 100
	
		t4.setText(cantidad + "");
		if (cantidad > 1) {
			rellenar.setDisable(true);
		}
	}

	// Este metodo reinicia los campos de texto y genera un numero aleatorio para la
	// variable cantidad
	public void resetearCantidad() {
		cantidad = (int) (Math.random() * 100 + 1);
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t5.setText("");
		t4.setText(cantidad + "");
		
		vaciar.setDisable(false);
		rellenar.setDisable(true);
	}

	@FXML
	void openWithAction(ActionEvent event) {
		boolean flag = false;

		// Task nos permite que sean observables los cambios.
		Task task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {

				vaciar.setDisable(true);
				volver.setDisable(true);

				// Creamos los hilos
				Pipe p1 = new Pipe(1, cantidad / 4, t1);

				Pipe p2 = new Pipe(2, cantidad / 4, t2);

				Pipe p3 = new Pipe(3, cantidad / 4, t3);

				Pipe p4 = new Pipe(4, cantidad / 4, t5);

				p1.start();
				p1.join();
				p2.start();
				p2.join();
				p3.start();
				p3.join();
				p4.start();
				p4.join();
				rellenar.setDisable(false);

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
