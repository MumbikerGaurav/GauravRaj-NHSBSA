package utils;

public class ExcelDataProvider {
	public static void main(String[] args) {
		String ProjectPath= System.getProperty("user.dir");
		String excelPath=ProjectPath+"/TestData/ExcelData.xlsx";
		String sheetName= "sheet1";
		testdata(excelPath, sheetName);
	}

	public static void testdata(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
		for (int i=1;i<rowCount;i++) {
			for (int j=0; j<colCount;j++) {
				String celldata= excel.getcelldataString(i, j);
				System.out.print(celldata +"|");
			}
			System.out.println();
		}
	}
}
