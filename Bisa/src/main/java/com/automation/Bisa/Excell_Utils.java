package com.automation.Bisa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.ContinueRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excell_Utils {
	
	String excellocation= System.getProperty("user.dir")+"\\resources\\Bisarepo.xlsx";
	
	public String getExcellData(String sheetno, int rownum, int celnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excellocation);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetno);
		Row row=sheet.getRow(rownum);
//		System.out.println("*******row******" + row);
		String data=row.getCell(celnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
		return data;
	}
	
	public int lengthOfRow(String sheetno) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excellocation);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetno);
		int length = sheet.getLastRowNum();
		return length;
	}
	
	
	public String setExcellData(String sheetno, int rownum, int celnum, String data) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(excellocation);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetno);
		Row row=sheet.getRow(rownum);
//		System.out.println("*******row in set******" + row);
		Cell cell=row.createCell(celnum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excellocation);
		wb.write(fos);
		wb.close();
		return data;
	}
}
