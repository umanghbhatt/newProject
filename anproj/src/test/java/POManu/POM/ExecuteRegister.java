package POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import utils.Excel;
public class ExecuteRegister extends Base 
{
  @Test
  public void f() throws Exception 
  {
	 RegisterPOM register=new RegisterPOM(driver);
	//  	signup.SignUpProcess(Email, Password, Otp, Confirmpassword);
	  	FileInputStream input=new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Anu.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(input);
		XSSFSheet sheet=wb.getSheet("Sheet1");
	  	  
  }
}
