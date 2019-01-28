package POM;

import org.testng.annotations.Test;
import POM.Excel;


import POM.KeyConfig;

public class Execute {
  @Test
  public void f() throws Exception
  {

Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx","Sheet1" );
		
		for(int i=1;i<=Excel.ROWNUM();i++)
		{
		String A=Excel.Read(i, 0);
		switch(A)
		{
		case "openBrowser":
			KeyConfig.openBrowser(Excel.Read(i, 3));
			break;
		case "openUrl":
			KeyConfig.openUrl(Excel.Read(i, 3));
			break;
		case "enterText":
			KeyConfig.enterText(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
			//Thread.sleep(2000);
			break;
		case "click":
			KeyConfig.click(Excel.Read(i, 1), Excel.Read(i, 2));
			//Thread.sleep(2000);
			break;
		/*case "Screenshot":
			KeyConfig.Screenshot();
			break;*/
		/*case "closeBrowser":
			KeyConfig.closeBrowser();
			break;*/
		case "dropdownSelect":
			KeyConfig.dropdownSelect(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
			//Thread.sleep(2000);
			break;
		case "clear":
			KeyConfig.clear(Excel.Read(i, 1), Excel.Read(i, 2));
			break;
		case "wait":
			KeyConfig.wait(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
			break;

		}
		}
 
		
				
					
				
				
				}
  }

