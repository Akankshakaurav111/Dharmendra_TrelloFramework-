package optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Optional 
{
public WebDriver driver;
@Parameters({"browsername","url","username","password"})
@Test
public void readDataFromXml(@org.testng.annotations.Optional("chrome") String browsername,String url,String username,String password)
{
	if(browsername.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browsername.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("pass")).sendKeys(password);
}
}
