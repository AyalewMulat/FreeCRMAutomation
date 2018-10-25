package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

			
//Page Factory - Object Repository
		@FindBy(xpath="//td[contains(text(),'Contacts')]")
		  WebElement ContactsLabel;
		
		@FindBy(id="first_name")
		  WebElement firstName;
		
		@FindBy (id="surname")
		  WebElement lastName;
		
		@FindBy (name="client_lookup")
		  WebElement company;
		
		@FindBy (xpath="//input[@type='submit' and @value='Save']")
		  WebElement save;
		
		
//initialization of Page Objects
public ContactsPage()throws IOException{
			
	PageFactory.initElements(driver, this);
			
 }
		
//Actions/Methods
public boolean verifyContactsLabel() {
	
	return ContactsLabel.isDisplayed();
}


public void ThickCheckboxByName(String Name) {
	driver.findElement(By .xpath("//a[(text()='"+Name+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();;
  }



public void createNewcontact(String title,String ftName,String ltName,String comp) {
	Select sel=new Select(driver.findElement(By.name("title")));
	sel.selectByVisibleText(title);
	firstName.sendKeys(ftName);
	lastName.sendKeys(ltName);
	company.sendKeys(comp);
	save.click();
	
	
	
}


}