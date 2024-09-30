package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromWorkBook 
{
 	public static WebDriver driver;
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
	FileInputStream file = new FileInputStream("./src/test/resource/TrelloWorkBook.xlsx");
   	Workbook workbook = WorkbookFactory.create(file);
   	Sheet sheet = workbook.getSheet("TrelloWorkBook");
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(1);
    String browserName = cell.getStringCellValue();
    if(browserName.equals("chrome"))
    {
    	driver=new ChromeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(sheet.getRow(1).getCell(1).getStringCellValue());
//    driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']")).click();
//	driver.findElement(By.id("username")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
	}
}