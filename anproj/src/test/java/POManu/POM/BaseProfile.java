 package POM;

 import java.io.FileInputStream;
 import java.util.Properties;

 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;

 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Parameters;


public class BaseProfile 
{
 
	  	public static WebDriver driver;
	  	static public Properties prop;

	  	@BeforeTest
	  	@Parameters("browser")
	  	public void beforetest(String browser) throws Exception
	  	{
	  		prop=new Properties();
	  		prop.load(new FileInputStream("D:\\CP-SAT requirement\\Demo_new\\BusBooking\\Testing\\OR.property"));
	  		if (browser.equalsIgnoreCase("chrome"))
	  		{
	  			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	  			driver = new ChromeDriver();
	  		}
	  		/*else if (browser.equalsIgnoreCase("firefox"))
	  		{
	  			System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
	  			driver = new Fir

	  		}*/
	  		driver.get("https://mybookings.easemytrip.com/MyBooking/Profile");
	  		driver.manage().window().maximize();
	  		Thread.sleep(3000);

	  	}

	  	/*@AfterTest
	  	public void afterTest() throws Exception 
	  	{
	  		Thread.sleep(5000);
	  		driver.quit();
	  	}
*/

  }

