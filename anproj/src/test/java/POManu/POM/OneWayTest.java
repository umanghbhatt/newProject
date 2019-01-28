package POM;

import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import Key.*;

public class OneWayTest {
	WebDriver w;

	@Test
	public void searchFlights() throws Exception {
		Excel.ExcelConfig("C:\\Users\\vshadmin\\Desktop\\flight.xlsx", "OneWayTest");

		for (int i = 1; i <= Excel.ROWNUM(); i++) {
			String A = Excel.Read(i, 0);
			switch (A) {
			case "openBrowser":
				KeyConfig.openBrowser(Excel.Read(i, 3));
				break;
			case "openUrl":
				KeyConfig.openUrl(Excel.Read(i, 3));
				break;
			case "enterText":
				KeyConfig.enterText(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
				break;
			case "click":
				KeyConfig.click(Excel.Read(i, 1), Excel.Read(i, 2));
				break;
			case "dateClick":
				System.out.println(Excel.Read(i,3).toString());
				KeyConfig.dateClick(Excel.Read(i, 1), Excel.Read(i, 2),Excel.Read(i, 3),Excel.Read(i, 4));
				break;
			case "closeBrowser":
				KeyConfig.closeBrowser();
				break;
			case "setAdult":
				KeyConfig.setAdult(Excel.Read(i,1),Excel.Read(i, 2),Excel.Read(i, 3));
				break;
			case "setChild":
				KeyConfig.setChild(Excel.Read(i,1),Excel.Read(i, 2),Excel.Read(i, 3));
				break;
			case "setInf":
				KeyConfig.setInf(Excel.Read(i,1),Excel.Read(i, 2),Excel.Read(i, 3));
				break;
				
			case "popup":
				KeyConfig.popup();
				break;
				
			case "wait":
				KeyConfig.wait(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
				break;
			case "slider":
				KeyConfig.slider(Excel.Read(i, 1), Excel.Read(i, 2));
				break;
			}

		}
	}
}
