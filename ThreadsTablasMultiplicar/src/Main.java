
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1, num2, num3;
		
		
		System.out.println("Introduce el primer número");
		num1 =Datos.entero();
		
		System.out.println("Introduce el segundo número");
		num2 =Datos.entero();
		
		System.out.println("Introduce el tercer número");
		num3 =Datos.entero();
		
		
		ThreadsTablasMultiplicar t1 = new ThreadsTablasMultiplicar(num1);
		ThreadsTablasMultiplicar t2 = new ThreadsTablasMultiplicar(num2);
		ThreadsTablasMultiplicar t3 = new ThreadsTablasMultiplicar(num3);
		
		try {
		
		t1.start();
		t1.join();
		
		t2.start();
		
		t3.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
