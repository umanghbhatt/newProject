package POM;

import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;*/
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpFactory extends Factory {
	
	public SignUpFactory(WebDriver iDriver) 
	{
		super(iDriver);
	}

	public void SIGNUP(String data) throws Exception
	{
		String dataA[]=data.split(",");
		
		Element.getElementProp("E_MYACC").click();
		Element.getElementProp("E_REG").click();
	/*	WebDriverWait wt=new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.visibilityOf(Element.getElementProp("E_REG"))).click();*/
		Element.getElementProp("E_EM_SIGNUP").sendKeys(dataA[0]);
		Element.getElementProp("E_REGB").click();
		Element.getElementProp("E_OTP").sendKeys(dataA[1]);
		Element.getElementProp("E_PWD_SIGNUP").sendKeys(dataA[2]);
		Element.getElementProp("E_CPWD_SIGNUP").sendKeys(dataA[3]);
		Element.getElementProp("E_SIGNUPB").click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
}
