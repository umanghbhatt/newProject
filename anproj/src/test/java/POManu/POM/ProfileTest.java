package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;*/
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileTest extends BaseProfile
{
	static Select select;
	DriverFunctionsProfile functionObj;
	WebDriver driver;
	public ProfileTest(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		functionObj=new DriverFunctionsProfile();
	}
	
  public  void Profile(String email,String password,String title,String firstname,String lastname,String address, String city,
		  String state, String zip,String country,String day, String month, String year,String passno,String passissue, 
		  String homeairport, String seattype, String mealtype,String airline,String airlinename,String flyerno) throws Exception
  {
	  
	//JavascriptExecutor executor = (JavascriptExecutor)driver;
	//String element= "arguments[0].click();";
	//Actions action = new Actions(driver);
	
	driver.findElement(functionObj.getElementProp("LOGIN")).sendKeys(email);
	//Thread.sleep(3000);
	
	driver.findElement(functionObj.getElementProp("PASSWORD")).sendKeys(password);
	Thread.sleep(3000);
	
	driver.findElement(functionObj.getElementProp("LOGINB")).click();	
	Thread.sleep(5000);
	
	driver.findElement(functionObj.getElementProp("PROFILEB")).click();	
	//Thread.sleep(3000);
	
	select= new Select(driver.findElement(functionObj.getElementProp("TITLE")));
	select.selectByVisibleText(title);
	
	driver.findElement(functionObj.getElementProp("FIRSTNAME")).clear();
	driver.findElement(functionObj.getElementProp("FIRSTNAME")).sendKeys(firstname);
	
	driver.findElement(functionObj.getElementProp("LASTNAME")).clear();
	driver.findElement(functionObj.getElementProp("LASTNAME")).sendKeys(lastname);
	
	driver.findElement(functionObj.getElementProp("ADDRESS")).clear();
	driver.findElement(functionObj.getElementProp("ADDRESS")).sendKeys(address);
	
	driver.findElement(functionObj.getElementProp("CITY")).clear();
	driver.findElement(functionObj.getElementProp("CITY")).sendKeys(city);
	
	driver.findElement(functionObj.getElementProp("STATE")).clear();
	driver.findElement(functionObj.getElementProp("STATE")).sendKeys(state);
	
	driver.findElement(functionObj.getElementProp("ZIP")).clear();
	driver.findElement(functionObj.getElementProp("ZIP")).sendKeys(zip);
	Thread.sleep(5000);
	
	driver.findElement(functionObj.getElementProp("COUNTRY")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("COUNTRY")));
	select.selectByVisibleText(country);
	Thread.sleep(2000);
	
	driver.findElement(functionObj.getElementProp("DAY")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("DAY")));
	select.selectByVisibleText(day);
	
	driver.findElement(functionObj.getElementProp("MONTH")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("MONTH")));
	select.selectByVisibleText(month);
	
	driver.findElement(functionObj.getElementProp("YEAR")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("YEAR")));
	select.selectByVisibleText(year);
	
	driver.findElement(functionObj.getElementProp("PASSPORTNO")).clear();
	driver.findElement(functionObj.getElementProp("PASSPORTNO")).sendKeys(passno);
	Thread.sleep(3000);
	
	driver.findElement(functionObj.getElementProp("PASSPORTISSUE")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("PASSPORTISSUE")));
	select.selectByVisibleText(passissue);
	
	driver.findElement(functionObj.getElementProp("HOMEAIRPORT")).clear();
	driver.findElement(functionObj.getElementProp("HOMEAIRPORT")).sendKeys(homeairport);

	driver.findElement(functionObj.getElementProp("SEATTYPE")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("SEATTYPE")));
	select.selectByVisibleText(seattype);
	
	driver.findElement(functionObj.getElementProp("MEALTYPE")).click();
	select= new Select(driver.findElement(functionObj.getElementProp("MEALTYPE")));
	select.selectByVisibleText(mealtype);
	
	driver.findElement(functionObj.getElementProp("AIRLINE")).clear();
	driver.findElement(functionObj.getElementProp("AIRLINE")).sendKeys(airline);
	
	driver.findElement(functionObj.getElementProp("AIRLINENAME")).clear();
	driver.findElement(functionObj.getElementProp("AIRLINENAME")).sendKeys(airlinename);
	
	driver.findElement(functionObj.getElementProp("FLYERNO")).clear();
	driver.findElement(functionObj.getElementProp("FLYERNO")).sendKeys(flyerno);
	
	driver.findElement(functionObj.getElementProp("SAVEPROFILE")).click();	
	Thread.sleep(3000);
	
	driver.findElement(functionObj.getElementProp("HOMEPAGE")).click();	
	
  }

/*public void ChangePassword(String pass, String cpass) {
 driver.findElement(functionObj.getElementProp("CHANGEPASSWORD")).click();
 	 
 	 driver.findElement(functionObj.getElementProp("GENERATEOTP")).click();
 	 
 	 driver.findElement(functionObj.getElementProp("OTP")).click();
 	 
 	 driver.findElement(functionObj.getElementProp("NEWPASSWORD")).sendKeys(pass);
 	 
 	 driver.findElement(functionObj.getElementProp("CPASSWORD")).sendKeys(cpass);
 	 
 	driver.findElement(functionObj.getElementProp("HOMEPAGE")).click();	
}*/

}
