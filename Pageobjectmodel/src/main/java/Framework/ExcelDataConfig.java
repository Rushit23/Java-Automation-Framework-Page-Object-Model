package Framework;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



// create a Folder  Inside the Project TestData



public class ExcelDataConfig
	{
		  XSSFWorkbook wb;
		  
		  XSSFSheet sheet1;
		  
		  public ExcelDataConfig(String excelPath)
		  {
			  
			  try
				  {
				  
				  File src = new File(excelPath);
				  FileInputStream fis = new FileInputStream(src);
				  wb= new XSSFWorkbook(fis);
				  
			  }
			  
			  
			  catch(Exception e)
			  {
				  
				  System.out.println(e.getMessage());
			  }
			  
		  }
		
		
		  
		  
		  public  String getData(int sheetNumber,int row,int column) throws InterruptedException 
		  {
			  String dataaa;
			  sheet1= wb.getSheetAt(sheetNumber);
			  
			   // To Read Numeric Cell Value
				//int data= (int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();
			  
			 dataaa = String.valueOf(sheet1.getRow(row).getCell(column));
			 Thread.sleep(1000);
			
			  
			  return dataaa;  
			  
		  }
		  
		  public int getRowCount(int sheetIndex) throws InterruptedException
			  {
				 int row =wb.getSheetAt(sheetIndex).getLastRowNum();
				  
				row = row+1;
				Thread.sleep(3000);
				
				  return row;  
				  
			  }
		  
		  
	}
