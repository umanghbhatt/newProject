package POManu.POM;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class MainRegister extends Base2 {
		static RegisterTest1 register;
		
		@Test(priority=1,dataProvider="dp")
		
		 public  void Register(String email, String otp, String password,String confirmPassword) throws Exception
		{
			register= new RegisterTest1(driver);
			register.Register(email,otp, password, confirmPassword);
			
		}
		
		@DataProvider
		public Object[][] dp() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Sheet1", 4);
			return data;
		}

	}

