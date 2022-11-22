package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: read the file and load into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: navigate to required sheet
		Sheet sh = wb.getSheet("contacts");
		
		//Step 4: navigate to required row inside the sheet
		Row rw = sh.getRow(4);
		
		//Step 5: naviagte to required cell inside the row
		Cell ce = rw.getCell(3);
		
		//Step 6: read the value present in that cell
		String value = ce.getStringCellValue();
		
		System.out.println(value);
		
		
		
	}

}
