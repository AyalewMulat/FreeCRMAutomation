package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase {

	
			
		
		//Page Factory - Object Repository
		
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement Login;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up']")
		WebElement signup;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		WebElement crmlogo;
		
		//initialization of Page Objects
		public Loginpage() throws IOException {
			super();
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
		
		//Actions
		
		public String ValidateLoginpageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateCrmImage() {
			return crmlogo.isDisplayed();
			
		}
		
		public HomePage login(String un, String pw) throws IOException, InterruptedException {
			username.sendKeys(un);
			password.sendKeys(pw);
			
			Thread.sleep(3000);
			Login.click();
			
			return new HomePage();
			
			}
	}


