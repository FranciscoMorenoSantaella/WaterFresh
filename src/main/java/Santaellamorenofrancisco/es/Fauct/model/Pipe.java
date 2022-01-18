package Santaellamorenofrancisco.es.Fauct.model;

import Santaellamorenofrancisco.es.Fauct.PipeController;
import javafx.scene.text.Text;

/*
 * Esta es una clase que al ejecutarla el metodo run hará que con una cantidad se repartan entre 4 una cantidad que tendran que restar
 * a partes iguales, a no ser que sea impar que en tal caso será la ultima tubería la que reste uno mas que las demás para solucionar
 * el problema de que sean impares
 */
public class Pipe extends Thread {
	protected int pipenumber;
	protected int water;
	protected Text t;

	public Text getT() {
		return t;
	}

	public void setT(Text t) {
		this.t = t;
	}

	public Pipe(Well well, int pipenumber, int water, Text t) {
		super();
		this.pipenumber = pipenumber;
		this.water = water;
		this.t = t;
	}

	public Pipe(int pipenumber, int water, Text t) {
		super();
		this.pipenumber = pipenumber;
		this.water = water;
		this.t = t;
	}

	public Pipe(int pipenumber, int water) {
		super();
		this.pipenumber = pipenumber;
		this.water = water;

	}

	public Pipe(int water) {
		super();
		this.water = water;
	}

	public Pipe() {
		super();
	}

	public int getPipenumber() {
		return pipenumber;
	}

	public void setPipenumber(int pipenumber) {
		this.pipenumber = pipenumber;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	// En el metodo run que se ejecuta al iniciar el hilo tenemos para que vaya
	// sacando el agua de la tubería hasta que se vacie.
	public void run() {
		// Resta una parte de la cantidad total (1/4)
		for (int i = 0; i <= water; i++) {
			t.setText(PipeController.cantidad + "");
			if (PipeController.cantidad > 0) {
				PipeController.cantidad--;
			
				try {
					sleep(300);
				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Soy la tuberia: " + getPipenumber() + " y queda: " + PipeController.cantidad);
			}
			
		}
		
		// Si es impar la ultima tubería resta uno mas que las demas tuberías.
		if (PipeController.cantidad == 1) {
			try {
				t.setText(PipeController.cantidad + "");
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PipeController.cantidad--;
			t.setText(PipeController.cantidad + "");
		}

	}

	@Override
	public String toString() {
		return "Pipe [water=" + water + "]";
	}

}
