package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer()
	{
		//Assert.fail();
		System.out.println("customer created");// 1 
		
	}
	
	@Test
	public void modifyCustomer()
	{
		
		System.out.println("customer modified"); // 3 
		//Assert.fail(); // will purposefully fail the test script
	}
	
	@Ignore
	@Test
	public void deleteCustomer()
	{
		System.out.println("Customer deleted"); // 2 
	}

}
