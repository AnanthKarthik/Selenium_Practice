package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	By username=By.id("UserName");
	By password=By.id("UserPassword");
	//By login=By.linkText("Login");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
	
	
	@FindBy(linkText="Login")
	WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
}
