package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String ProjectPath= System.getProperty("user.dir");
		ExcelUtils excel=new ExcelUtils(ProjectPath+"/TestData/ExcelData.xlsx", "sheet1");
		
		excel.getRowCount();
		excel.getcelldataString(0, 0);
		excel.getcelldataNumber(1, 1);
		
	}
}
