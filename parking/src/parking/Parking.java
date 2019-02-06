package parking;

import java.util.Random;

//la clase datos contiene los metodos sincronizafos y el juego con el boolean
class Parking {
	
  int n;
  int coches;
  int[] plazas;
  int cochesDentro;
  int plazasDisponibles;

  
  
  


  public Parking(int coches, int plazasDisponibles) {
	super();
	this.coches = coches;
	this.plazasDisponibles = plazasDisponibles;
	plazas = new  int[plazasDisponibles];
  }


synchronized void entrar(int n) {
	  
	  if(plazasDisponibles==0) {
		
		  try {
			     wait();
			    
		 } catch(InterruptedException e) {
		   System.out.println("InterruptedException capturada");
		 }  
	  }
	  
		  plazasDisponibles--;

			  for(int i=0;i<plazas.length;i++) {
				  if(plazas[i]==0) {
					  plazas[i]=n;
					  System.out.println("Entrada: Coche "+n+" aparca en "+(i+1));
					  System.out.println("Plazas libres: "+plazasDisponibles+""); 
					  break;
				  }
			  }
		  
		  imprimir();  
  }


  
  
  synchronized void salir(int n) {
	  
	  notify();
	  
	  plazasDisponibles++;
	  
		  for(int i=0;i<plazas.length;i++) {
			  if(plazas[i]==n) {
				  plazas[i]=0;		  
				  System.out.println("Salida: Coche "+n+" saliendo");
				  System.out.println("Plazas libres: "+plazasDisponibles+"");
				  break;
			  }
		  }
	  
	  imprimir();  
  }
  
  
  
  public void imprimir() {  
	  
		for (int i=0; i<plazas.length; i++) {	
			System.out.print("-"+plazas[i]+"-");
		}
		System.out.println("");
		System.out.println("");	
  }
  
  
}









class Coches implements Runnable {
  
	int numCoche=0;
	Parking q;
  
  
	  public Coches(Parking q) {
			super();
			this.q = q;
			new Thread(this, "suma").start();
		
		}
	  
	  
  public void run() {
  
	  
	  try { 
	  
	  Random r = new Random();
	  int espera = r.nextInt(10000)+1000;
	 
	  
	Thread.sleep(espera);
	
	 q.cochesDentro++;
	 int coche = q.cochesDentro;
	 q.entrar(coche);
	 
	 
	 Random r2 = new Random();
	 int espera2 = r2.nextInt(10000)+1000;
	 
		
	 Thread.sleep(espera2);
		
	 q.salir(coche);
	 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
  }
}





