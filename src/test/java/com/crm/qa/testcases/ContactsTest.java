package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class ContactsTest extends TestBase{
	
	
	public ContactsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	Loginpage loginPage;
	HomePage homepage;
	Testutil testutil;
	ContactsPage contactsPage;
	String SheetName="Contacts";
	
		
	@BeforeMethod
	public void setup() throws IOException, InterruptedException  {
		
		initialization();
		loginPage=new Loginpage();
		testutil=new Testutil();
		contactsPage=new ContactsPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
		testutil.switchToFrame();
		contactsPage=homepage.ClickContacts();
		
		}
	
@Test(priority=1)

public void verifyContactslbl() {
	Assert.assertTrue(contactsPage.verifyContactsLabel());
}
	

@Test(priority=2)
	public void verifyTitleTest() throws IOException {
		
				
		contactsPage.ThickCheckboxByName("Alvin Lotus");
		
			
	}

@Test(priority=3)
public void clickNewcontact() {
	
	homepage.ClickNewContact();
}

@DataProvider
public Object[][] getCRMTestData() throws EncryptedDocumentException, InvalidFormatException{
	Object data[][] = Testutil.getTestData(SheetName);
	return data;
	
}
@Test(priority=4, dataProvider="getCRMTestData")

public void CreateNewContact(String title, String firstName,String lastName,String company) {
	
	homepage.ClickNewContact();
	
	//contactsPage.createNewcontact("Mr.", "Tom", "Peter", "Google");
	contactsPage.createNewcontact(title, firstName, lastName, company);
	
   }
	
	@AfterMethod
	
	public void teardown() {
		
		//driver.quit();
	}
		
	
	
 }



