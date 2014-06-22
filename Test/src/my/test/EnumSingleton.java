package my.test;

import java.io.Serializable;

public enum EnumSingleton implements Serializable {
	instance;

	public String getSample() {
		return "Hello World!";
	}
}
