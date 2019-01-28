package roundTrip;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import integration.BaseNew;
import registration.Excel;

public class ExecuteRound extends Base{
	
	static RoundTrip roundtrip;
	
	
  @Test(priority=1,dataProvider="dp1")
  public void BookTest(String source,String dest) throws Exception 
  {
		roundtrip=new RoundTrip(driver);
		roundtrip.Book(source, dest);
	}
  
  @DataProvider
  public Object[][] dp1() throws Exception
  {
	  Object data[][]= Excel.MyDataProvider("RoundTrip1", 2);
	  return data;
	  
  }
  
  
 @Test(priority=2)
 public void setadultTest() throws Exception
 {
	 roundtrip=new RoundTrip(driver);
	 roundtrip.setAdult();
 }
 
 @Test(priority=3)
 public void setChildTest()throws Exception
 {
	 roundtrip=new RoundTrip(driver);
	 roundtrip.setchild();
 }
  
  
  
  
  
	
	  @Test(priority=4)
	  public void zclickTest() throws Exception
	  {
		  roundtrip= new RoundTrip(driver);
		  roundtrip.zclick();
	  }
  
  @Test(priority=5)
  public void flightDetailsTest() throws Exception
  {
	  roundtrip=new RoundTrip(driver);
	  roundtrip.flightDetails();
  }
  
  @Test(priority=6,dataProvider="dp2")
  public void flightDetails1Test(String email) throws Exception
  {
	  roundtrip=new RoundTrip(driver);
	  roundtrip.flightDetails1(email);
  }
  
	  
  @DataProvider
	public Object[][] dp2() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("RoundTrip2", 1);
		return data;
	}

  @Test(priority=7, dataProvider="dp3")
  public void flightDetailsTest2(String fname,String lname,String fname1, String lname1,String phone) throws Exception
  {
	  roundtrip=new RoundTrip(driver);
	  roundtrip.flightDetails2(fname, lname, phone,fname1,lname1);
  }
  
  @DataProvider
  public Object[][] dp3() throws Exception
  {
	  Object data[][]=Excel.MyDataProvider("RoundTrip3", 5);
	  return data;
	  
  }
	  
	 @Test(priority=8, dataProvider="dp4")
	 public void payTest(String cardno, String cardhold,String cvvno) throws Exception
	 {
		 roundtrip=new RoundTrip(driver);
		 roundtrip.pay(cardno, cardhold, cvvno);
				 }
	 
	 @DataProvider
	 public Object[][] dp4() throws Exception
	 {
		 Object data[][]=Excel.MyDataProvider("RoundTrip4", 3);
		 return data;
	 }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	  /*RoundTrip roundtrip= new RoundTrip(driver);
	  Excel.ExcelConfig(".\\EaseMyTrip.xlsx", "RoundTrip");;
	  roundtrip.Book();
	  roundtrip.setAdult();
	  roundtrip.setchild();
	  roundtrip.setInfant();
	  roundtrip.click();
	  roundtrip.flightDetails();
	  roundtrip.flightDetails1(Excel.Read(0,0));
	  roundtrip.flightDetails2(Excel.Read(0, 1),Excel.Read(0, 3),Excel.Read(0,2),Excel.Read(0, 4),Excel.Read(0, 5));
	  roundtrip.pay(Excel.Read(0, 6),Excel.Read(0, 7),Excel.Read(0, 8));*/
  
  
  
  
}
  
  