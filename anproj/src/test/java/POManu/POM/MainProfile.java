package POManu.POM;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




	public class MainProfile extends Base1 {
		static ProfileTest1 profile;
		
		@Test(priority=1,dataProvider="dp")
		
		public void Logintest(String email,String password) throws Exception
		{
			profile= new ProfileTest1(driver);
			profile.Login(email,password);
			
		}
		
		@DataProvider
		public Object[][] dp() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Sheet2", 2);
			return data;
		}
	
		
	@Test(priority=2, dataProvider="dp1" )
	
	public  void ProfileTest(String title,String firstname,String lastname,String address, String city,
		    String state, String zip,String country,String day, String month, String year,String passno,String passissue, 
		    String homeairport, String seattype, String mealtype,String airline,String airlinename,String flyerno)  throws Exception
	{
		profile= new ProfileTest1(driver);
		profile.Profile(title, firstname, lastname, address, city, state, zip, country, day, month, year, passno, passissue, homeairport,
				seattype, mealtype, airline, airlinename, flyerno);
		
     }

	@DataProvider
	public Object[][] dp1() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet3", 19);
		return data;
	}
	
	@Test(priority=3 , dataProvider="dp2")
	public void ChangePasswordTest (String pass, String cpass ) throws Exception
	{
		profile= new ProfileTest1(driver);
		profile.ChangePassword(pass, cpass);
	}
	
	
	@DataProvider
	public Object[][] dp2() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet4", 2);
		return data;
	}
	
	@Test(priority=4)
	public void SaveProfileTest () throws Exception
	{
		profile= new ProfileTest1(driver);
		profile.SaveProfile();
	}
	
	

	}

