package Selenium.interviewqs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataprovider {
	
	WebDriver driver;
	
	
	@Test(dataProvider = "loginDataTest" )
	public void logintest(String username , String password) throws InterruptedException {
		
		driver =new ChromeDriver();
		
		long start = System.currentTimeMillis();
		driver.get("https://opensource-demo.orangehrmlive.com");
		long End = System.currentTimeMillis();
		long loadtime = End - start;
		System.out.println(loadtime);
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		
		//send username
		WebElement user = driver.findElement(By.xpath("//input[@name ='username']"));
		user.sendKeys(username);
		Thread.sleep(3000);
		
		//send password
		WebElement pass = driver.findElement(By.xpath("//input[@name = 'password']"));
		pass.sendKeys(password);
		Thread.sleep(3000);
		
		//click login
		WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
		Thread.sleep(5000);
		
		String url = driver.getCurrentUrl();
		System.out.println("login url : " + url);
		
		//title
		//String logintitle = driver.getTitle();
		//System.out.println(logintitle);
		assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" );
	
	}
	
	@DataProvider(name = "loginDataTest", parallel = true)
	public static Object[][] loginTestdata(){
		return new Object[][] {
			//{"Admin" , "admin123"},
			{"admin", "1234"}
			
		};
		
	} 


}
