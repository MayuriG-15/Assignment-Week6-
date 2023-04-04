package week6.assgn1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputData {

	public static String[][] readData(String excelsheet) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("InputData/ServicenowData.xlsx");
		XSSFSheet ws = wb.getSheet(excelsheet);
		int rowcount = ws.getLastRowNum();
		short cellcount = ws.getRow(0).getLastCellNum();
		String data[][]= new String[rowcount][cellcount];
		
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				System.out.println(data[i-1][j]);
			}
			
		}
		wb.close();
		return data;
	}
	
}
