package Santaellamorenofrancisco.es.Fauct.model;

import javafx.scene.text.Text;

public class Factory extends Thread {

	public Well well;
	public final int water = 5;
	public Text t;

	public Factory(Well well) {
		super();
		this.well = well;
	}

	public Well getWell() {
		return well;
	}

	public void setWell(Well well) {
		this.well = well;
	}

	public int getWater() {
		return water;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(4000);
				well.producirAgua(water);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
