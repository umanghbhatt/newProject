package roundTrip;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import integration.BaseNew;
import registration.DriverFunctions;

public class RoundTrip extends BaseNew {
	WebDriver driver;
	DriverFunctions functionObj;
	public RoundTrip(WebDriver driver)
	{
		this.driver=driver;
		functionObj= new DriverFunctions();
	}

	By source;  
	By sourceName;
	By dest;
	By destName;
	By departuredate;
	By arrow;
	By selectMonth;
	By selectDate;
	By returnDate;
	By selectReturnMonth;
	By selectReturnDate;
	By clickSearch;
	By button;
	By button1;
	By airline;
	By indigo;
	By vistara;
	By airindia;
	By jetairways;
	By stops;
	By addon;
	By nonstop;
	By firststop;
	By secondstop;
	By travellers;
	By childdrop;
	By childdrop2;
	By done;
	By searchagain;
	By book;
	By email;
	By cont;
	By title;
	By title1;
	By denom;
	By denom1;
	By fname;
	By fname1;
	By lname;
	By lanme1;
	By phone;
	
	By cbook;
	By cardnumber;
	By expiremonth;
	By expiremonthdate;
	By expireyear;
	By expireyearvalue;
	By cvv;
	
	By passeng;
	By setAdult;
	By minusAdult;
	By setChild;
	By infants;
	By minusinfants;
	By ppay;
	
	
	public void Book(String source, String destination) throws Exception
	{
		WebDriverWait wait= new WebDriverWait(driver,25);
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		
		
		driver.findElement(functionObj.getElementProp("source")).click();
		driver.findElement(functionObj.getElementProp("source")).sendKeys(source);
		driver.findElement(By.xpath(".//*[contains(text(),'"+source+"')]")).click();
	
		driver.findElement(functionObj.getElementProp("dest")).click();
		
		driver.findElement(functionObj.getElementProp("dest")).sendKeys(destination);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddate")));
		
		Thread.sleep(2000);
		
		driver.findElement(functionObj.getElementProp("dest")).sendKeys(Keys.RETURN);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='tp-cit']")));
		Thread.sleep(5000);
		jsexecutor.executeScript("arguments[0].click()", driver.findElement(functionObj.getElementProp("departuredate")));
		
		driver.findElement(By.id("ddate"));
		//driver.findElement(functionObj.getElementProp("departuredate")).click();
		
		
		String month1= driver.findElement(functionObj.getElementProp("selectMonth")).getText();
		System.out.println(month1);
		
		while(!month1.equals("JUL 2019"))
		{
			jsexecutor.executeScript("arguments[0].click()", driver.findElement(functionObj.getElementProp("arrow")));
			month1=driver.findElement(functionObj.getElementProp("selectMonth")).getText();
		}
		
		driver.findElement(functionObj.getElementProp("selectDate")).click();


		driver.findElement(functionObj.getElementProp("returnDate")).click();
		String month2= driver.findElement(functionObj.getElementProp("selectReturnMonth")).getText();
		System.out.println(month2);
		
		if(month2.equals(month1))
		{
			driver.findElement(functionObj.getElementProp("selectReturnDate")).click();
		}
		
		
		else
		{
			System.out.println(month2);
			while(!month2.equals("AUG 2019"))
			{
				jsexecutor.executeScript("arguments[0].click()", driver.findElement(functionObj.getElementProp("arrow")));
				month2=driver.findElement(functionObj.getElementProp("selectReturnMonth")).getText();
			}
			System.out.println(month2);
			driver.findElement(functionObj.getElementProp("selectReturnDate")).click();
		}
		
		
		
		
	}
	
public void setAdult() throws Exception
{
	WebDriverWait wait= new WebDriverWait(driver,25);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='my_account']")));
		
	
		driver.findElement(functionObj.getElementProp("passeng")).click();
		for(int i=1;i<10;i++)
		{
			
			new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(functionObj.getElementProp("setAdult")));
			driver.findElement(By.cssSelector("input[class='plus_box1']")).click();
		}
		
		for(int i=8;i>1;i--) 
		{
			
			driver.findElement(functionObj.getElementProp("minusAdult")).click();
		}
}
	
	public void setchild()throws Exception
	{
		for(int i=1;i<8;i++)
		{
			driver.findElement(functionObj.getElementProp("setChild")).click();
		}
		for(int i=7;i>=0;i--)
		{
			driver.findElement(functionObj.getElementProp("minusChild")).click();
		}
	}
	
	/*public void setInfant()
	{
		
		for(int i=1;i<2;i++)
		{
			driver.findElement(functionObj.getElementProp("setAdult")).click();
			
		}
		for(int i=0;i<2;i++)
		{
			driver.findElement(functionObj.getElementProp("infants")).click();
			
		}
		for(int i=2;i>=0;i--)
		{
			driver.findElement(functionObj.getElementProp("minusinfants")).click();
			
		}
		
	}*/


	
	
	
	
	
