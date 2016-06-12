package ch8;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Write a method to generate the nth Fibonacci number.
 * 1 1 2 3 5 8
 */

public class Ch8Dot1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1st number in Fibonacci: " + fibonacci(0));
		System.out.println("2nd number in Fibonacci: " + fibonacci(1));
		System.out.println("3rd number in Fibonacci: " + fibonacci(2));
		System.out.println("4th number in Fibonacci: " + fibonacci(3));
		System.out.println("5th number in Fibonacci: " + fibonacci(4));
		System.out.println("6th number in Fibonacci: " + fibonacci(5));
	}
	
	public static int fibonacci(int n){
		if (n == 0 || n ==1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
