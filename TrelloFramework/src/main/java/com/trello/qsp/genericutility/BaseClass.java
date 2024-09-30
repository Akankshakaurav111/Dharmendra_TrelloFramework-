package com.trello.qsp.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	public WebdriverUtility webdriverutils = new WebdriverUtility();
	public JavaUtility javautiles = new JavaUtility();
	public FileUtility fileutiles = new FileUtility();
	public ExcelUtility excelutiles = new ExcelUtility();
	
@BeforeMethod
	public void preCondition() throws IOException {
		String browserName = fileutiles.readTheDataFromPropertyFile("browsername");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox"))
			
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webdriverutils.implicitWait(driver);
		driver.get(fileutiles.readTheDataFromPropertyFile("url"));
	}
@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
public void takesScreenShots(String failedMethod) throws IOException
{
	  String timeStamp = LocalDateTime.now().toString().replace(':', '-');

       TakesScreenshot ts=(TakesScreenshot)driver;
       File tempFile = ts.getScreenshotAs(OutputType.FILE);
       File permFile = new File("./src/test/resource/defectshot/"+timeStamp+"defect.png");
       FileUtils.copyFile(tempFile, permFile);
}
}
