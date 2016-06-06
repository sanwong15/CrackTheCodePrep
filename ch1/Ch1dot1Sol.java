/*
 * Note: Time Complexity is O(n) where n is the length of the string.
 * Space complexity is also O(n)
 */




import java.util.Scanner;

public class Ch1dot1Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the string that you would like to test");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		boolean result = isUniqueChars2(str);
		System.out.println(result);

	}
	
	public static boolean isUniqueChars2(String str){
		boolean[] char_set = new boolean[256];
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			// when we represent charAt as an integer. it turns into ASCII value
			System.out.println("Print out the val for char: " + val);
			/*
			 * Mistake that I made here: I forgot to change the boolean value in the array
			if(char_set[val]==true){
				//char_set[val]==true means that value has already shown up
				System.out.println("Test result: false");
				return false;
			}else{
				System.out.println("Test result: true");
				return true;
			}// End of if-else
			*/
			
			//Instruction note
			if(char_set[val]) return false;
			char_set[val] = true;
			
		}// End of For loop
		return true;
	}//End of isUniqueChars2 method

}
