
public class ThreadsTablasMultiplicar extends Thread {

	
	private int num;

	public ThreadsTablasMultiplicar(int num) {
		super();
		this.num = num;
	}
	
	public void run () {
		
		System.out.println("Tabla multiplicar del "+num);
		System.out.println("---------------------------");
		
		for(int i=1;i<=10;i++) {
			System.out.println(num + " * " + i + " = "+ num*i);
		}
		
	}
	
	
}
