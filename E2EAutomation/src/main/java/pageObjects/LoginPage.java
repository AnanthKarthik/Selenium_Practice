package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username=By.id("UserName");
	By password=By.id("UserPassword");
	By login=By.linkText("Login");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void headerFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("header");
	}

	public WebElement getUserName() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
}
