package Selenium.interviewqs;
import java.util.Scanner;
public class YourTestClass {
	public static boolean main(String[] args) {
		//to check is leap year
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Number");
		int year = sc.nextInt();
		if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }	
	}
}

