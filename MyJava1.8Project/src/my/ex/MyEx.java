package my.ex;

public class MyEx {

	public static void main(String[] args) {
//		System.out.println("Hello World!");
		MyEx me = new MyEx();
		me.exSelfAdd();
	}

	private void exSelfAdd() {
		int k = 0;
		k = k++ + k++ + k++ + ++k;
		System.out.println("k=" + k);
	}
}
