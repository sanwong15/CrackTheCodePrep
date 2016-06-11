package ch4;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * You have two very large binary trees: T1, with millions of nodes,
 *  and T2, with hundreds of nodes. 
 *  Create an algorithm to decide if T2 is a subtree of T1.
 */

public class Ch4Dot7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode Node1 = new TreeNode(1);
		TreeNode Node2 = new TreeNode(2);
		TreeNode Node3 = new TreeNode(3);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node5 = new TreeNode(5);
		TreeNode Node6 = new TreeNode(6);
		TreeNode Node7 = new TreeNode(7);
		TreeNode Node8 = new TreeNode(8);
		TreeNode Node9 = new TreeNode(9);
		TreeNode Node10 = new TreeNode(10);
		
		TreeNode Node11 = new TreeNode(11);
		TreeNode Node12 = new TreeNode(12);
		TreeNode Node13 = new TreeNode(13);
		TreeNode Node14 = new TreeNode(14);
		TreeNode Node15 = new TreeNode(15);
		TreeNode Node16 = new TreeNode(16);
		TreeNode Node17 = new TreeNode(17);
		TreeNode Node18 = new TreeNode(18);
		TreeNode Node19 = new TreeNode(19);
		TreeNode Node20 = new TreeNode(20);
		
		TreeNode Node21 = new TreeNode(21);
		TreeNode Node22 = new TreeNode(22);
		TreeNode Node23 = new TreeNode(23);
		TreeNode Node24 = new TreeNode(24);
		TreeNode Node25 = new TreeNode(25);
		
		Node1.setLeftChild(Node2);
		Node1.setRightChild(Node3);

		Node2.setLeftChild(Node4);
		Node2.setRightChild(Node5);
		
		Node3.setLeftChild(Node6);
		Node3.setRightChild(Node7);

		Node4.setLeftChild(Node8);
		Node4.setRightChild(Node9);

		Node5.setLeftChild(Node10);
		Node5.setRightChild(Node11);

		Node6.setLeftChild(Node12);
		Node6.setRightChild(Node13);

		Node7.setLeftChild(Node14);
		Node7.setRightChild(Node15);

		Node8.setLeftChild(Node16);
		Node8.setRightChild(Node17);

		Node9.setLeftChild(Node18);
		Node9.setRightChild(Node19);

		Node10.setLeftChild(Node20);
		Node10.setRightChild(Node21);
		
		Node11.setLeftChild(Node22);
		Node11.setRightChild(Node23);

		Node12.setLeftChild(Node24);
		Node12.setRightChild(Node25);
		
		//Just create another tree
		TreeNode Node26 = new TreeNode(26);
		TreeNode Node27 = new TreeNode(27);
		TreeNode Node28 = new TreeNode(28);
		
		Node26.setLeftChild(Node27);
		Node26.setRightChild(Node28);
		
		System.out.println("Node1 is the root node: t1 while Node6 is t2. Result: " + isSubTree(Node1,Node6));
		System.out.println("Node1 is the root node: t1 while Node26 is t2. Result: " + isSubTree(Node1,Node26));
		
		System.out.println("With an approach of traveling the whole tree: "+containTree(Node1, Node6));
		System.out.println("With an approach of traveling the whole tree: "+containTree(Node1, Node26));
	}

	public static boolean isSubTree(TreeNode t1, TreeNode t2){
		StringBuilder t1StringB = new StringBuilder();
		StringBuilder t2StringB = new StringBuilder();
		
		inOrderPrint(t1,t1StringB);
		inOrderPrint(t2,t2StringB);
		
		String t1String = t1StringB.toString();
		String t2String = t2StringB.toString();
		
		
		int t1Len = t1String.length();
		int t2Len = t2String.length();
		
		if(t1Len > t2Len){
			return t1String.contains(t2String);
		}else{
			return t2String.contains(t1String);
		}
	}
	
	public static void inOrderPrint(TreeNode root, StringBuilder sb){
		if(root == null) return;
		
		inOrderPrint(root.left,sb);
		//System.out.print(root.data + " ");
		sb.append(root.data);
		inOrderPrint(root.right,sb);
		
	}
	
	public static boolean containTree(TreeNode t1, TreeNode t2){
		if (t2 == null) return true;
		else return SubTree(t1,t2);
	}
	
	public static boolean SubTree(TreeNode t1, TreeNode t2){
		if(t1 == null) return false;
		
		if (t1.data == t2.data){
			if(matchTree(t1,t2)) return true;
		}
		
		return (SubTree(t1.left, t2) || SubTree(t1.right, t2));
	}
	
	public static boolean matchTree(TreeNode t1, TreeNode t2){
		if (t1 == null && t2 == null) return true;
		
		if (t1 == null || t2 == null) return false;
		
		if (t1.data != t2.data){
			return false;
		}else{
			return (matchTree(t1.left, t2.left) && matchTree(t1.right,t2.right));
		}
	}
}
