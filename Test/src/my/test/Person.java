package my.test;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4640355871209819467L;

	String name;
	
	House preferredHouse;
	
	Person (String nm, House h) {
		name = nm;
		preferredHouse = h;
	}
	
	public String toString() {
		return name + "[" + super.toString() + "], " + preferredHouse + "\n";
	}
}
