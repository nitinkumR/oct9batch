package Utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromDataSheet(int row,int col) throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\reddy\\Desktop\\logindata.xlsx";
		
		FileInputStream file=new FileInputStream(path);
	double data=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getNumericCellValue();
	             String s=String.valueOf(data);
	             return s;
	             
	}
	
	
	
	
	public static void saveScrenshot(WebDriver driver,int testID) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\screenshot\\Test"+testID+".jpg");
		FileHandler.copy(src, dest);
		
	}

	
	

}
