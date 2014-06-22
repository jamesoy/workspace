package my.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class MyWorld {

	public static void main(String[] args) {
		House house = new House();
		Vector<Person> man = new Vector<Person>();

		man.addElement(new Person("Zhangsan", house));
		man.addElement(new Person("Lisi", house));
		man.addElement(new Person("Wangwu", house));
		
		System.out.println("man: " + man);
		
		try {
			ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
			ObjectOutputStream o1 = new ObjectOutputStream(buf1);
			o1.writeObject(man);
			o1.writeObject(man);
			
			ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
			ObjectOutputStream o2 = new ObjectOutputStream(buf2);
			o2.writeObject(man);
			
			ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
			ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
			
			Vector<?> man1 = (Vector<?>)in1.readObject();
			Vector<?> man2 = (Vector<?>)in1.readObject();
			Vector<?> man3 = (Vector<?>)in2.readObject();
			
			System.out.println("man1: " + man1);
			System.out.println("man2: " + man2);
			System.out.println("man3: " + man3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
