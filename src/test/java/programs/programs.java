package programs;

import java.util.*;

public class programs {

    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Enter numer :: ");
    	int num = sc.nextInt();
    	
    	sc.close();
    	
    	int reversed = 0 ;
    	while(num != 0 ) {
    		int digit= num % 10;
    		reversed = reversed * 10 + digit;
    		num/= 10;
    		
    	}
    	
    	if(num == reversed) {
    		System.out.println("Given Number is Palindrome");
    	}else {
    		System.out.println("Given Number is Not Palindrome");
    	}
    }

}


