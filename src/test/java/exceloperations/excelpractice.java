package exceloperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelpractice {
	public static void main(String[] args) throws IOException {
		String input ="/Users/harish/Downloads/Book1.xlsx";
		//Reading path
		try(FileInputStream file = new FileInputStream(input)){
			Workbook workbook;
			if (input.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(file);
            } else if (input.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(file);
            } else {
                throw new IllegalArgumentException("The specified file is not an Excel file");
            }
			
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			Cell c4 = row.getCell(3);
			//Get values
			String fname = c1.getStringCellValue();
			String mname = c2.getStringCellValue();
			String lname = c3.getStringCellValue();
			int Eid = (int)c4.getNumericCellValue();
			System.out.println(fname  + ":" + mname + " : " + lname + " : " + Eid);
			
			
			for(int i=1; i <= sheet.getLastRowNum(); i++) {
				sheet.getRow(i).createCell(4).setCellValue("pass");	
			}
			file.close();
			FileOutputStream output = new FileOutputStream("/Users/harish/Downloads/Booknew.xlsx");
			workbook.write(output);
			output.close();
			workbook.close();
				
			
		}
		
	}

}
