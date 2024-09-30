package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class PsedoColumn 
{
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		try {
			
		
		
		FileInputStream fls=new FileInputStream("./src/test/resource/PsedoColumn.xlsx");
		Workbook workbook=WorkbookFactory.create(fls);
		Sheet sheet = workbook.getSheet("Sheet");
		int noOfRow = sheet.getLastRowNum();
	
		
		for(int r=0;r<=noOfRow;r++)
		{
			Row row = sheet.getRow(r);
			if(row==null)
				continue;
			short NOofCell = sheet.getRow(r).getLastCellNum();
		
			for(int c=0;c<=NOofCell;c++)
			{
				Cell cell = sheet.getRow(r).getCell(c);
			if(cell==null)
				continue;
				switch(cell.getCellType())
				{
				case NUMERIC:
					double numericalData = cell.getNumericCellValue();
					System.out.println(numericalData);
					break;
				case STRING:
					String stringData = cell.getStringCellValue();
					System.out.println(stringData);
					break;
				case BOOLEAN:
					boolean booleanData = cell.getBooleanCellValue();
					System.out.println(booleanData);
					break;
				default:
					System.out.println("Data is not present");
				}
			}
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

