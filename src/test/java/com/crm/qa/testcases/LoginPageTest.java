package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase{
	Loginpage loginPage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		
		super();
	}

	
	
	/*url=https://www.freecrm.com/
		username=naveenk
		password=test@123

		browser=chrome*/
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		loginPage=new Loginpage();
		
	}
		@Test(priority=1)
		
		public void validateLoginPagetitleTest() {
			String title = loginPage.ValidateLoginpageTitle();
			Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
						
		}
		
		
		@Test(priority=2)
		public void crmLogoImageTest() {
			boolean flag =loginPage.validateCrmImage();
			Assert.assertTrue(flag);
			
		}
		
		@Test(priority=3)
		public void LoginTest() throws IOException, InterruptedException {
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
		}
	
	

	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
}
