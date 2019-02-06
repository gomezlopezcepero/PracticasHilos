package parking;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int coches = 5;
			int plazas = 5;
			
			//recibe el número de plazas y el número de coches existentes en el sistema
			Parking q = new Parking(coches,plazas);
	    
			 Coches[] o = new Coches[coches];	
			for(int i=0;i<coches;i++) {
		   	o[i] = new Coches(q);
			}
		
	}

}
