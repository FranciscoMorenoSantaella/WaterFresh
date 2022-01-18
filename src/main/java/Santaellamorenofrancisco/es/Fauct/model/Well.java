package Santaellamorenofrancisco.es.Fauct.model;
/*
 * Esta es la clase que comparten el productor y el consumidor. En esta clase el productor
 * produce agua y se guarda en un entero y se llenan botellas que sacan agua.
 */
public class Well {
	public int water;
	

	public Well(int water) {
		super();
		this.water = water;
	}
	
	
	/**
	 * 
	 * @param numBotella es el id de la botella que se va a llenar de agua
	 * @param aguaBotella es la cantidad de agua que cabe en la botella.
	 * 
	 * Este metodo saca agua (numero entero) del pozo (que es el recurso compartido) 
	 */
	
	public synchronized void llenarBotella(int numBotella,int aguaBotella) {
		try {
			while(water<aguaBotella) {
				System.out.println("No hay agua suficiente para llenar la botella");
				wait();
			}
			for(int i = 0; aguaBotella>0;i++) {
				wait(1000);
				water--;
				System.out.println(water);
				setWater(water);  
				aguaBotella--;
				System.out.println("Botella " +numBotella+ " a la botella le faltan: "+aguaBotella+" para llenarse");
			
			}
			
		} catch (Exception e) {
			System.out.println("Error al llenar agua");
		}
	}
	
	/**
	 * 
	 * @param waterp es la cantidad de agua (numero entero) que produce la fabrica
	 * Este metodo es usado por la fabrica para producir agua (numero entero)
	 */
	public synchronized void producirAgua(int waterp) {
		
		setWater(water+waterp);
		System.out.println("La fabrica ha depositado: "+waterp+" y el pozo ahora tiene: "+getWater());
		notifyAll(); //Aviso a los hilos de que ya acabe la operación
		
	}
	
	
	public Well() {
		super();
		this.water = 0;
	}


	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	@Override
	public String toString() {
		return "Well [water=" + water + "]";
	}

}
