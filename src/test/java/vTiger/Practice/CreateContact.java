package vTiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {
	
	public static void main(String[] args) {
		
		//Step 1: launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 2: load the aplication
		driver.get("http://localhost:8888");
		
		//Step 3: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: create contact with mandatory fields
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Chaitra");
		
		//step 6: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
	}

}
