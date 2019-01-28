package POManu.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfileTest1 extends Base1 {

	static Select select;
	DriverFunctionsProfile functionObj;
	WebDriver driver;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	public ProfileTest1(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		functionObj=new DriverFunctionsProfile();
	
	}
	
	//login
	By LOGIN;
	By PASSWORD;
	By LOGINB;
	
	//profile button
	By PROFILEB;
	
	//profile page
	By TITLE;
	By FIRSTNAME;
	By LASTNAME;
	By ADDRESS ;
	By CITY;
	By STATE;
	By ZIP;
	By COUNTRY;
	By DAY;
	By MONTH;
	By YEAR;
	By PASSPORTNO;
	By PASSPORTISSUE;
	By HOMEAIRPORT;
	By SEATTYPE;
	By MEALTYPE;
	By AIRLINE;
	By AIRLINENAME;
	By FLYERNO;
	
	//change password
	By CHANGEPASSWORD;
	By GENERATEOTP;
	By OTP;
	By RESEND;
	By NEWPASSWORD;
	By CPASSWORD;
	By VERIFY;
	
	//photo upload
    By PHOTO;
    By CROSS;
    
    //save profile
    By SAVEPROFILE;
    
    //home page
    By HOMEPAGE;
   
    /* Login page is opened and Login is done by entering email or phone number and password */
    
    public void Login(String email,String password) throws Exception
    {
    	System.out.println("in");
    	Thread.sleep(5000);
    	driver.findElement(functionObj.getElementProp("LOGIN")).click();
    	driver.findElement(functionObj.getElementProp("LOGIN")).sendKeys(email);
    	
    	driver.findElement(functionObj.getElementProp("PASSWORD")).sendKeys(password);
    	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    	
    	driver.findElement(functionObj.getElementProp("LOGINB")).click();	
    	Thread.sleep(5000);
    	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonLog")));
    	
    	/* Exception handling is done */
    	
    	try
    	{
    		Thread.sleep(5000);
   		 
   		 //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("p_plusButton"))));
   		 		
   		}
    	catch(UnhandledAlertException U)
    	{
   		 	captureScreenshot2("Profile");
   		 	driver.switchTo().alert().accept();
   		 	Assert.fail("Search Fail");
    	}
   		catch(TimeoutException U)
   		{
   		 	captureScreenshot("ProfileTimeout");
   		 	Assert.fail("Next Page is Not Loaded");
   		 }
    	catch(ElementNotInteractableException I)
    	{
    		captureScreenshot("ProfileNotInteractable");
			Assert.fail("Element is Not Interactable");
    	}
   		finally
   		{
   		 	driver.navigate().refresh();
   		}
    }
    
    /* Profile page is opened and profile card is filled */ 
    
    public void Profile(String title,String firstname,String lastname,String address, String city,
    String state, String zip,String country,String day, String month, String year,String passno,String passissue, 
    String homeairport, String seattype, String mealtype,String airline,String airlinename,String flyerno) throws Exception
    {
    	driver.findElement(functionObj.getElementProp("PROFILEB")).click();	
    	
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
    
    	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.name("PrZip")));
    	
    	driver.findElement(functionObj.getElementProp("COUNTRY")).click();
    	select= new Select(driver.findElement(functionObj.getElementProp("COUNTRY")));
    	select.selectByVisibleText(country);

    	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.className("select-txtn-travel")));
    	
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
    	
    	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtflyerno1")));
    	
    	driver.findElement(functionObj.getElementProp("PHOTO")).sendKeys(".\\download.jpg");

    	/* Exception handling is done */
    	
    	try
    	{
      		 Thread.sleep(5000);
      		 		
      	}catch(UnhandledAlertException U)
      	{
      		captureScreenshot2("Profile");
      		 driver.switchTo().alert().accept();
      		 Assert.fail("Search Fail");
      	}
       	catch(ElementNotInteractableException I)
       	{
       		captureScreenshot("ProfileNotInteractable");
   			Assert.fail("Element is Not Interactable");
       	}
       	catch(NoSuchElementException E)
		{
			captureScreenshot2("ProfileNoElement");
			Assert.fail("No Such Element");
		}
      	finally
      	{
      		 		driver.navigate().refresh();
      	}
    }
       
    /* Password is changed with valid OTP */
    
	public void ChangePassword(String pass, String cpass)
    {
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	String element= "arguments[0].click();";
    	
    	driver.findElement(functionObj.getElementProp("CHANGEPASSWORD")).click();
    	   new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangePassword")));
    	   
    		executor.executeScript(element, driver.findElement(functionObj.getElementProp("GENERATEOTP")));
    		
    		executor.executeScript(element, driver.findElement(functionObj.getElementProp("RESEND")));
    		
    		executor.executeScript(element, driver.findElement(functionObj.getElementProp("OTP")));
    		
    	     	 driver.findElement(functionObj.getElementProp("NEWPASSWORD")).sendKeys(pass);
    	     	 new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("newpass")));
    	     	 
    	     	 driver.findElement(functionObj.getElementProp("CPASSWORD")).sendKeys(cpass);
    	     	new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmpass")));
    	     	
    	     //	executor.executeScript(element, driver.findElement(functionObj.getElementProp("VERIFY")));
    	     	
    	     	driver.findElement(functionObj.getElementProp("VERIFY")).click();
    	     	 
    	     	// driver.findElement(functionObj.getElementProp("CROSS")).click();
    }
    
	public void alert() throws Exception
	{
		
		Alert alertObj=  driver.switchTo().alert();
		String text = alertObj.getText();
		System.out.println(text);
		Thread.sleep(5000);
		Base1.captureScreenshot("ProfileAlert");
		 //driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
    Thread.sleep(5000);
	}
	
	/* The filled Profile card is saved */
	
    public void SaveProfile()
    {
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	String element= "arguments[0].click();";
    	
    	executor.executeScript(element, driver.findElement(functionObj.getElementProp("SAVEPROFILE")));
    	
    	//driver.findElement(functionObj.getElementProp("SAVEPROFILE")).click();	
    	 
        driver.findElement(functionObj.getElementProp("HOMEPAGE")).click();
    }
    
}    
    

  
 