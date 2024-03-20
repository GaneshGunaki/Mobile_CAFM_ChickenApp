package com.CAF.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTable {
	public static String DATA_FILE_PATH;

	public static String columnName;
	public static String sheetName;
	ExcelDataTable(){

	}

	public static String getExcelData(String sheetName, String key ,String columnName) {


		String cellValue = null;

		int rowNumberMatchingKey = 0;
		//by default 1st column value will be sent
		int columnNumberMatchingCountry=1;
		try {
			FileInputStream excelFile;
			excelFile = new FileInputStream(new File(DATA_FILE_PATH));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheet(sheetName);
			int rowCount= datatypeSheet.getLastRowNum();
			for(int i=2; i<=rowCount;i++){
				if(datatypeSheet.getRow(i).getCell(0).getStringCellValue().toString().equals(key)){
					rowNumberMatchingKey= i;
					break;
				}
				else 
				{
					if (i==rowCount){
						System.out.println("Key Not found in Excelsheet for sheet "+ sheetName );
						return null;
					}else
						System.out.println("Key searching ... in Excelsheet in sheet >> "+ sheetName );
				}
			}

			if(!(columnName.trim().isEmpty() || columnName.trim()==null)){

				switch (columnName.trim()) {
				case "US":	
					columnNumberMatchingCountry=2;
					break;
				case "Russia":					
					columnNumberMatchingCountry=4;
					break;
				case "Poland":	
					columnNumberMatchingCountry=2;
					break;
				case "Ukraine":	
					columnNumberMatchingCountry=3;
					break;
				case "Romania_EN":
					columnNumberMatchingCountry=1;
					break;
				default:
					columnNumberMatchingCountry=1;
					break;
				}
			}
			try
			{
				cellValue=datatypeSheet.getRow(rowNumberMatchingKey).getCell(columnNumberMatchingCountry).toString();
			}
			catch(NullPointerException n)
			{
				cellValue= "cell value is null/ blank";
			}
			
			System.out.println( "Data extracted from excel > " + cellValue );
			excelFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cellValue;
	}

}
