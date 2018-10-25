package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	

	//Page Factory / Object Repository
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement lblDeals;
	
	
	
public DealsPage() throws IOException, InterruptedException{
		
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	
	public boolean verifyDealsLabel() {
		
	return	lblDeals.isDisplayed();
	}
}
