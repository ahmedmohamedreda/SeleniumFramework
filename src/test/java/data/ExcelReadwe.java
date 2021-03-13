package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadwe {

	static FileInputStream fis=null;

	public FileInputStream getFileInputStream() 
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.xlsx";
		File srcfile=new File(filePath);
		try {
			fis=new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("the Data file(Excel) not found : "+e.getMessage());
		}
		return fis;	
	}
	public Object[][] getExcelData() throws IOException
	{
		fis=getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int TotalNumOFRows=(sheet.getLastRowNum()+1);
		int TotalNumOFCols=4;  //4 because the cols are (fname,lname,email,pass) and will be
		String arrayExcelData[][]=new String [TotalNumOFRows][TotalNumOFCols];

		for (int i = 0; i < TotalNumOFRows; i++)
		{
			for (int j = 0; j < TotalNumOFCols; j++) 
			{
				XSSFRow row=sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}	
		}
		wb.close();
		return arrayExcelData;

	}
}
