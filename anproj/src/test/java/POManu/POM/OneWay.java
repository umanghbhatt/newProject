package POM;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OneWay extends Base {

	DriverFunction functionObj;
	WebDriver driver;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	public OneWay(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		functionObj=new DriverFunction();
	
	}
	By p_source;
	By p_selectSource;
	By p_dest;
	By p_selectDest;
	By p_date;
	By p_box;
	By p_arrow;
	By p_selectDate ;
	By p_search;
	
	By p_checkBox;
	By p_flightDetails;
	By p_fareDetails;
	By p_baggageInformation;
	By p_cancellationRules;
	By p_bookButton;
	
	By p_plusButton;
	By p_minusButton;
	By p_radioButton;
	By p_email;
	By p_coupon;
	By p_continueBooking;
	
	By p_title;
	By p_Ms;
	By p_FirstName;
	By p_LastName;
	By p_PhoneNum;
	By p_conBooking;
	
	By p_cc;
	By p_ccn;
	By p_month;
    By p_year;
    By p_cvv;
    
    By p_netbanking;
    By p_icic;
    By p_pnb;
    By p_sbi;
    By p_yb;
    By p_hdfc;
    By p_pnsb;
    By p_otherbanks;
    By p_makepayment;
    //By monthvalue;
    By pbox;
    By plusAdult;
    By plusChild;
    
  public  void setSourceDestination(String source,String dest) throws  Exception
  {
	  
    JavascriptExecutor executor = (JavascriptExecutor)driver;
	driver.findElement(functionObj.getElementProp("p_source")).click();
	
	
    driver.findElement(functionObj.getElementProp("p_source")).sendKeys(source);
    
    Base.verifyElementPresent(By.xpath(".//*[contains(text(),'"+source+"')]"), "Source Error","Source Not Displayed");
      driver.findElement(By.xpath(".//*[contains(text(),'"+source+"')]")).click();
  //  driver.findElement(functionObj.getElementProp("p_source")).sendKeys(Keys.RETURN);
	driver.findElement(functionObj.getElementProp("p_dest")).click();
	
	driver.findElement(functionObj.getElementProp("p_dest")).sendKeys(dest);
    Base.verifyElementPresent(By.xpath(".//*[contains(text(),'"+dest+"')]"), "Destination Error","Destination Not Displayed");

    driver.findElements(By.xpath(".//*[contains(text(),'"+dest+"')]")).get(1).click();

//    driver.findElement(functionObj.getElementProp("p_dest")).sendKeys(Keys.RETURN);
    driver.findElement(functionObj.getElementProp("p_date")).click();
    
	
	
	String month=driver.findElement(functionObj.getElementProp("p_box")).getText();
	
	System.out.println(month);
	while(!month.equals("JUL 2019"))
	{
		
		executor.executeScript("arguments[0].click();",driver.findElement(functionObj.getElementProp("p_arrow")));
	    month = driver.findElement(functionObj.getElementProp("p_box")).getText();
	 
	}
	
	
	driver.findElement(functionObj.getElementProp("p_selectDate")).click();
	driver.findElement(functionObj.getElementProp("p_search")).click();
	try {
Thread.sleep(5000);
		

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("p_bookButton"))));
		
	}catch(UnhandledAlertException U)
	{

		captureScreenshot2("setSourceDestination");
		driver.switchTo().alert().accept();

		Assert.fail("Search Fail");
	}
	catch(TimeoutException U)
	{
		captureScreenshot("setSourceDestination");
		Assert.fail("Next Page is Not Loaded");
	}
	finally
	{
		driver.navigate().refresh();
	}
  
  
  
  }	
	
		
		
  
 public void alert() throws Exception
	{
		
		Alert alertObj=  driver.switchTo().alert();
		String text = alertObj.getText();
		System.out.println(text);
		Thread.sleep(5000);
	Base.captureScreenshot("Oneway");
		 //driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
    Thread.sleep(5000);
	}
  
 
     public void BookFlight() throws Exception
     {
    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
         WebDriverWait wait = new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-infinite-scroll='loadMoreOutBound()']//div[2]//div[1]//div[1]//div[6]//button[1]")));
    	 executor.executeScript("arguments[0].click();",driver.findElement(functionObj.getElementProp("p_checkBox")));
    	 driver.findElement(functionObj.getElementProp("p_flightDetails")).click();
    	 driver.findElement(functionObj.getElementProp("p_fareDetails")).click();
    	 driver.findElement(functionObj.getElementProp("p_baggageInformation")).click();
    	 driver.findElement(functionObj.getElementProp("p_cancellationRules")).click();
    	 driver.findElement(functionObj.getElementProp("p_bookButton")).click();
    	 
    	 try {
    		 Thread.sleep(5000);
    		 		

    		 		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("p_plusButton"))));
    		 		
    		 	}catch(UnhandledAlertException U)
    		 	{

    		 		captureScreenshot2("BookFlight");
    		 		driver.switchTo().alert().accept();

    		 		Assert.fail("Search Fail");
    		 	}
    		 	catch(TimeoutException U)
    		 	{
    		 		captureScreenshot("BookFlight");
    		 		Assert.fail("Next Page is Not Loaded");
    		 	}
    		 	finally
    		 	{
    		 		//driver.navigate().refresh();
    		 	}
    	 
     }
     public void Review(String email) throws Exception
     {
    	 
    	 //executor.executeScript("window.scrollBy(0,500)");
    	 driver.findElement(functionObj.getElementProp("p_plusButton")).click();
    	 driver.findElement(functionObj.getElementProp("p_minusButton")).click();
    	 driver.findElement(functionObj.getElementProp("p_radioButton")).click();
    	 driver.findElement(functionObj.getElementProp("p_email")).sendKeys(email);
    	 driver.findElement(functionObj.getElementProp("p_coupon")).click();
    	 driver.findElement(functionObj.getElementProp("p_continueBooking")).click();
    	 //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Add-ons (Optional)')]"))));
    	  
    	 try {
    		 Thread.sleep(5000);
    		 		

    		// new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Add-ons (Optional)')]"))));
       	  
    		 		
    		 	}catch(UnhandledAlertException U)
    		 	{

    		 		captureScreenshot2("Review");
    		 		driver.switchTo().alert().accept();

    		 		Assert.fail("Search Fail");
    		 	}
    		 	catch(TimeoutException U)
    		 	{
    		 		captureScreenshot("Review");
    		 		Assert.fail("Next Page is Not Loaded");
    		 	}
    		 	finally
    		 	{
    		 		//driver.navigate().refresh();
    		 	}
     }

     public void Travellers( String FirstName , String LastName , String PhoneNum) throws Exception
     {
    	 //executor.executeScript("window.scrollBy(0,500)");
    	 driver.findElement(functionObj.getElementProp("p_title")).click();
    	 driver.findElement(functionObj.getElementProp("p_Ms")).click();
    	 driver.findElement(functionObj.getElementProp("p_FirstName")).click();
    	 driver.findElement(functionObj.getElementProp("p_FirstName")).sendKeys(FirstName);
      	 driver.findElement(functionObj.getElementProp("p_LastName")).click();
    	 driver.findElement(functionObj.getElementProp("p_LastName")).sendKeys(LastName);
    	 driver.findElement(functionObj.getElementProp("p_PhoneNum")).click();
    	 driver.findElement(functionObj.getElementProp("p_PhoneNum")).sendKeys(PhoneNum);
    	 driver.findElement(functionObj.getElementProp("p_conBooking")).click();
        // new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(functionObj.getElementProp("p_cc")));
    	 try {
    		 Thread.sleep(8000);
    		 		

    		// new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(functionObj.getElementProp("p_cc")));
    		 		
    		 	}catch(UnhandledAlertException U)
    		 	{

    		 		captureScreenshot2("Travellers");
    		 		driver.switchTo().alert().accept();

    		 		Assert.fail("Search Fail");
    		 	}
    		 	catch(TimeoutException U)
    		 	{
    		 		captureScreenshot("Travellers");
    		 		Assert.fail("Next Page is Not Loaded");
    		 	}
    		 	
     }
     
     
     public void DebitPayment(String CC,String CCN, String Month,String Year,String CVV ) throws Exception
     {
    	
    	 driver.findElement(functionObj.getElementProp("p_cc")).click();
    	 driver.findElement(functionObj.getElementProp("p_cc")).sendKeys(CC);
    	 driver.findElement(functionObj.getElementProp("p_ccn")).click();
    	 driver.findElement(functionObj.getElementProp("p_ccn")).sendKeys(CCN);
    	 driver.findElement(functionObj.getElementProp("p_month")).click();
    	 driver.findElement(functionObj.getElementProp("p_month")).sendKeys(Month);
    	 driver.findElement(functionObj.getElementProp("p_year")).click();
    	 driver.findElement(functionObj.getElementProp("p_year")).sendKeys(Year);
    	 driver.findElement(functionObj.getElementProp("p_cvv")).click();
    	 driver.findElement(functionObj.getElementProp("p_cvv")).sendKeys(CVV);
      	 try {
    		 Thread.sleep(5000);
    		 		

    		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(functionObj.getElementProp("p_cc")));
    		 		
    		 	}catch(UnhandledAlertException U)
    		 	{

    		 		captureScreenshot2("DebitPayment");
    		 		driver.switchTo().alert().accept();

    		 		Assert.fail("Search Fail");
    		 	}
    		 	catch(TimeoutException U)
    		 	{
    		 		captureScreenshot("DebitPayment");
    		 		Assert.fail("Next Page is Not Loaded");
    		 	}
    		 	
    	
    	 
     }
     public void NetBanking() throws  Exception
     {
    	 driver.findElement(functionObj.getElementProp("p_netbanking")).click();
    	 driver.findElement(functionObj.getElementProp("p_icic")).click();
    	 driver.findElement(functionObj.getElementProp("p_pnb")).click();
    	 driver.findElement(functionObj.getElementProp("p_sbi")).click();
    	 driver.findElement(functionObj.getElementProp("p_yb")).click();
    	 driver.findElement(functionObj.getElementProp("p_hdfc")).click();
    	 driver.findElement(functionObj.getElementProp("p_pnsb")).click();
    	 driver.findElement(functionObj.getElementProp("p_otherbanks")).click();
    	 
    	 driver.findElement(functionObj.getElementProp("p_makepayment")).click();
     }
     

 	
     
}
		
