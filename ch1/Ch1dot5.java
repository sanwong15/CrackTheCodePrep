import java.util.*;

public class Ch1dot5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a string");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int len = input.length();
		
		for (int i=0; i<len; i++){
			if(input.charAt(i)==32)
				System.out.print("%20.");
			else
				System.out.print(input.charAt(i));
		}

	}

}
