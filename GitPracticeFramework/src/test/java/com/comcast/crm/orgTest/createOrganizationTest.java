package com.comcast.crm.orgTest;

import org.testng.annotations.Test;

public class createOrganizationTest {
	
      @Test
	public void createOrganizationMainTest()  {	
		System.out.println("create orgnization");
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
      }	
}
