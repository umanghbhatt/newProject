package POM;

import org.openqa.selenium.WebDriver;

import resource.LoadProperty;

public class General {
	WebDriver driver;
	LoadProperty Element;
	public General(WebDriver iDriver)
	{
		driver=iDriver;
		Element=new LoadProperty(".\\Flight.property",driver);
	}
}
