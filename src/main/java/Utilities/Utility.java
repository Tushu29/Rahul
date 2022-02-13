package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	   static String Value;
	
	public static String excelData(String Sheet, int a, int b) throws EncryptedDocumentException, IOException
	{
		String Path ="D:\\RP\\Software Testing\\Tushar\\RAHUL.xlsx";
		FileInputStream File = new FileInputStream(Path);
		Sheet R= WorkbookFactory.create(File).getSheet(Sheet);
		try
		{
		 Value =R.getRow(a).getCell(b).getStringCellValue();
		
		return Value;
		}
		catch(Exception e)
		{
			double value =R.getRow(a).getCell(b).getNumericCellValue();
			Value = Double.toString(value);
			return Value;
		}
	}

}

