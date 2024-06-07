package primus;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.*;

public class login {
	
	WebDriver driver;
	Properties property = new Properties();
	
	
	
	@BeforeTest
	public void setup() throws FileNotFoundException, IOException {
		//Store property file into java file class
		FileInputStream propertyfile = new FileInputStream("Primus.properties");
		
		//load property into property object
		property.load(propertyfile);
		
		//launch
		driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
	}

	@Test
	public void loginTest() throws InterruptedException {
		
		//username
		WebElement username = driver.findElement(By.xpath(property.getProperty("objuser")));
		username.click();
		username.sendKeys("Admin");
		Thread.sleep(3000);
		
		//password
		WebElement password = driver.findElement(By.xpath(property.getProperty("objpass")));
		password.click();
		password.sendKeys("Admin");
		Thread.sleep(3000);
		
		//click login button
		WebElement loginbutton = driver.findElement(By.xpath(property.getProperty("objlogin")));
		loginbutton.click();
		Thread.sleep(3000);
		
	}
	@Test(dependsOnMethods =  {"loginTest"})
	public void branchCreation() throws InterruptedException {
		
		Thread.sleep(10000);
		//objbranch
		driver.findElement(By.xpath(property.getProperty("objbranch"))).click();
		Thread.sleep(3000);
		
		//objnewbranch
		driver.findElement(By.xpath(property.getProperty("objnewbranch"))).click();
		Thread.sleep(3000);
		
		//objbranchname
		WebElement branchname = driver.findElement(By.xpath(property.getProperty("objbranchname")));
		
		branchname.click();
		branchname.sendKeys("hyderabadold");
		Thread.sleep(3000);
		
		//objaddres1
		WebElement address1 = driver.findElement(By.xpath(property.getProperty("objaddres1")));
		address1.click();
		address1.sendKeys("rajamahal area");
		Thread.sleep(3000);
		
		//objaddress2
		WebElement address2 = driver.findElement(By.xpath(property.getProperty("objaddress2")));
		address2.click();
		address2.sendKeys("area2");
		Thread.sleep(3000);
		
		//objaddress3
		WebElement address3 = driver.findElement(By.xpath(property.getProperty("objaddress3")));
		address3.click();
		address3.sendKeys("area3");
		Thread.sleep(3000);
		
		
		//objarea
		WebElement area = driver.findElement(By.xpath(property.getProperty("objarea")));
		area.click();
		area.sendKeys("area3");
		Thread.sleep(3000);
		
		//objzip
		WebElement zipcode = driver.findElement(By.xpath(property.getProperty("objzip")));
		zipcode.click();
		zipcode.sendKeys("507115");
		Thread.sleep(3000);
		
		//objcountry
		WebElement country = driver.findElement(By.xpath(property.getProperty("objcountry")));
		Select countryselect = new Select(country);
		countryselect.selectByIndex(2);
		Thread.sleep(3000);
		
		//objstate
		WebElement state = driver.findElement(By.xpath(property.getProperty("objstate")));
		Select stateselect = new Select(state);
		stateselect.selectByIndex(2);
		
		//objcity
		WebElement city = driver.findElement(By.xpath(property.getProperty("objcity")));
		Select cityselect = new Select(city);
		cityselect.selectByIndex(2);
		Thread.sleep(3000);
		
		//objsubmit
		WebElement submit = driver.findElement(By.xpath(property.getProperty("objsubmit")));
		submit.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);//true use this to print to my console output also.
		alert.accept();
		
	}
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(30000);
		driver.close();
		
	} 
	
	
}
