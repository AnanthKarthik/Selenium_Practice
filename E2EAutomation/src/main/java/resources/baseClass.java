package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class baseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver IntializeDriver() throws IOException {
		
				
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Selenium\\workspace\\E2EAutomation\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.sargurunathan\\Desktop\\selenium-java-3.141.59\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		else if(browser.equals("IE")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.sargurunathan\\Desktop\\selenium-java-3.141.59\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browser.equals("Firefox")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.sargurunathan\\Desktop\\selenium-java-3.141.59\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenshot(WebDriver driver,String MethodName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\report\\"+MethodName+".PNG";
		try {
			FileUtils.copyFile(Source,new File(destFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile;
	}
	
}
