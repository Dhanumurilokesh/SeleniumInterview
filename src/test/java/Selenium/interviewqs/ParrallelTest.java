package Selenium.interviewqs;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class ParrallelTest {
	
	@Test
	public void M1() {
		System.out.println("C1 > M1"+ " Tid :: " + Thread.currentThread().getId());
		
	}
	@Test
	public void M2() {
		System.out.println("C1 > M2"+ " Tid :: "+Thread.currentThread().getId());
		
	}
	@Test
	public void M3() {
		System.out.println("C1 > M3"+ " Tid :: " + Thread.currentThread().getId());
		
	}
	

}
