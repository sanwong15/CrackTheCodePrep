//Implement an algorithm to determine if a string has all unique characters
// What if you can not use additional data structures?
import java.util.Scanner;


public class Ch1dot1 {

	public static void main(String[] args) {
		System.out.println("Please enter the string that you would like to test");
		Scanner sc = new Scanner(System.in);
		String stringToTest = sc.nextLine();
		stringToTest = stringToTest.toLowerCase();
		
		int len = stringToTest.length();
		
		for(int i=0; i<len;i++){
			for (int j=0; j<len; j++){
				if (i!=j && stringToTest.charAt(i)==stringToTest.charAt(j))
					System.out.println("false");
				else
					System.out.println("true");
			}
		}

	}

}
