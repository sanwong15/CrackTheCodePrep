package ch4;

import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Cracking The Code Ch4.4
 * Given a binary search tree, design an algorithm which 
 * creates a linked list of all the nodes at each depth 
 * (i.e., if you have a tree with depth D, you’ll have D linked lists).
 */

public class Ch4Dot4 {

	public static void main(String[] args) {
		// Constructor a tree
		TreeNode A = new TreeNode('a');
		TreeNode B = new TreeNode('b');
		TreeNode C = new TreeNode('c');
		TreeNode D = new TreeNode('d');
		TreeNode E = new TreeNode('e');
		TreeNode F = new TreeNode('f');
		TreeNode G = new TreeNode('g');
				
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		
		ArrayList<LinkedList<TreeNode>> result = bfsLL(A);
		System.out.println("Print the tree by level");
		printArrayList(result);
		
		System.out.println();
		System.out.println("Print by level, Level = 1");
		printByLevel(result,1);

	}
	
	//BFS
	public static ArrayList<LinkedList<TreeNode>> bfsLL(TreeNode root){
		int level = 0;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	
		list.add(root);
		result.add(level,list);
		
		while(true){
			list = new LinkedList<TreeNode>();
			for(int i=0; i<result.get(level).size();i++){
				TreeNode n = (TreeNode) result.get(level).get(i);
				if(n!=null){
					if(n.left!=null) list.add(n.left);
					if(n.right!=null) list.add(n.right);
				}
			}
			
			if(list.size() > 0){
				result.add(level+1, list);
			}else{
				break;
			}
			
			level++;
		}
		return result;
	}
	
	public static void printArrayList(ArrayList<LinkedList<TreeNode>> alist){
		for(int i=0; i<alist.size(); i++){
			LinkedList<TreeNode> list = alist.get(i);
			for(int j=0; j<list.size(); j++){
				System.out.print(list.get(j).data+ "  ");
			}
			System.out.println();
			
		}
	}
	
	public static void printByLevel(ArrayList<LinkedList<TreeNode>> alist, int level){
		LinkedList<TreeNode> target = alist.get(level);
		for(int j=0; j<target.size(); j++){
			System.out.print(target.get(j).data+ "  ");
		}
	}


}
