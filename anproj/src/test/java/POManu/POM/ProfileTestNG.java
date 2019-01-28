package POM;

import org.testng.annotations.Test;

public class ProfileTestNG extends BaseProfile {
	 
  @Test
  public void trial() throws Exception
  {
	  Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\Anu.xlsx", "Sheet2");
	  
	ProfileTest1 profile = new ProfileTest1(driver);
	
	profile.Login(Excel.Read(1, 0),Excel.Read(1, 1));
	
	profile.Profile(Excel.Read(1, 2),Excel.Read(1, 3),Excel.Read(1, 4),Excel.Read(1, 5),
			Excel.Read(1, 6),Excel.Read(1, 7),Excel.Read(1, 8),Excel.Read(1, 9),Excel.Read(1, 10),Excel.Read(1, 11),
			Excel.Read(1, 12),Excel.Read(1, 13),Excel.Read(1, 14),Excel.Read(1, 15),Excel.Read(1, 16),Excel.Read(1, 17),
			Excel.Read(1, 18),Excel.Read(1, 19),Excel.Read(1, 20));

	profile.ChangePassword(Excel.Read(1, 21),Excel.Read(1, 22));
	
	profile.SaveProfile();
  }
  
  }

