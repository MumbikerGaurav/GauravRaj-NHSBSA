package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String ProjectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}


	public static void main(String[] args) {
		getRowCount();
		getcelldataString(0, 0);
		getcelldataNumber(1, 1);
	}

	public static int getRowCount() {
		int rowcount=0;
		try {

			rowcount= sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows count ="+rowcount);
		} 
		catch (Exception exp)
		{
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return rowcount;
	}

	public static int getColCount() {
		int colcount=0;
		try {

			colcount= sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns count ="+colcount);
		} 
		catch (Exception exp)
		{
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}	
		return colcount;
	}

	public static String getcelldataString(int rowNum, int colNum) {
		String celldata=null;
		try {

			celldata= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(celldata);
		}
		catch (Exception exp)
		{
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return celldata;
	}


	public static void getcelldataNumber(int rowNum, int colNum) {
		try {

			double celldata= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(celldata);
		}
		catch (Exception exp)
		{
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
	}

}
