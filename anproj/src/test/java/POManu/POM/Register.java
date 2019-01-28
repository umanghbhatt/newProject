package POM;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register 
{
	WebDriver driver;
	@BeforeTest
	public void BeforeTest()
	{
		//System.out.println("hi");
	 System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	}
  @Test
  public void f() throws Exception 
  {
	
	  driver.get("https://www.easemytrip.com/");
	  driver.manage().window().maximize();
	  	  FileInputStream input=new FileInputStream("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx");
	  	  XSSFWorkbook wb=new XSSFWorkbook(input);
	  	  XSSFSheet sheet=wb.getSheet("Sheet1");
	  	  
	  	Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.id("spnMyAcc"));
			action.moveToElement(we).build().perform();
			Thread.sleep(6000);
			WebElement w1 = driver.findElement(By.xpath("//div[@id='hid1']//i[@class='cr_hp_i']"));
	
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn_signin']")));
			 action.moveToElement(driver.findElement(By.xpath("//a[@class='btn_register RegInHome']"))).click().build().perform(); 
			/*action.moveToElement(w1).click().perform();*/
			 
	  	  for(int i=0;i<=sheet.getLastRowNum();i++) 
	  	  {
	  		
	  			// driver.manage().window().maximize();
	  			 
	  		//	Actions actions=new Actions(driver);
	  			// driver.get("https://www.easemytrip.com/");
	  			/*Actions action = new Actions(driver);
	  			WebElement we = driver.findElement(By.id("spnMyAcc"));
	  			action.moveToElement(we).build().perform();
	  			Thread.sleep(6000);
	  			WebElement w1 = driver.findElement(By.xpath("//div[@id='hid1']//i[@class='cr_hp_i']"));
	  	
	  			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn_signin']")));
	  			 action.moveToElement(driver.findElement(By.xpath("//a[@class='btn_register RegInHome']"))).click().build().perform(); 
	  			action.moveToElement(w1).click().perform();*/
	  			 
	  			  String email=sheet.getRow(i).getCell(0).toString();
	  			  
	  			  System.out.println("Email-id:" +email);
	  			  
	  			  driver.findElement(By.id("txtEmail")).clear();
	  			  driver.findElement(By.id("txtEmail")).sendKeys(email);
	  		}
	  			  driver.findElement(By.name("btn_Login")).click();
	  			  
	  			for(int j=0;j<=sheet.getLastRowNum();j++) 
	  			{
			  
	  			String otp=sheet.getRow(j).getCell(2).toString();  // To fetch OTP
	  			 System.out.println("OTP:" +otp);
	  			 Thread.sleep(2000);
	  			 WebElement inputFieldotp=   driver.findElement(By.id("otptxt"));
	  			    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" +otp+"')", inputFieldotp);
	  			
	  			    
	  			    String password=sheet.getRow(j).getCell(1).toString();  // To fetch password 
	  			  System.out.println("Password:" +password);
	  			
	  			Thread.sleep(2000);
	  			WebElement inputFieldpwd= driver.findElement(By.id("pass"));
	  			((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" +password+"')", inputFieldpwd);
	  			
	  			
	  			 String repassword=sheet.getRow(j).getCell(1).toString();  // To enter re-password 
	  			  System.out.println("Password:" +repassword);
	  			
	  			Thread.sleep(2000);
	  			WebElement inputFieldrepwd= driver.findElement(By.id("confirmpass"));
	  			((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" +repassword+"')", inputFieldrepwd);
	  			
	  			 // driver.findElement(By.name("btn_Login")).click();
	  			  /*FileOutputStream OP=new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx");
	  			  wb.write(OP);*/
	  			  //System.out.println("dvfdk");
	  			  
	  			  //driver.quit();
	  		     }
	  		
	  		driver.findElement(By.cssSelector("input[class='buttonLogin1']")).click();
	  		driver.quit();
	  	  }
  }
  


