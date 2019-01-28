package POM;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


	public class Main extends Base {
		static OneWay oneway ;
		
		@Test(priority=1,dataProvider="dp")
		public  void setSourceDestinationTest(String Source,String Destination)  throws Exception
		{
			oneway= new OneWay(driver);
			oneway.setSourceDestination(Source,Destination);
		}
		
		@DataProvider
		public Object[][] dp() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Sheet2", 2);
			return data;
		}
		
	
	
	@Test(priority=2 )
	public  void BookFlightTest()  throws Exception
	{
	
		oneway=new OneWay(driver);
		oneway.BookFlight();

     }
	
	
	@Test(priority=3 , dataProvider="dp2")
	public void ReviewTest (String email ) throws Exception
	{
		oneway.Review(email);
	}
	
	@DataProvider
	public Object[][] dp2() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet5", 1);
		return data;
	}
	
	@Test(priority=4 , dataProvider="dp3")
	public void TravellersTest (String Firstname , String Lastname ,String PhoneNum) throws Exception
	{
		oneway= new OneWay(driver);
		oneway.Travellers(Firstname, Lastname, PhoneNum);
	}
	
	@DataProvider
	public Object[][] dp3() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet3", 3);
		return data;
	}
	
	@Test(priority=5 , dataProvider="dp4")
	public void DebitPaymentTest (String CC , String CCN ,String Month, String Year, String CVV) throws Exception
	{
		oneway= new OneWay(driver);
		oneway.DebitPayment(CC, CCN, Month, Year, CVV);
	}
	
	@DataProvider
	public Object[][] dp4() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet4", 5);
		return data;
	}
	@Test(priority=6 )
	public void NetBankingTest () throws Exception
	{
		oneway= new OneWay(driver);
		oneway.NetBanking();
	}
	
	


	
	
	/*@Test
	public static void trial()  throws Exception {
	
		Excel.ExcelConfig(".\\EaseMyTrip1.xlsx", "Sheet1");
		OneWay oneway = new OneWay(driver);
		
		oneway.setSourceDestination(Excel.Read(2	, 0),Excel.Read(2, 1));
	    oneway.alert();
		oneway.setSourceDestination(Excel.Read(3	, 0),Excel.Read(3, 1));
		oneway.BookFlight();
		oneway.Review(Excel.Read(1, 0));
		oneway.Travellers(Excel.Read(1,1), Excel.Read(1,2), Excel.Read(1,3));
		oneway.DebitPayment(Excel.Read(1, 4), Excel.Read(1,5), Excel.Read(1, 6), Excel.Read(1, 7), Excel.Read(1, 8));	
		oneway.NetBanking();
	


}

	
	
	@Test
	public static void trial2()  throws Exception {
	
		Excel.ExcelConfig(".\\EaseMyTrip1.xlsx", "Sheet1");
		OneWay oneway = new OneWay(driver);
		
		oneway.setSourceDestination(Excel.Read(2	, 0),Excel.Read(2, 1));
	    oneway.alert();
		oneway.setSourceDestination(Excel.Read(3	, 0),Excel.Read(3, 1));
		oneway.BookFlight();
		oneway.Review(Excel.Read(1, 0));
		oneway.Travellers(Excel.Read(1,1), Excel.Read(1,2), Excel.Read(1,3));
		oneway.DebitPayment(Excel.Read(1, 4), Excel.Read(1,5), Excel.Read(1, 6), Excel.Read(1, 7), Excel.Read(1, 8));	
		oneway.NetBanking();
	


}
*/

	}

