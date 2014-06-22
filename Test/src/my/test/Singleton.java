package my.test;

import java.io.Serializable;

public class Singleton implements Serializable {

	private static final long serialVersionUID = -8656443397817962950L;

	private static Singleton mySingleton = new Singleton();
	
	public static Singleton getInstance() {
		return mySingleton;
	}
	
	private Singleton() {
	}
	
	public String getSample() {
		return "Hello World!";
	}
}
