package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromPropertyFile 
{
	public static WebDriver driver;
public static void main(String[] args) throws IOException 
{
	//ACCESS THE FILE BY GIVING THE PATH/ADDRESS OF THE FILE
	FileInputStream file = new FileInputStream("./src/test/resource/TrelloCommonData.properties");
	
	//CREATE AN OBJECT----PROPERTIES CLASS----JAVA
	Properties pObj = new Properties();
	
	//LOAD THE DATA----load()----PROPERTIES CLASS
	pObj.load(file);
	
	//READ THE DATA----getProperty()----PROPERTIES CLASS
	String browserName = pObj.getProperty("browsername");
	System.out.println(browserName);
	
	//LAUNCH THE BROWSER
	if(browserName.equals("chrome"))
	{
	driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//TRIGGER THE MAIN URL
	driver.get(pObj.getProperty("url"));
	driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']")).click();
	driver.findElement(By.id("username")).sendKeys(pObj.getProperty("un"));
	driver.findElement(By.id("login-submit")).click();
	driver.findElement(By.id("password")).sendKeys(pObj.getProperty("pwd"));
	driver.findElement(By.xpath("//span[text()='Log in']")).click();
}
}