public void zclick() throws Exception
{
	driver.findElement(functionObj.getElementProp("clickSearch")).click();
	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("clickSearch"))));
	
	try {
//Thread.sleep(5000);
		

		//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("clickSearch"))));
		
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

/*public void alertR() throws Exception
	{
		
		Alert alertObj=  driver.switchTo().alert();
		String text = alertObj.getText();
		System.out.println(text);
		Thread.sleep(5000);
	BaseNew.captureScreenshot("Oneway");
		 //driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
   Thread.sleep(5000);
	}
	*/

		
		
		
		
		//Thread.sleep(5000);
		public void flightDetails() throws Exception
		{
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		WebDriverWait wait= new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BtnBookNow")));
		
		driver.findElement(functionObj.getElementProp("airline")).click();
		System.out.println("aaja");
		
		driver.findElement(functionObj.getElementProp("button")).click();
		driver.findElement(functionObj.getElementProp("button1")).click();
		driver.findElement(functionObj.getElementProp("book")).click();
		
		try {
   //		 Thread.sleep(5000);
   		 		

   		 		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("book"))));
   		 		
   		 	}catch(UnhandledAlertException U)
   		 	{

   		 		captureScreenshot2("flightDetails");
   		 		driver.switchTo().alert().accept();

   		 		Assert.fail("Search Fail");
   		 	}
   		 	catch(TimeoutException U)
   		 	{
   		 		captureScreenshot("flightdetails");
   		 		Assert.fail("Next Page is Not Loaded");
   		 	}
		}
		
		public void flightDetails1(String em) throws Exception
		{
	    WebDriverWait wait= new WebDriverWait(driver,25);
		driver.findElement(functionObj.getElementProp("email")).click();
		driver.findElement(functionObj.getElementProp("email")).sendKeys(em);
		driver.findElement(functionObj.getElementProp("cont")).click();
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Add-ons (optional)']"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mel1-d']")));

		try {
   		 Thread.sleep(5000);
   		 		

   		 		//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp(""))));
   		 		
   		 	}catch(UnhandledAlertException U)
   		 	{

   		 		captureScreenshot2("flightDetails1");
   		 		driver.switchTo().alert().accept();

   		 		Assert.fail("Search Fail");
   		 	}
   		 	catch(TimeoutException U)
   		 	{
   		 		captureScreenshot("flightdetails1");
   		 		Assert.fail("Next Page is Not Loaded");
   		 	}
		finally
		{
			driver.navigate().refresh();
		}
		
		
		}
		public void flightDetails2(String fname,String lname,String phone,String fname1,String lname1) throws Exception
		{
		WebDriverWait wait= new WebDriverWait(driver,25);
		driver.findElement(functionObj.getElementProp("title")).click();
		driver.findElement(functionObj.getElementProp("denom")).click();
		driver.findElement(functionObj.getElementProp("fname")).click();
		driver.findElement(functionObj.getElementProp("fname")).sendKeys(fname);
		driver.findElement(functionObj.getElementProp("lname")).click();
		driver.findElement(functionObj.getElementProp("lname")).sendKeys(lname);;
		
		driver.findElement(functionObj.getElementProp("title1")).click();
		driver.findElement(functionObj.getElementProp("denom1")).click();
		driver.findElement(functionObj.getElementProp("fname1")).click();
		driver.findElement(functionObj.getElementProp("fname1")).sendKeys(fname1);
		driver.findElement(functionObj.getElementProp("lname1")).click();
		driver.findElement(functionObj.getElementProp("lname1")).sendKeys(lname1);
		
		
		
		
		driver.findElement(functionObj.getElementProp("phone")).click();
		driver.findElement(functionObj.getElementProp("phone")).sendKeys(phone);
		driver.findElement(functionObj.getElementProp("cbook")).click();
		
		//Thread.sleep(5000);

		try {
   		// Thread.sleep(5000);
   		 		

   		 		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp(""))));
   		 		//
   		 	}catch(UnhandledAlertException U)
   		 	{

   		 		captureScreenshot2("flightDetails2");
   		 		driver.switchTo().alert().accept();

   		 		Assert.fail("Search Fail");
   		 	}
   		 	catch(TimeoutException U)
   		 	{
   		 		captureScreenshot("flightdetails2");
   		 		Assert.fail("Next Page is Not Loaded");
   		 	}
		
		}
		
	public void pay(String cardno,String cardhold,String cvvno) throws Exception
	{
		WebDriverWait wait=(WebDriverWait)driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='tp-cit']")));
		//Thread.sleep(10000);
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].click()", driver.findElement(functionObj.getElementProp("cardnumber")));
		driver.findElement(functionObj.getElementProp("cardnumber")).sendKeys(cardno);
		driver.findElement(functionObj.getElementProp("cardname")).click();
		driver.findElement(functionObj.getElementProp("cardname")).sendKeys(cardhold);
		driver.findElement(functionObj.getElementProp("expiremonth")).click();
		driver.findElement(functionObj.getElementProp("expiremonthdate")).click();
		driver.findElement(functionObj.getElementProp("expireyear")).click();
		driver.findElement(functionObj.getElementProp("expireyearvalue")).click();
		driver.findElement(functionObj.getElementProp("cvv")).click();
		driver.findElement(functionObj.getElementProp("cvv")).sendKeys(cvvno);
		Thread.sleep(5000);
		driver.findElement(functionObj.getElementProp("ppay")).click();

		try {
   		 Thread.sleep(5000);
   		 		

   		 		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(functionObj.getElementProp("p_plusButton"))));
   		 		
   		 	}catch(UnhandledAlertException U)
   		 	{

   		 		captureScreenshot2("paydetails");
   		 		driver.switchTo().alert().accept();

   		 		Assert.fail("Search Fail");
   		 	}
   		 	catch(TimeoutException U)
   		 	{
   		 		captureScreenshot("paydetails");
   		 		Assert.fail("Next Page is Not Loaded");
   		 	}
		
	}

	
	
	public void alert() throws Exception
	{
		
		Alert alertObj=  driver.switchTo().alert();
		String text = alertObj.getText();
		System.out.println(text);
		driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	
	
	
	}
	


