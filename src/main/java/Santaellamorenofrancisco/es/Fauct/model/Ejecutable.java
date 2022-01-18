package Santaellamorenofrancisco.es.Fauct.model;

public class Ejecutable {
	public static void main(String[] args) {
		Well w1 = new Well(0);
		Factory f1 = new Factory(w1);
		Bottle b1 = new Bottle(w1, 1, 10);
		b1.start();
		f1.start();
	}

}
