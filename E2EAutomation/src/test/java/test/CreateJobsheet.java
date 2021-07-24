package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.baseClass;

public class CreateJobsheet extends baseClass{
	
	public static Logger log=LogManager.getLogger(CreateJobsheet.class.getName());
	
	@BeforeTest
	public void browserSetup() throws IOException {
		driver=IntializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
	}
	
	@Test
	public void createJobsheet() {
		LoginPage l=new LoginPage(driver);
		l.headerFrame();
		System.out.println(prop.getProperty("username"));
		l.getUserName().sendKeys(prop.getProperty("username"));
		l.getPassword().sendKeys(prop.getProperty("password"));
		l.getLogin().click();
		
		HomePage h=new HomePage(driver);
		log.info("Logged in");
		h.switchVmain();
		//h.createJobsheet().click();
		
	
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
