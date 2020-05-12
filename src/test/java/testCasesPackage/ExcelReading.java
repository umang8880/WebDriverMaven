package testCasesPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Why return type is object: Because from excel we can get int, string, boolean
 * So for that a super class is Object. if we need only string value from excel than
 * we cann write Sting return type but here we are getting string, int and boolean so that's why Object written
 */

public class ExcelReading {
	@DataProvider(name="dp1")
	public static Object[][] getdata(Method m) throws EncryptedDocumentException, IOException{	
		File f = null;
		if (m.getName().equals("gmailLogin")) {
			f = new File("C:\\Users\\LB-14\\Desktop\\Java\\Write File\\Gmail cred.xlsx");
			
		}
		else if(m.getName().equals("doFBLogin")) {
			f = new File("C:\\Users\\LB-14\\Desktop\\Java\\Write File\\FB cred.xlsx");
		}
		
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet0 = workbook.getSheetAt(0);
		Row row0 = sheet0.getRow(0); 
		
		int totalRows = sheet0.getPhysicalNumberOfRows()-1;
		int totalCols = row0.getPhysicalNumberOfCells();
		 		
		Object[][] data = new Object[totalRows][totalCols]; //[totalRows][totalCols] Total# rows and cols
		
		for (int rownum=1; rownum<=totalRows; rownum++) {
			row0 = sheet0.getRow(rownum);
			for(int colnum=0; colnum<totalCols; colnum++) {
			data[rownum-1][colnum] = row0.getCell(colnum).getStringCellValue();
			}
		}
		fis.close();
		return data;
	}
}
