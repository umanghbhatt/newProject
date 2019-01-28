package POM;

import org.testng.annotations.Test;

public class RegisterTestNG extends Base {
	 
  @Test
  public void trial() throws Exception{
	  Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\Anu.xlsx", "Sheet1");
	RegisterTest register = new RegisterTest(driver);
	register.Register(Excel.Read(1, 0),Excel.Read(1, 1),Excel.Read(1, 2),Excel.Read(1, 3));
  }
  
  }

