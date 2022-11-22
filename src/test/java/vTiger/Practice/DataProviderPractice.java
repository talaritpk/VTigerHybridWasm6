package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	
	@Test(dataProvider = "Phones")
	public void addProductToCartTest(String Name, String model, int price, int qty)
	{
		System.out.println("Phone name: "+Name+" Model: "+model+" price: "+price+" qty: "+qty);
	}
	
	@Test(dataProvider = "Mobiles")
	public void addProductToCartTest1(String Name, String model, int price, int qty)
	{
		System.out.println("Phone name: "+Name+" Model: "+model+" price: "+price+" qty: "+qty);
	}
	
	@DataProvider(name = "Phones")
	public Object[][] getData()
	{                             //row //column 
		Object[][] data = new Object[3][4];
		
		data[0][0] = "samsung";
		data[0][1] = "A80";
		data[0][2] = 25000;
		data[0][3] = 0;
		
		data[1][0] = "Samsung";
		data[1][1] = "11Pro";
		data[1][2] = 5000;
		data[1][3] = 5;
		
		data[2][0] = "Vivo";
		data[2][1] = "Y21";
		data[2][2] = 10000;
		data[2][3] = 15;
		
		return data;
				
	}
	
	@DataProvider(name = "Mobiles")
	public Object[][] getData1()
	{                             //row //column 
		Object[][] data = new Object[3][4];
		
		data[0][0] = "samsung";
		data[0][1] = "A80";
		data[0][2] = 25000;
		data[0][3] = 0;
		
		data[1][0] = "Samsung";
		data[1][1] = "11Pro";
		data[1][2] = 5000;
		data[1][3] = 5;
		
		data[2][0] = "Vivo";
		data[2][1] = "Y21";
		data[2][2] = 10000;
		data[2][3] = 15;
		
		return data;
				
	}
	

	
	
}
