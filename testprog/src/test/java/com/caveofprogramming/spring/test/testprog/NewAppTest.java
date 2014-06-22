package com.caveofprogramming.spring.test.testprog;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewAppTest {
  @Test
  public void testGetString() {
	  App a = new App();
	  Assert.assertNotNull(a.getString());
	  Assert.assertEquals(a.getString(), "This is a String");
  }
  
  @Test(expectedExceptions = ArithmeticException.class)  
 	public void divisionWithException() {  
 	  System.out.println(1/0);
 	}
  
  @Test(timeOut = 1000, enabled=false)  
	public void infinity() {  
		while (true);  
	}
}
