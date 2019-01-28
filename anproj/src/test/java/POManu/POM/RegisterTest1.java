package POManu.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterTest1 extends Base2 {

	static Select select;
	DriverFunctions functionObj;
	WebDriver driver;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	public RegisterTest1(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		functionObj=new DriverFunctions();
	
	}

	By E_MYACC;
	By E_REG;
	By E_EM_SIGNUP;
	
	By E_REGB;
	
	By E_OTP;
	By E_PWD_SIGNUP;
	By E_CPWD_SIGNUP;
	By E_SUBMIT ;
	
	/* Registration is done with email or phone number. After valid entry OTP and password is entered */
	
	 public  void Register(String email, String otp, String password,String confirmPassword) throws Exception
	  {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		
	driver.findElement(functionObj.getElementProp("E_MYACC")).click();	
	
		 action.moveToElement(driver.findElement(functionObj.getElementProp("E_MYACC"))).click().build().perform();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
		 
		 
		driver.findElement(functionObj.getElementProp("E_REG")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn_register RegInHome']")));
		
		 driver.findElement(functionObj.getElementProp("E_EM_SIGNUP")).sendKeys(email);
		 
		driver.findElement(functionObj.getElementProp("E_REGB")).click();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("otptxt")));
		executor.executeScript("arguments[0].click()", driver.findElement(functionObj.getElementProp("E_OTP")));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("otptxt")));
		 
		driver.findElement(functionObj.getElementProp("E_OTP")).click();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
		  
		driver.findElement(functionObj.getElementProp("E_PWD_SIGNUP")).sendKeys(password);
		
		driver.findElement(functionObj.getElementProp("E_CPWD_SIGNUP")).sendKeys(confirmPassword);
		
		driver.findElement(functionObj.getElementProp("E_SUBMIT")).click();
    	
		
		/* Exception Handling is done*/ 
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
    
}    
    

  
 