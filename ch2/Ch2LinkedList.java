
public class Ch2LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Node{
		int data;
		Node next = null;
		
		//Constructor
		public Node(int data){
			this.data = data;
		}
		
		void appendToTail(int d){
			Node end = new Node(d);
			Node n = this;
			while (n.next != null){
				n = n.next;
			}
			
			n.next = end;
		}
	}//End of Node Class
	
	//Delete a Node from a Singly LinkedList
	public static Node deleteNode(Node head, int d){
		Node n = head;
		if (n.data == d){
			return head.next; //You return head.next. When the main print out this linkedlist, it start at head.next so the original head is removed
		}
		
		while (n.next != null){
			if (n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

}
