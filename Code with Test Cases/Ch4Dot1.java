/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Implement a function to check if a tree is balanced.
 * Balanced tree: A tree such that  no two leaf nodes diff in distance
 * from the root by more than one
 */
public class Ch4Dot1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Construct a random binary tree
		TreeNode rootA = new TreeNode(8);
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode ten = new TreeNode(10);
		TreeNode fourteen = new TreeNode(14);
		TreeNode thirdteen = new TreeNode(13);
		
		rootA.left = three;
		rootA.right = ten;
		three.left = one;
		three.right = six;
		six.left = four;
		six.right = seven;
		ten.right = fourteen;
		fourteen.left = thirdteen;
		
		System.out.println("isBalaned? : " + isBalanced(rootA));

	}
	
	public static int maxDepth(TreeNode root){
		if (root == null) return 0;
		
		return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public static int minDepth(TreeNode root){
		if (root == null) return 0;
		
		return 1+ Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	public static boolean isBalanced(TreeNode root){
		return (maxDepth(root) - minDepth(root) <=1);
	}

}

class TreeNode{
	TreeNode left;
	TreeNode right;
	Object data;
	
	
	public TreeNode(Object o){
		this.left = null;
		this.right = null;
		this.data = o;
	}
	
}

