package ch4;

import java.util.ArrayList;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * You are given a binary tree in which each node contains a value.
 *  Design an algorithm to print all paths which sum up to that value.
 *   Note that it can be any path in the tree - 
 *   it does not have to start at the root.
 *   
 *   					1
 *   			2				3
 *   	4			5		  6			7
 *   8		9	10	  11   12  13   14     15
 *   
 */

public class Ch4Dot8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 				5
		 * 			3		1
		 * 		4	  8	  2    6
		 *Sum: 8
		 *Path : 5-1-2
		 *		 5-3
		 *		 8
		 */
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		findAllPath(8, root, 0, new ArrayList<TreeNode>());
	}
	
	public static void findAllPath(int sum, TreeNode head, int level, ArrayList<TreeNode> buffer ){
		if(head == null) return;
		
		int temp = sum;
		buffer.add(head);
		for(int i = level; i>=0; i--){
			temp -= (int)buffer.get(i).data;
			if(temp == 0){
				print(buffer,i,level);
			}
		}
		
		ArrayList<TreeNode> c1 = (ArrayList<TreeNode>) buffer.clone();
		ArrayList<TreeNode> c2 = (ArrayList<TreeNode>) buffer.clone();
		findAllPath(sum,head.left,level+1,c1);
		findAllPath(sum,head.right,level+1,c2);
	}
	
	public static void print(ArrayList<TreeNode> buffer, int level, int j){
		for (int i = level; i<=j; i++){
			System.out.print(buffer.get(i).data + " ");
		}
		System.out.println();
	}

}
