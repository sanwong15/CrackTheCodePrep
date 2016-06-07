package ch4;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Crqcking The Code Ch4.3
 * Given a sorted (increasing order) array,
 * write an algorithm to create a binary tree with minimal height.
 * 
 */

public class Ch4Dot3 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		int n = input.length;
		TreeNode rootNode = constructMinBT(input,0,n-1);
		preOrderPrint(rootNode);

	}
	
	public static TreeNode constructMinBT(int[] Array, int start, int end){
		if(start>end){
			return null;
		}
		
		int mp = (start+end)/2;
		
		TreeNode node = new TreeNode(Array[mp]);
		node.left = constructMinBT(Array,start,mp-1);
		node.right = constructMinBT(Array,mp+1,end);
		
		return node;
	}
	
	public static void preOrderPrint(TreeNode root){
		if(root==null) return;
		
		System.out.print(root.data + "  ");
		preOrderPrint(root.left);
		preOrderPrint(root.right);
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	Object data;
	
	
	public TreeNode(Object o){
		this.left = null;
		this.right = null;
		this.data = o;
	}

}