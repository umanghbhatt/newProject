package example;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class example 
{
	@Before
	public void beforeTest()
	{
		WebDriver driver;
		System.getProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.allmovie.com/");
		/*ssertEquals(driver.getTitle(), "All movie","False");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("The Godfather");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.RETURN);
		List<WebElement> AlllinkImage=driver.findElements(By.tagName("a"));
		int count =AlllinkImage.size();
		System.out.println("links are:"+count);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
		//Actions action=new Actions(driver);
		/*action=	action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div[2]/div[1]/a")));
		action.click().build().perform();*/
		//driver.findElement(By.xpath("//a[@href='https://www.allmovie.com/movie/the-godfather-v20076']")).click();
		/*JavascriptExecutor executor=JavascriptExecutor(driver);
		executor.executeScript("argument[0].click();",*/driver.findElement(By.xpath("//a[@href='https://www.allmovie.com/movie/the-godfather-v20076']"));


		/*Thread.sleep(2000);
		//driver.get("https://www.allmovie.com/movie/the-godfather-v20076");
		driver.findElement(By.cssSelector("a[href='https://www.allmovie.com/movie/the-godfather-v20076']")).click();
		String genre = driver.findElement(By.cssSelector("a[href='https://www.allmovie.com/genre/crime-d653']")).getText();
		System.out.println(genre);
		assertEquals(genre, "Crime","False");
		assertEquals(driver.findElement(By.xpath("//hgroup[@class='details']//span[6]//span[1]")).getText(),"A","False");	*/

	}
	@Test

	
	

}


