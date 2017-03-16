package com.emc.ps.appmod;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class CitrusTestSuit {
	
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { BookIT.class });
		testng.addListener(tla);
		testng.run();
		//testng.
		
	}

}
