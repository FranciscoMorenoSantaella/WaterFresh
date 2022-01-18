package Santaellamorenofrancisco.es.Fauct.model;

import Santaellamorenofrancisco.es.Fauct.FabricaController;
import javafx.scene.text.Text;

public class Bottle extends Thread {
	public Well well;
	public int id;
	public int water;

	public Bottle(Well well, int id, int water) {
		super();
		this.well = well;
		this.id = id;
		this.water = water;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public Bottle(Well well, int id) {
		super();
		this.well = well;
		this.id = id;
	}

	public Well getWell() {
		return well;
	}

	public void setWell(Well well) {
		this.well = well;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			well.llenarBotella(id, water);
			System.out.println("La botella " + getId() + "" + " se ha llenado con: " + water+"L");

			System.out.println("El agua del pozo ahora es: " + well.getWater());
	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
