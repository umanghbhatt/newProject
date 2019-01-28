package POManu.POM;

import org.openqa.selenium.By;

public class DriverFunctions extends Base2
{
	
	public By getElementProp(String Key)
	{
		By Element=null;
		System.out.println(prop.getProperty(Key));
		String LocatorType=prop.getProperty(Key).split(":")[1];
		String LocatorValue=prop.getProperty(Key).split(":")[0];
		

		if(LocatorType.equalsIgnoreCase("id"))
		{
			Element=By.id(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("name"))
		{
			Element=By.name(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("css"))
		{
			Element=By.cssSelector(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("linktext"))
		{
			Element=By.linkText(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			Element=By.xpath(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("class"))
		{
			Element=By.className(LocatorValue);
		}
				
		else 
			System.out.println("invalid locator");
		
		return Element;
		
	}
	
	
}

