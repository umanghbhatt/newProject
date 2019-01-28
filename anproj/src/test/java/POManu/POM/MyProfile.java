package POM;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class MyProfile
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
 
   driver.get("https://mybookings.easemytrip.com/MyBooking/Profile");
   driver.manage().window().maximize();
      FileInputStream input=new FileInputStream("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx");
      XSSFWorkbook wb=new XSSFWorkbook(input);
      XSSFSheet sheet=wb.getSheet("Register");
      
   // Actions action = new Actions(driver);
  /* WebElement we = driver.findElement(By.id("spnMyAcc"));
  action.moveToElement(we).build().perform();*/
 Thread.sleep(6000);
  // WebElement w1 = driver.findElement(By.id("exampleInputEmail1"));
 
   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn_signin']")));
   // action.moveToElement(driver.findElement(By.xpath("//a[@class='btn_register RegInHome']"))).click().build().perform(); 
   /*action.moveToElement(w1).click().perform();*/
    
      for(int i=1;i<=sheet.getLastRowNum();i++) 
      {
     
       driver.manage().window().maximize();
       driver.get("https://mybookings.easemytrip.com/MyBooking/Profile");
       
     // Actions actions=new Actions(driver);
      // driver.get("https://www.easemytrip.com/");
      /*Actions action = new Actions(driver);
      WebElement we = driver.findElement(By.id("spnMyAcc"));
      action.moveToElement(we).build().perform();
      Thread.sleep(6000);
      WebElement w1 = driver.findElement(By.xpath("//div[@id='hid1']//i[@class='cr_hp_i']"));
    
      //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn_signin']")));
       action.moveToElement(driver.findElement(By.xpath("//a[@class='btn_register RegInHome']"))).click().build().perform(); 
      action.moveToElement(w1).click().perform();*/
       
       Thread.sleep(6000);
       
       String email=sheet.getRow(i).getCell(0).toString();
       
       System.out.println("Email:" +email);
       
       driver.findElement(By.id("loginid")).clear();
       driver.findElement(By.id("loginid")).sendKeys(email);
       
       String password=sheet.getRow(i).getCell(1).toString();
       
       System.out.println("Password:" +password);
       
       driver.findElement(By.id("password")).clear();
       driver.findElement(By.id("password")).sendKeys(password);
       
       driver.findElement(By.className(" buttonLog")).click();
       
       
       driver.findElement(By.xpath("//span[contains(text(),'My Profile')]")).click();
       
       
       XSSFSheet sheet1=wb.getSheet("MyProfile");
       
        String firstname=sheet1.getRow(i).getCell(0).toString();
        
        System.out.println("First Name:" +firstname);
        
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(firstname);
        
        String lastname=sheet1.getRow(i).getCell(1).toString();
        
        System.out.println("Last Name:" +lastname);
        
        driver.findElement(By.id("exampleInputEmail1L")).clear();
        driver.findElement(By.id("exampleInputEmail1L")).sendKeys(lastname);
        
        String address=sheet1.getRow(i).getCell(2).toString();
        
        System.out.println("Address:" +address);
        
        driver.findElement(By.id("prAddress")).clear();
        driver.findElement(By.id("prAddress")).sendKeys(address);
        
        String city=sheet1.getRow(i).getCell(3).toString();
        
        System.out.println("City:" +city);
        
        driver.findElement(By.id("PrCity")).clear();
        driver.findElement(By.id("PrCity")).sendKeys(city);
        
        String state=sheet1.getRow(i).getCell(4).toString();
        
        System.out.println("State:" +state);
        
        driver.findElement(By.id("PrState")).clear();
        driver.findElement(By.id("PrState")).sendKeys(state);
        
        String zipcode=sheet1.getRow(i).getCell(5).toString();
        
        System.out.println("Zip Code:" +zipcode);
        
        driver.findElement(By.id("PrZip")).clear();
        driver.findElement(By.id("PrZip")).sendKeys(zipcode);
        
        String passno=sheet1.getRow(i).getCell(6).toString();
        
        System.out.println("Passport number:" +passno);
        
        driver.findElement(By.className("form-control")).clear();
        driver.findElement(By.className("form-control")).sendKeys(passno);
        
        String homeair=sheet1.getRow(i).getCell(6).toString();
        
        System.out.println("Home Airport:" +homeair);
        
        driver.findElement(By.id("HomeAirport")).clear();
        driver.findElement(By.id("HomeAirport")).sendKeys(homeair);
        
        driver.findElement(By.className("save_prof")).click();
        
        
        
     }
       /* driver.findElement(By.name("btn_Login")).click();
        
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
        System.out.println("Re-enter Password:" +repassword);
      
      Thread.sleep(2000);
      WebElement inputFieldrepwd= driver.findElement(By.id("confirmpass"));
      ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" +repassword+"')", inputFieldrepwd);
      
       // driver.findElement(By.name("btn_Login")).click();
        FileOutputStream OP=new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\xlsx.xlsx");
        wb.write(OP);
        
        //driver.quit();
          }*/
     
   /*  driver.findElement(By.cssSelector("input[class='buttonLogin1']")).click();
     driver.quit();*/
      }
  }
 