package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider 
{
	@Test(dataProvider = "supplyTheData")
	public void acceptTheData(String email,String pwd)
	{
		System.out.println("email"+email+"pwd"+pwd);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pwd);
	}
	@org.testng.annotations.DataProvider
    public Object[][] supplyTheData()
{
	Object[][] obj=new Object[3][2];
	//1st person-----index--0
	obj[0][0]="abc@gmail.com";
	obj[0][1]="abc123";
	//2nd person-----index--0
	obj[1][0]="xyz@gmail.com";
	obj[1][1]="xyz123";
	//3rd person-----index--0
	obj[2][0]="lmn@gmail.com";
	obj[2][1]="lmn123";
	return obj;
}
}
