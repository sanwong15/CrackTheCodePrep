// No additional memory. Time O(n^2)

import java.util.Scanner;

public class Ch1dot3Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the string that you would like to process");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		int len = inputString.length();
		char[] str = new char[len];
		for (int i=0; i<len; i++){
			str[i] = inputString.charAt(i);
		}
		//System.out.println("char array" + str);
		removeDuplicates(str);
	}
	
	public static void removeDuplicates(char[] str){
		if (str == null) return;
		int len = str.length;
		if (len<2) return;
		
		int tail = 1;
		
		for (int i=1; i<len; i++){
			int j;
			for (j=0; j<tail; j++){
				if(str[i] == str[j]) break;
			}
			if (j==tail){
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] =0;
	}


}
