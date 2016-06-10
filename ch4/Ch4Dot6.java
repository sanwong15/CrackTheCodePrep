package ch4;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Design an algorithm and write code to find the first common ancestor
 *  of two nodes in a binary tree. Avoid storing additional nodes
 *   in a data structure. NOTE: This is not necessarily a binary search tree.
 */

public class Ch4Dot6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 				20
		 * 			8			22
		 * 		4		12
		 * 			10		14
		 */
		TreeNode Node1 = new TreeNode(20);
		TreeNode Node2 = new TreeNode(8);
		TreeNode Node3 = new TreeNode(22);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node5 = new TreeNode(12);
		TreeNode Node6 = new TreeNode(10);
		TreeNode Node7 = new TreeNode(14);
		
		Node1.setLeftChild(Node2);
		Node1.setRightChild(Node3);
		Node2.setLeftChild(Node4);
		Node2.setRightChild(Node5);
		Node5.setLeftChild(Node6);
		Node5.setRightChild(Node7);
		
		TreeNode result = FirstCommonAncestor(Node1, Node6, Node3);
		
		System.out.println("First COmmon Ancestor of Node 6 and Node 3: " +  result.data);

	}
	
	//Same as LCA
	public static TreeNode FirstCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
		if(root == null || a == null || b == null) return null;
		
		if (a == root || b == root) return root;
		
		TreeNode L = FirstCommonAncestor(root.left, a,b);
		TreeNode R = FirstCommonAncestor(root.right,a,b);
		
		if (L!=null && R!=null) return root;
		
		if (L == null){
			return R;
		}else{
			return L;
		}
		
	}

}
