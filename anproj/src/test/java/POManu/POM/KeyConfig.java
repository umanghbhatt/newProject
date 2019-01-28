package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyConfig
{
	static Select select;
	static WebDriver webdriver;
	public static void openBrowser(String Location)
	{
		if(Location.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",Location);
			webdriver=new ChromeDriver();
		}
		else if(Location.contains("gecko"))
		{
			System.setProperty("webdriver.gecko.driver",Location);
			webdriver=new FirefoxDriver();
		}
		webdriver.manage().window().maximize();
	}
	public static void openUrl(String URL)
	{
		webdriver.get(URL);
	}
	public static void enterText(String Locator,String LocatorValue,String inputdata)
	{
		JavascriptExecutor w = (JavascriptExecutor)webdriver;
		switch(Locator)
		{
			case "name":
				webdriver.findElement(By.name(LocatorValue)).clear();
				webdriver.findElement(By.name(LocatorValue)).sendKeys(inputdata);
				break;
			case "id":
				webdriver.findElement(By.id(LocatorValue)).clear();
				//webdriver.findElement(By.id(LocatorValue)).sendKeys(inputdata);
				WebElement inputFieldotp=   webdriver.findElement(By.id(LocatorValue));
				w.executeScript("arguments[0].value='"+inputdata+"';", inputFieldotp);
				//    ((JavascriptExecutor)webdriver).executeScript("arguments[0].setAttribute('value', '" +inputdata+"')", inputFieldotp);
				//  w.executeScript("arguments[0].setAttribute(inputdata);",By.id(LocatorValue));
			//	Thread.sleep(2000);
				break;
			case "css":
				webdriver.findElement(By.cssSelector(LocatorValue)).clear();
				webdriver.findElement(By.cssSelector(LocatorValue)).sendKeys(inputdata);
				break;
			case "link":
				webdriver.findElement(By.linkText(LocatorValue)).clear();
				webdriver.findElement(By.linkText(LocatorValue)).sendKeys(inputdata);
				break;
			case "xpath":
				webdriver.findElement(By.xpath(LocatorValue)).clear();
				webdriver.findElement(By.xpath(LocatorValue)).sendKeys(inputdata);
				break;
			default:
				System.out.println("Invalid Locator Specified");
		}
	}
	public static void click(String Locator,String LocatorValue)
	{
		JavascriptExecutor w = (JavascriptExecutor)webdriver;
		switch(Locator)
		{
		case "name":
			webdriver.findElement(By.name(LocatorValue)).click();
			break;
		case "id":
			webdriver.findElement(By.id(LocatorValue)).click();
		//	Thread.sleep(5000);
			break;
		case "css":
			/*webdriver.findElement(By.cssSelector(LocatorValue)).click();;
			break;*/
			w.executeScript("arguments[0].click();", webdriver.findElement(By.cssSelector(LocatorValue)));
			//Thread.sleep(6000);
			break;
		case "link":
			webdriver.findElement(By.linkText(LocatorValue)).click();
			break;
		case "xpath":
			w.executeScript("arguments[0].click();", webdriver.findElement(By.xpath(LocatorValue)));
			//Thread.sleep(5000);
			System.out.println("jvdvk");
			//  webdriver.findElement(By.xpath(LocatorValue)).click();
			break;
		case "class":
			webdriver.findElement(By.className(LocatorValue)).click();
			//select= new Select(webdriver.findElement(By.className(LocatorValue)));
			break;
		default:
			System.out.println("Invalid Locator Specified");
		}
	}
	public static void dropdownSelect(String Locator, String LocatorValue, String inputdata) 
	{
		switch(Locator)
		{
			case "name":
				select= new Select(webdriver.findElement(By.name(LocatorValue)));
				select.selectByVisibleText(inputdata);
				break;
			case "id":
				select= new Select(webdriver.findElement(By.id(LocatorValue)));
				select.selectByVisibleText(inputdata);
				break;
			case "css":
				select= new Select(webdriver.findElement(By.cssSelector(LocatorValue)));
				select.selectByVisibleText(inputdata);
				break;
			case "link":
				select= new Select(webdriver.findElement(By.linkText(LocatorValue)));
				select.selectByVisibleText(inputdata);
				break;
			case "xpath":
				select= new Select(webdriver.findElement(By.xpath(LocatorValue)));
				select.selectByVisibleText(inputdata);
				break;
			case "class":
				select= new Select(webdriver.findElement(By.className(LocatorValue)));
				select.selectByVisibleText(inputdata);
			default:
				System.out.println("Invalid Locator Specified");
		}
	}
	public static void wait(String Locator,String LocatorValue,String time)
	{
		WebDriverWait wt=new WebDriverWait(webdriver, Integer.parseInt(time));
		switch(Locator)
		{
			case "name":
				wt.until(ExpectedConditions.elementToBeClickable(By.name(LocatorValue)));
				break;
			case "id":
				wt.until(ExpectedConditions.elementToBeClickable(By.id(LocatorValue)));
				break;
			case "css":
				wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(LocatorValue)));
				break;
			case "link":
				wt.until(ExpectedConditions.elementToBeClickable(By.linkText(LocatorValue)));
				break;
			case "xpath":
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath(LocatorValue)));
				break;
			default:
				System.out.println("Invalid Locator Specified");
		}
	}
	public static void clear(String Locator,String LocatorValue)
	{
		JavascriptExecutor w = (JavascriptExecutor)webdriver;
		switch(Locator)
		{
		case "name":
			webdriver.findElement(By.name(LocatorValue)).click();
			break;
		case "id":
			webdriver.findElement(By.id(LocatorValue)).click();
		//	Thread.sleep(5000);
			break;
		case "css":
			/*webdriver.findElement(By.cssSelector(LocatorValue)).click();;
			break;*/
			w.executeScript("arguments[0].click();", webdriver.findElement(By.cssSelector(LocatorValue)));
			//Thread.sleep(6000);
			break;
		case "link":
			webdriver.findElement(By.linkText(LocatorValue)).click();
			break;
		case "xpath":
			w.executeScript("arguments[0].click();", webdriver.findElement(By.xpath(LocatorValue)));
			//Thread.sleep(5000);
			System.out.println("jvdvk");
			//  webdriver.findElement(By.xpath(LocatorValue)).click();
			break;
		case "class":
			webdriver.findElement(By.className(LocatorValue)).click();
			//select= new Select(webdriver.findElement(By.className(LocatorValue)));
			break;
		default:
			System.out.println("Invalid Locator Specified");
		}
	}
	/*public static void closeBrowser()
	{
		webdriver.close();
	}*/
}
