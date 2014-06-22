package my.test;

public class MyFirstTest {

	public static void main(String[] args) {

		int k=0;
		System.out.println(k++ + k++ + k++ + ++k);
		
		byte b=2, e=3;
//		byte f=b+e;				int
		byte f=(byte)(b+e);
		System.out.println(f);
		
		short s=1;
//		s=s+1;					int
		s=(short) (s+1);
		s+=1;
		System.out.println(s);
		
		String str = "888";
		int i = Integer.parseInt(str);
		System.out.println(i);
	}

}
