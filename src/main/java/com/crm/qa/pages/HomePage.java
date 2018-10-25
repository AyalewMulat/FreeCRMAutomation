package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - Object Repository
	
	
			@FindBy(xpath="//td[contains(text(),'User: Ayalew Mulat')]")  
			
			WebElement userNameLabel;
			
			@FindBy(xpath="//a[contains(text(),'Contacts')]")
			WebElement contactsLabel;
			
			@FindBy(xpath="//a[contains(text(), 'New Contact')]")
			 WebElement NewContactlbl;
			
			@FindBy(xpath="//a[contains(text(),'Deals')]")
			WebElement dealsLabel;
			
			@FindBy(xpath="//a[contains(text(),'Tasks')]")
			WebElement tasksLabel;
			
			//Initializing Page Objects
			public HomePage() throws IOException {
											
				PageFactory.initElements(driver, this);
				
			}
			
			//Actions / Methods
			
			
			public boolean VerifyCorrectUserName() {
				return userNameLabel.isDisplayed();
				
				
			}
			
			
			public String ValidatingUserTitle() {
				return driver.getTitle();
		
			}
			
			public ContactsPage ClickContacts() throws IOException {
				contactsLabel.click();
			 return new ContactsPage();
			}
		
			public DealsPage ClickDeals() throws IOException {
				dealsLabel.click();
			 return new DealsPage();
			}
			
			public TasksPage ClickTasks() throws IOException {
				contactsLabel.click();
			 return new TasksPage();
			}
			public void ClickNewContact() {
				Actions action=new Actions(driver);
				action.moveToElement(contactsLabel).build().perform();
				NewContactlbl.click();
			}
			
		}





