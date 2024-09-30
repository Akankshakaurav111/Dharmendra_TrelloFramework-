package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation_ArgumentMethods {
	WebDriver driver;

	@BeforeMethod
	public void preCondtion() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 2, invocationCount = 2)
	public void vtigerApplication() {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys("admin");

		WebElement passwordTextField = driver.findElement(By.id("password"));
		passwordTextField.clear();
		passwordTextField.sendKeys("123");

		WebElement loginOption = driver.findElement(By.xpath("//button[text()='Sign in']"));
		loginOption.click();

	}

	@Test(priority = 1, dependsOnMethods = "vtigerApplication")
	public void facebookApplication() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.name("login")).submit();
	}
	
	
	@Test(enabled=false)
	public void trlloApplication() {
		driver.get("https://trello.com/");
		driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
	}

	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
