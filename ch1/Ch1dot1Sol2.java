/*
 * Reduce space complexity with bit vector
 *
 */

import java.util.Scanner;

public class Ch1dot1Sol2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the string that you would like to test");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//Convert to lower case
		str = str.toLowerCase();
		
		boolean result = isUniqueChars2(str);
		System.out.println(result);

	}
	
	public static boolean isUniqueChars2(String str){
		int checker=0;
		for (int i=0; i<str.length();i++){
			int val = str.charAt(i)-'a';
			System.out.println("val: "+val);
			System.out.println("checker: "+ checker);
			System.out.println("1<<val: "+ (1<<val));
			if((checker&(1<<val))>0) return false; //bitwise & (pretty much compare the checker and the value generate by (1<<val). Each character has its own (1<<val)
			checker |= (1<< val); //At its first run, checker is zero so it get update here.
			/*
			 *  << menans left shift
			 *  Example: A = 60 =>0b111100
			 *  A<<2 : left shift by 2 digit: 11110000. 0b got shifted away, the rest of the digit
			 *  got padded with zeros. The new value after shifiting means 240
			 *  
			 *  | is the bitwise OR
			 *  Example: A = 60  =>0b11 1100
			 *  		 B = 13  =>000b 1101
			 *  (A | B) will give 61 which is 0011 1101
			 *  So I believe b or anything isn't 1 would be consider as ZEROS
			 */
		
		}
		return true;
		
	}

}
