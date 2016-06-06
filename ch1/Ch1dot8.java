/*
 * Assume you have a method isSubstring which checks if one word is a substring of another
 *  Given two strings,s1ands2,write code to check if s2 is a rotation of s1 using only one
 *  call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)
 */
public class Ch1dot8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		if (checkRotation(s1,s2)){
			System.out.println("checkRotation: True");
		}else{
			System.out.println("checkRotation: False");
		}

	}
	
	public static boolean checkRotation(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		
		if (len1 != len2){
			return false;
		}else{
			String s1Double = s1+s1;
			return s1Double.contains(s2);
		}
	}

}
