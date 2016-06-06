/*
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional bu er NOTE: One or two additional variables are  ne An extra copy of the array is not
SOLUTION
FOLLOW UP
Write the test cases for this method
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ch1dot3 {

	public static void main(String[] args) {
		System.out.println("Please enter the string that you would like to process");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String result = remove(str);
		System.out.println("test result: " +result);

	}
	
	
	public static String remove(String str){
		int len = str.length();
		//char[] data = str.toCharArray();
		//char[] dataCopy = new char[len];
		ArrayList<Character> dataCopy = new ArrayList<Character>();
		
		//Doesn't work
		/*
		for (int i=0; i<len; i++){
			//int j;
			if (data[i] == data[i+1]){
				
				System.out.println(1);
				//Shift to left
				dataCopy[i] = data[i+1];
			} else{
				dataCopy[i] = data[i];
			}
				
		}// End of For Loop
		*/
		
		//Assume it is like the first example with ASCII input
		boolean[] charTable = new boolean[256]; 
		Arrays.fill(charTable, false); //True implies it has been seen. While false means it is new
		for (int i=0; i<len; i++){
			int val = str.charAt(i);
			if (charTable[val] == false){
				char toAdd = str.charAt(i);
				dataCopy.add(toAdd);
				charTable[val] = true;
			} else { //This is the case that the char has been seen already
				
			}
			
		}
		StringBuilder result = new StringBuilder(dataCopy.size());
		for (Character c : dataCopy) {
		  result.append(c);
		} 
		String outputString = result.toString();
		return outputString;
	}

}
