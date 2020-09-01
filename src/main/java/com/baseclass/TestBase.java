package com.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	public WebDriver driver;
	public Properties pro ;
	public FileInputStream fis;
	
	
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
		
		fis = new FileInputStream("D:\\KalyaniWorkspace\\AutomationTesting\\DdecorProject\\src\\main\\java\\com\\config_file\\config.properties");
		pro = new Properties();
		pro.load(fis);
		
	String browserName = pro.getProperty("Browser");
	
	if(browserName.equals("Chrome")) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\KalyaniWorkspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {

		driver = new FirefoxDriver();
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}


	
	@AfterMethod
	public void tearDwon() {
		
		driver.quit();
	}
	
	
	

}
