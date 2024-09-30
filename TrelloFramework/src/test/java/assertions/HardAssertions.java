package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssertions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]//a[text()='Log in']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Log in to continue -  in with Atlassian account", "Failed");
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}
}
