package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterTest extends Base1
{
	DriverFunctions functionObj;
	WebDriver driver;
	public RegisterTest(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		functionObj=new DriverFunctions();
	}
	
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

  }
 
}
