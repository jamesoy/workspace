package my.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonTest {

	public static void main(String[] args) {
		
	}

	private static void testReflection() {
		
	}
	
	private static String toString(Object o) {
		return o.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(o));
	}

	private static void testStream() {
		Singleton mySingleton = Singleton.getInstance();
		EnumSingleton enumSingleton = EnumSingleton.instance;
		
/*		try {
			Singleton mySingleton2 = Singleton.class.newInstance();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		}*/
		
		System.out.println("Singleton: " + mySingleton);
		System.out.println("EnumSingleton: " + toString(enumSingleton));
		System.out.println();
		
		try {
			ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
			ObjectOutputStream o1 = new ObjectOutputStream(buf1);
			o1.writeObject(mySingleton);
			o1.writeObject(mySingleton);
			o1.writeObject(enumSingleton);
			o1.writeObject(enumSingleton);
			
			ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
			ObjectOutputStream o2 = new ObjectOutputStream(buf2);
			o2.writeObject(mySingleton);
			o2.writeObject(enumSingleton);
			
			ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
			ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
			
			Singleton s1 = (Singleton)in1.readObject();
			Singleton s2 = (Singleton)in1.readObject();
			EnumSingleton s3 = (EnumSingleton)in1.readObject();
			EnumSingleton s4 = (EnumSingleton)in1.readObject();

			Singleton s5 = (Singleton)in2.readObject();
			EnumSingleton s6 = (EnumSingleton)in2.readObject();
			
			System.out.println("s1: " + s1);
			System.out.println("s1: " + Integer.toHexString(s1.hashCode()));
			System.out.println("s1: " + Integer.toHexString(System.identityHashCode(s1)));
			System.out.println("s2: " + s2);
			System.out.println("s2: " + Integer.toHexString(s2.hashCode()));
			System.out.println("s1==s2: " + (s1==s2));
			System.out.println(s1.getSample());
			System.out.println();

			System.out.println("s3: " + s3);
			System.out.println("s3: " + Integer.toHexString(s3.hashCode()));
			System.out.println("s3: " + Integer.toHexString(System.identityHashCode(s3)));
			System.out.println("s4: " + s4);
			System.out.println("s4: " + Integer.toHexString(s4.hashCode()));
			System.out.println("s3==s4: " + (s3==s4));
			System.out.println(s3.getSample());
			System.out.println();
			
			System.out.println("s5: " + s5);
			System.out.println("s5: " + Integer.toHexString(s5.hashCode()));
			System.out.println("s1==s5: " + (s1==s5));
			System.out.println();

			System.out.println("s6: " + s6);
			System.out.println("s6: " + Integer.toHexString(s6.hashCode()));
			System.out.println("s3==s6: " + (s3==s6));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
