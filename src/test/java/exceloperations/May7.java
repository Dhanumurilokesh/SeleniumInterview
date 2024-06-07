package exceloperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class May7 {
	static String input ="/Users/harish/Downloads/Book1.xlsx";
	static String output = "/Users/harish/Downloads/Booknew123.xlsx";
	
	public static void main(String[] args) throws IOException {
	
		


		FileInputStream fileinput = new FileInputStream(input);
		FileOutputStream fileout  = new FileOutputStream(output);
		
		
		Workbook wb = new XSSFWorkbook(fileinput);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int lastrow = sh.getLastRowNum();
		System.out.println("Last Row is : " + lastrow);
		
		for(int i = 1; i<=lastrow; i++) {
			
			String fail = "fail";
			Cell cell3 = sh.getRow(i).getCell(3);
			System.out.println("cell3 Celltype = " + cell3);
			Cell cell4 = sh.getRow(i).createCell(4);
			CellType celltype3 = cell3.getCellType();
			System.out.println("type of cell3 : " +  celltype3);
			
			if(celltype3 == CellType.NUMERIC) {
				
				//convert to int
				int intcell = (int)cell3.getNumericCellValue();
				Integer classint = Integer.valueOf(intcell);
				System.out.println("converted to integer : " + classint.getClass().getName());
				
				//convert to string
				String s = String.valueOf(cell3);
				System.out.println("type of cell3 after casting: " +  s.getClass().getName());
				
				//add fail in cell4
				cell4.setCellValue(fail);
				
			}//ifcondition
			else {
				System.out.println("There is no workbook...!!");
			}//else condition
			
		}//loop end
		
		fileinput.close();
		wb.write(fileout);
		wb.close();
		
	}

}
