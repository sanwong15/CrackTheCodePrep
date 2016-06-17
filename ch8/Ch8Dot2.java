package ch8;

import java.util.ArrayList;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Imagine a robot sitting on the upper left hand corner of an NxN grid.
 * The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot?
 *   
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them.
 * Design an algorithm to get all possible paths for the robot.
 */

public class Ch8Dot2 {

	public static void main(String[] args) {
		/* Part 1: 
		 * row: x; col: y
		 * always have to move x-1 + y-1 steps in total
		 * you have x-1 times to pick a path out of x-1+y-1 choices.
		 * There are nCr numbers of path
		 */
		
		grid = randomMatrix(10,10,0,4);
		System.out.println("Print random Matrix");
		printMatrix(grid);
		Validpath(9,9);
		String s = convertList(currentPath);
		System.out.println("Print result");
		System.out.println(s);

	}
	
	public static int[][] grid = new int[10][10];
	
	public static int[][] randomMatrix(int M, int N, int min, int max){
		int[][] matrix = new int[M][N];
		for (int i=0; i<M; i++){
			for (int j=0; j<N; j++){
				matrix[i][j] = randomInRange(min,max);
			}
		}
		return matrix;
	}
	
	public static int randomInRange(int min, int max){
		return randomInt(max+1-min) + min;
	}
	
	public static int randomInt(int n){
		return (int)(Math.random()*n);
	}
	
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}				
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}					
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);				
			}
			System.out.println();
		}
	}
	
	public static ArrayList<Point> currentPath = new ArrayList<Point>();
	public static boolean Validpath(int xPosition,int yPosition){
		Point p = new Point(xPosition, yPosition);
		currentPath.add(p);
		
		if( xPosition == 0 && yPosition == 0){
			return true;
		}
		
		boolean success = false;
		
		if (xPosition >= 1 && isFree(xPosition-1, yPosition)){
			//If RIGHT is a valid move
			success = Validpath(xPosition-1,yPosition);
		}
		if(!success && yPosition>=1 && isFree(xPosition,yPosition-1)){
			//If DOWN is a valid move
			success = Validpath(xPosition, yPosition-1);
		}
		
		if(!success){
			currentPath.remove(p);
		}
		
		return success;
		
	}
	
	public static String convertList(ArrayList<Point> list) {
		StringBuilder buffer = new StringBuilder();
		for (Point p : list) {
			buffer.append("(" + p.x + "," + p.y + ")");
		}
		return buffer.toString();
	}
	
	//Function to check if the pixel is blocked
	public static boolean isFree(int x, int y){
		if(grid[x][y]==0){
			return false;
		}else{
			return true;
		}
	}


}

class Point{
	int x;
	int y;
	
	//Constructor
	public Point(int a, int b){
		this.x = a;
		this.y = b;
	}
}
