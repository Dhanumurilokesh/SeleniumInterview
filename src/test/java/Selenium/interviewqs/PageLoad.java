package Selenium.interviewqs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageLoad {
	
	@Test(timeOut = 15000)
	public void loadpage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Dimension d = new Dimension(500, 500);
		driver.manage().window().setSize(d);
		
		long start = System.currentTimeMillis();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		long end = System.currentTimeMillis();
		long pageLoadTime = end - start;
		System.out.println(pageLoadTime);
		driver.quit();

	}

}
