package Extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentreportsClass {

	WebDriver driver;
	ExtentReports report;

	ExtentTest test;
	
	@BeforeTest
	void generatereport() {
		String path = "./ExtentReports/report.html";
		report = new ExtentReports(path);
		
	}
	
	
	@BeforeMethod
	void google() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	void report() {
		test = report.startTest("TestName");
		test.assignAuthor("lokesh");
		String expected = "Google";
		String actual = driver.getTitle();
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Passed");
			//method: log method store in logger object test object.
			test.log(LogStatus.PASS, "The title is matching :: TEST PASSED" + 
			"Expected :" + expected + "\nActual : " + actual);
		}else {
			System.out.println("Failed");
		}
		
	}
	@Test
	void fail() {
		test = report.startTest("FAIL TEST");
		test.assignAuthor("LOKESH");
		String expected = "Gooogle";
		String actual  = driver.getTitle();
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Passed");
			//method: log method store in logger object test object.
			test.log(LogStatus.PASS, "The title is matching :: TEST PASSED" + 
			"Expected :" + expected + "\nActual : " + actual);
		}else {
			test.log(LogStatus.FAIL, "The title is Not --- Matching :: TEST NOT PASSED" + 
					"Expected :" + expected + "\nActual : " + actual);
		}
	}
	
	@AfterMethod
	void teardown() throws IOException {
		
		report.endTest(test);
		
		report.flush();
		Desktop.getDesktop().browse(new File("/Users/harish/EclipseWorkspace/interviewqs/ExtentReports/report.html").toURI());
		driver.close();
		
	}
	
}
