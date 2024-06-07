package orangeHRM;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginFunctionality {
	//ORANGE HRM LOGIN FUNCTIONALITY
	//extent reports 
	//testng
	//object repository
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	static String path = "./ExtentReports/OrangeHRMLoginTest_Case.html";

	
	//properties file load
	
	Properties property = new Properties();
	
	@BeforeTest
	void extentreportgenerate() throws IOException {
		//extent report loaded.
		report = new ExtentReports(path);	
		
		//properties file loaded
		FileReader reader = new FileReader("ORangeHRM.properties");
		property.load(reader);
		driver = new ChromeDriver();
		Dimension d = new Dimension(1000,1000);
		
		driver.manage().window().setSize(d);
		
		//getting website from property file.
		driver.get(property.getProperty("url"));
		
	}
	
	//org.testng.annotations.DataProvider;
	@DataProvider
	public Object[][] logindata() {
		Object[][] data = new Object[][] {
			{"Admin" , "Qedge123!@#"},
			{"Admin " , " admin"},
			{" ", " "}
			
		};
		return data;
	}
	
	// org.testng.annotations.Test;
	@Test(dataProvider = "logindata")
	public void loginTest(String userName , String password) throws Throwable {
		
		//username 
		WebElement user = driver.findElement(By.xpath(property.getProperty("objusername")));
		user.sendKeys(userName);
		Thread.sleep(3000);

		//password
		WebElement  pass = driver.findElement(By.xpath(property.getProperty("objpassword")));
		pass.sendKeys(password);
		Thread.sleep(3000);
		
		//loginbutton
		WebElement login = driver.findElement(By.xpath(property.getProperty("objlogin")));
		login.click();
		Thread.sleep(3000);
		
		//welcom elelment
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property.getProperty("objwelcome"))));
		
		if(welcome.isDisplayed()) {
			
			String screenshotPath = screenshot(driver, "./Screenshots/OrangeHRm_LoginVerifyScreen.png");
			test = report.startTest("ORANGEHRM_LoginTest");
			test.log(LogStatus.PASS, test.addScreenCapture(screenshotPath));
			test.assignAuthor("AUTHOR : LOKESH");
			test.setDescription("THis is orangehrm login test WITH VALID CREDENTIALS");
			
			
		}else {
			
			String screenshotPath = screenshot(driver, "./Screenshots/OrangeHRm_InValidLoginScreenShot.png");
			test = report.startTest("ORANGEHRM_LoginTest");
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			test.assignAuthor("AUTHOR : LOKESH");
			test.setDescription("THis is orangehrm login test With InValid credentials");
			
		}
		
	}//login test
	
	public String screenshot(WebDriver driver , String fileoutpath) throws Throwable {
		//import org.openqa.selenium.OutputType;
		//import org.openqa.selenium.TakesScreenshot;
		  TakesScreenshot screenshot = (TakesScreenshot) driver;
		  File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		  //Destination file 
		  File destfile = new File(fileoutpath);
		  
		  //copy file
		  FileUtils.copyFile(srcFile, destfile);
		  
		  return destfile.getAbsolutePath();
	}//screenshot method
	
	
	@AfterTest
	void teardown() throws IOException {
		
		 report.flush();
		 driver.quit();
		 File htmlFile = new File(path);
	     Desktop.getDesktop().browse(htmlFile.toURI());
		
		
	}
	
	
	

}
