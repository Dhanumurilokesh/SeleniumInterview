package SeleniuCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class alertoperations {
	
	
	WebDriver driver = new ChromeDriver();;
	Properties pro = new Properties();
	
	
		
		
	@Test(priority =0)
	public void setUp() throws IOException {
		//load file 
			FileInputStream alertfile = new FileInputStream("Alert.properties");
			
			//load porperty file
			pro.load(alertfile);
			
			
			Dimension d = new Dimension(1000,1000);
			driver.manage().window().setSize(d);
			driver.get(pro.getProperty("url"));
			
		}
		
	@Test(priority = 1)
	public void simpleAlert() throws InterruptedException {
		
	
		
		WebElement simplealert = driver.findElement(By.xpath(pro.getProperty("salert")));
		simplealert.click();
		Thread.sleep(3000);
		
		WebElement box = driver.findElement(By.xpath(pro.getProperty("slink")));
		box.click();
		Thread.sleep(3000);
		
		//alert class
		Alert al = driver.switchTo().alert();
		System.out.println("simple alert test is :: " + al.getText() );
		al.accept();
		
		
	}
	
	@Test(priority =2)
	public void confirmAlert() throws InterruptedException {
		
		
		WebElement confirmalert = driver.findElement(By.xpath(pro.getProperty("confirmAlert")));
		confirmalert.click();
		Thread.sleep(3000);
		
		WebElement box = driver.findElement(By.xpath(pro.getProperty("confirmlink")));
		box.click();
		Thread.sleep(3000);
		//alert class
		Alert al2 = driver.switchTo().alert();
		System.out.println("confirm alert test is :: " + al2.getText() );
		al2.accept();
		
	}
	
	@Test(priority = 3)
	public void promptAlert() throws InterruptedException {
		
		String promptAlert = pro.getProperty("promptAlert");
		String promptlink = pro.getProperty("promtlink");
		
		WebElement promptlert = driver.findElement(By.xpath(promptAlert));
		promptlert.click();
		Thread.sleep(3000);
		
		WebElement box = driver.findElement(By.linkText(promptlink));
		box.click();
		Thread.sleep(3000);
		
		//alert class
		Alert al = driver.switchTo().alert();
		System.out.println("prompt alert test is :: " + al.getText() );
		al.sendKeys("hi");
		al.accept();
		
	}
	
	
	
		
		
	

}
