package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData {

	public static FileInputStream fis;
	public static String HomeDir;



	public static String getData(String SheetName, int RowNum, int ColNum) throws IOException

	{
		HomeDir= System.getProperty("user.dir");
		String AbsolutePath= "\\TestData\\Book1.xlsx";

		String filepath= HomeDir+AbsolutePath;

		fis = new FileInputStream(filepath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh =  wb.getSheet(SheetName);

		XSSFRow row = sh.getRow(RowNum);

		XSSFCell cell = row.getCell(ColNum);

		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

		String val = formatter.formatCellValue(cell); 

		return val;

	}


}
