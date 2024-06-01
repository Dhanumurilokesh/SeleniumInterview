package Selenium.interviewqs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.Test;

public class ActionClass {
	
	static WebDriver driver = new ChromeDriver();
	public static void main(String[] args) {
		
		ActionClass call = new ActionClass();
		call.AmazonSearch();
		
		
	}
	 
	

	public void mouseOperations() {
		String baseUrl = "http://www.facebook.com/";
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT) //keyDown is for holding
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT) //keyUp is releasing 
			.doubleClick(txtUsername) 
			.contextClick() 
			//contextClick() simulates a right-click action, also known as a context click. 
			.build();
			
		seriesOfActions.perform() ;

	}
	
	
	public void AmazonSearch() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement sbox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		sbox.sendKeys("Tables",Keys.ENTER);
		WebElement searchbutton = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		searchbutton.click();

		
		
	}
}
