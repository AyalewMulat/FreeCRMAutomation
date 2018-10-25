package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Testutil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		try {
			
			prop=new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\ayalt\\eclipse-workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		   } 
		catch(FileNotFoundException e) {
			
	e.printStackTrace();
		
	}catch(IOException e) {
		e.printStackTrace();
	}

}
	
	
	public static void initialization() {
		
		String browserName= prop.getProperty("browser");
		if( browserName.equals("FF")) {
			
			 System.setProperty("webdriver.gecko.driver", "C:\\Selinium\\geckodriver.exe");
			  driver = new FirefoxDriver();
		  }
		else if( browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\selinium\\chromedriver.exe");
			 driver  = new ChromeDriver();
		  }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
}