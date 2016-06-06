/*
 * Check anagram
 * Two strings are called anagrams if they contain same set of characters but in different order
 */
import java.util.*;

public class Ch1dot4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two strings to compare sepearated by 'Enter'.");
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int temp=0;
		
		int[] lib1 = new int[256];
		int[] lib2 = new int[256];
		
		int len1 = s1.length();
		int len2 = s2.length();
		
		if (len1 != len2){
			System.out.println("Diff Length: Not anagram");
		}else {
			for(int i=0; i<len1; i++){
				lib1[s1.charAt(i)]++;
			}
			
			for(int i=0; i<len2; i++){
				lib2[s2.charAt(i)]++;
			}
			

			for (int i=0; i<256; i++){
				if (lib1[i] == lib2[i]){
					temp += lib1[i];
				}
			}
			
			if(temp == len1) System.out.println("Yes, they are anagram");
			else System.out.println("No, they are not anagram");
		}

	}

}
