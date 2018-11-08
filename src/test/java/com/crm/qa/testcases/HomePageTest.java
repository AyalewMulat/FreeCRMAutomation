package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class HomePageTest extends TestBase{

	public HomePageTest() throws IOException {
		super();
		
	}

  
	Loginpage loginPage;
	HomePage homepage;
	Testutil testutil;
	ContactsPage contactsPage;
	
		
		@BeforeMethod
	public void setup() throws IOException, InterruptedException  {
		
		initialization();
		loginPage=new Loginpage();
		testutil=new Testutil();
		contactsPage=new ContactsPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
		
		}
	

	@Test(priority=1)
	public void verifyTitleTest() {
		String homePageTitle=homepage.ValidatingUserTitle();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Title Not Found");
		
	 }
	
	@Test(priority=2)
	public void ContactsClick() throws IOException, InterruptedException {
		
		testutil.switchToFrame();
		contactsPage=homepage.ClickContacts();
	}
	
	@Test(priority=3)
	
	public void Verifyusertest() throws InterruptedException  {
		
		testutil.switchToFrame();
		
		Thread.sleep(5000);
	Assert.assertTrue(homepage.VerifyCorrectUserName());
	}
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}
		
	
	
 }
