package my.ex;

public class Ex03 {

	private volatile int i = 0;
	private static int j = 0;
	private static volatile int k = 0;
	
	public static void main(String[] args) {
		Ex03 e1 = new Ex03();
		Ex03 e2 = new Ex03();
		
		e1.i++;
		e1.j++;
		e1.k++;
		
		System.out.println(e2.i);
		System.out.println(e2.j);
		System.out.println(e2.k);
	}

}
