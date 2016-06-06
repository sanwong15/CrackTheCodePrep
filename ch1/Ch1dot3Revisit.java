import java.util.*;

public class Ch1dot3Revisit {

	public static void main(String[] args){
		System.out.println("Please enter strings");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		//String to char array
		char[] charArray = input.toCharArray();
		
		//Define lib
		boolean[] charLib = new boolean[256];
		for (int i=0; i<256; i++){
			charLib[i] = false;
		}
		
		for (char element: charArray){
			int value = (int)element;
			if(charLib[value]==true){
				System.out.print("");
			}else{
				System.out.print(element);
				charLib[value]=true;
			}
			
		}
	}
}
