package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass{
    
	@Test(groups = "regressionSuite")
	public void createContactWithOrgTest() throws IOException
	{

		// Step 2: read all the required data
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
		//Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationsLnk();
		Reporter.log("Organizations link clicked",true);
		
		//Step 6: Navigate to create Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Create Organization look up image is clicked", true);
		
		//Step 7: Create new organization and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
		
		
		//Step 8: Validate for Organization
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME), "Organization created");
		Reporter.log("Organization created successfully", true);
		
		//Step 9: Navigate to contacts link
		hp.clickContactsLnk();
		Reporter.log("Contacts link clicked", true);
		Assert.fail();
		

		// Step 10: Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Create contact look up image is clicked", true);

		// Step 11: create contact with mandatory details
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		
        //Step 12: Validate for Contact
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader(); //bug
		Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
		Reporter.log("Contact created", true);
		
	}

}
