package POManu.POM;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base2 {
	public static WebDriver driver;
	static public Properties prop;
	@BeforeTest
	@Parameters("browser")
	public void beforetest(String browser) throws Exception{
		prop=new Properties();
		prop.load(new FileInputStream(".\\OR.property"));
		Excel.ExcelConfig(".\\Anu.xlsx", "Sheet2");

		if (browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			//WebDriverWait wait = new WebDriverWait(driver,20);
		}
		/*else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
			driver = new Fir

		}*/
		driver.get("https://easemytrip.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	public static void captureScreenshot(String name)  throws Exception
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		FileUtils.copyFile(src, new File(".\\driver\\"  , screenshotName));
	}
	
	public static void captureScreenshot2(String name)
	{
		try{
			
			// Creating Robot class object
			Robot robotClassObject = new Robot();
			
			// Get screen size
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			
			// Capturing screenshot by providing size
            BufferedImage tmp = robotClassObject.createScreenCapture(screenSize); 
            
            Date d= new Date();
    		String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
            // To copy temp image in to permanent file
            ImageIO.write(tmp, "png",new File(".\\driver\\"  , screenshotName)); 
          
            
		}catch(Exception e)
		{
			System.out.println("Some exception occured." + e.getMessage());
			
		}
	}
	
	/*public static void verifyOnVisibilty(int time,WebElement Element,String ScreenName,String Message) throws Exception
	{
		try{
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(Element));
		}
		catch(Exception TimeOut)
		{
			captureScreenshot(ScreenName);
			Assert.fail(Message);
		}
		
	}*/
	
	public static void verifyElementPresent(By ByLocator,String ScreenName,String Message) throws Exception
	{
		try{
			driver.findElement(ByLocator);
		}
		catch(NoSuchElementException TimeOut)
		{
			captureScreenshot(ScreenName);
			Assert.fail(Message);
		}
		
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

}
