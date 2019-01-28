package POManu.POM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel
	{
		
		static Sheet sheet;
		static Workbook wb;
		
		public WebDriver setDriver(){
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		    WebDriver driver=new ChromeDriver();
		    return driver;
		    }
	public static void ExcelConfig(String Location,String SheetName)
	{
		try
		{
			FileInputStream input=new FileInputStream(Location);
			if(Location.endsWith(".xls"))
			{
				wb=new HSSFWorkbook(input);
			}
			else if(Location.endsWith(".xlsx"))
			{
				wb=new XSSFWorkbook(input);
			}
			sheet=wb.getSheet(SheetName);
		}catch (Exception e)
		{
			System.out.println("Error with file" +e.getMessage());
		}
	}
	public static String Read(int Row,int Column)
	{
		//return sheet.getRow(Row).getCell(Column).toString();
		String A=sheet.getRow(Row).getCell(Column).toString();
		if(A.endsWith(".0"))
				A=A.split("\\.")[0];
		
		return A;
	}
	public static int ROWNUM()
	{
		return sheet.getLastRowNum();
	}
	

	/*public static void Write(String data,int Row,int Column)
	{
		try
		{
		sheet.getRow(Row).getCell(Column).setCellValue(data);
		}
		catch(NullPointerException N1)
		{
			try 
			{
				sheet.getRow(Row).createCell(Column).setCellValue(data);
			}
			catch(NullPointerException N2)
			{
				try 
				{
					sheet.createRow(Row).createCell(Column).setCellValue(data);
				}
					catch(NullPointerException N3) 
					{
						System.out.println("Failed to write data"+N3.getMessage());
					}
				}
			}
		 Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx", "Sheet1");
	     Excel.Read(2, 1);
	     Excel.Write("data", 4, 4);
	     }*/
			
	
	public static void Export(String Location) throws IOException
	{
		 FileOutputStream OP=new FileOutputStream(Location);
		 wb.write(OP);
	}
	
	public static Object[][] MyDataProvider(String sheet,int column) throws Exception
	{
		
		Sheet customSheet =wb.getSheet(sheet);
		System.out.println(customSheet);
		Object[][] data = new Object[customSheet.getLastRowNum()][column];
		for(int r=1;r<=customSheet.getLastRowNum();r++)
		{
			
			for(int c=0;c<column;c++)
			{
				String cellData=null;
					try
					{
						cellData=customSheet.getRow(r).getCell(c).toString();
						if(cellData.endsWith(".0"))
							cellData=cellData.split("\\.")[0];
							
					}
					catch(NullPointerException N)
					{
						cellData=null;
					}
					System.out.println(cellData);
					data[r-1][c]= cellData;
			}
		}
		
		return data;
		
		
	}

	}
	

