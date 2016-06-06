import java.util.Scanner;

/*
 * Alt solution: Take O(n^2) run time but no space.
 * It is the same concept as my first implementation.
 */
public class Ch1dot1AltSol1 {

	public static void main(String[] args) {
		
		System.out.println("Please enter the string that you would like to test");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//Convert to lower case
		str = str.toLowerCase();
		
		boolean result = isUniqueChars2(str);
		System.out.println("test result: " +result);
		

	}
	
	public static boolean isUniqueChars2(String str){
		int repCounter =0;
		int counter =0;
		for (int i=0; i<str.length(); i++){
			for (int j=0; j<str.length();j++){
				//System.out.println(i);
				//System.out.println(j);
				if(i != j){
					if (str.charAt(i) == str.charAt(j)){
						repCounter++;
						System.out.println("Collision occured");
					}
					else counter++;
					System.out.println("It still seems unique");
				}// End of while
			}// End of j for loop
		}// End of i for loop
		
		if (repCounter ==0) return true;
		else return false;
	}

}
