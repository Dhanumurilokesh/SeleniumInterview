package Selenium.interviewqs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StringBufferr {
    
	@Test(dataProvider = " login")
	public void TestLogin(String userName, String password) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		//website:
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
				
		//Username
		WebElement username = driver.findElement(By.xpath("//input[@name ='username']"));
		username.sendKeys(userName);
		Thread.sleep(5000);


		//Password
		WebElement passWord = driver.findElement(By.xpath("//input[@name = 'password']"));
		passWord.sendKeys(password);
		Thread.sleep(5000);


		//login button
		WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
		Thread.sleep(5000);
				
		//Welcome element to check passed or not
		WebElement welcome = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		AssertJUnit.assertTrue(welcome.isDisplayed());
		Thread.sleep(5000);
		driver.quit();

		
		
	}
	
	@DataProvider(name = " login" , parallel =true)
	public Object[][] loginData() {
		Object[][] data = new Object[][] {	
			{"Admin","admin123"}, 
			{"Admin","admin121"}
		
		};	
		return data;
	}
	

}
	
		




