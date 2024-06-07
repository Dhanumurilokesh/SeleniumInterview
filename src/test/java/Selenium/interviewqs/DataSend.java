package Selenium.interviewqs;

import org.testng.annotations.DataProvider;

public class DataSend {
	
	@DataProvider(name = "loginDataTest", parallel = true)
	public static Object[][] loginTestdata(){
		return new Object[][] {
			{"Admin" , "admin123"},
			//{"admin", "1234"}
			
		};
		
	} 

}
