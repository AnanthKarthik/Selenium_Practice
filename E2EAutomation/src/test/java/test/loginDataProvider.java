package test;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.baseClass;

public class loginDataProvider extends baseClass {

	@Test(dataProvider="getData")
	public void launcURL(String userName,String password) throws IOException {
		
		
		driver=IntializeDriver();
		
		String url=prop.getProperty("url");
		driver.get(url);
		
		LoginPage l=new LoginPage(driver);
		l.headerFrame();
		l.getUserName().sendKeys(userName);
		l.getPassword().sendKeys(password);
		l.getLogin().click();
		}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[2][2];
		data[0][0]="epyx-ps";
		data[0][1]="qa123";
				
		data[1][0]="SI53PF9";
		data[1][1]="scret1";
		
		return data;
		
	}
}
