package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	By createJobsheet=By.xpath("//span[text()='create jobsheet']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement createJobsheet() {
		return driver.findElement(createJobsheet);
	}
	
	public void switchVmain() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("vmain");
	}
	
}
