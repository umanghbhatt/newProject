package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPOM extends Base
{
	WebDriver driver;
	RegisterPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	By account=By.id("spnMyAcc");
	By registerbutton=By.linkText("Register");
	By email=By.xpath("//input[@id='txtEmail']");
	By register=By.name("btn_Login");
	By otp=By.id("otptxt");
	By password=By.id("pass");
	By confirmpassword=By.id("confirmpass");
	By submit=By.xpath("//div[@id='hid1']//input[@value='Submit']");
	public void SignUpProcess(String Email,String Password,String Otp,String Confirmpassword)
	{
		driver.findElement(account).click();
		driver.findElement(registerbutton).click();
		driver.findElement(email).sendKeys(Email);
		driver.findElement(register).click();
		driver.findElement(password).sendKeys(Password);
		driver.findElement(otp).sendKeys(Otp);
		driver.findElement(confirmpassword).sendKeys(Confirmpassword);
		driver.findElement(submit).click();
	}
}
