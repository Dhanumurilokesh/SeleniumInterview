package Selenium.interviewqs;

import org.testng.annotations.Test;

public class ParallelTest2 {
	@Test
	public void M1() {
		System.out.println("C2 > M1"+ " Tid :: " + Thread.currentThread().getId());
		
	}
	@Test
	public void M2() {
		System.out.println("C2 > M2"+ " Tid :: "+Thread.currentThread().getId());
		
	}
	@Test
	public void M3() {
		System.out.println("C2 > M3"+ " Tid :: " + Thread.currentThread().getId());
		
	}
	

}
