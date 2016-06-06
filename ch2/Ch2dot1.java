import java.util.Hashtable;


public class Ch2dot1 {
	public static linkedlist test;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test = new linkedlist();
		test.add("1");
		test.add("4");
		test.add("6");
		test.add("4");
		test.add("1");
		
		
		System.out.println("Test: " + test);
		test.removeDup();
		System.out.println("Test(RemoveDup): " + test);
		
		linkedlist test1 = new linkedlist();
		test1.add("1");
		test1.add("4");
		test1.add("6");
		test1.add("4");
		test1.add("1");
		
		System.out.println("Test1: " + test1);
		test1.removeDupNoBuffer();
		System.out.println("Test1(RemoveDupNoBuffer): " + test1);
		
		linkedlist test2 = new linkedlist();
		test2.add("1");
		test2.add("4");
		test2.add("6");
		test2.add("4");
		test2.add("1");
		test2.removeDupWithGC();
		System.out.println("Test2(RemoveDupNoBufferGC): " + test2);
		
		linkedlist test3 = new linkedlist();
		test3.add("1");
		test3.add("4");
		test3.add("6");
		test3.add("4");
		test3.add("1");
		test3.nToLast(2);
		System.out.println("Test3(nToLast): " + test3);
		
		linkedlist test4 = new linkedlist();
		test4.add("1");
		test4.add("4");
		test4.add("6");
		test4.add("4");
		test4.add("1");
		test4.nToLast2(2);
		System.out.println("Test4(nToLast2): " + test4);


	}// End of main
		
}// End of Ch2dot1
	
	//Create a linkedlist first
	class linkedlist{
		private int counter;
		private Node head;
		
		public linkedlist(){
			
		}
		
		public void add(Object data){
			if (head == null){
				head = new Node(data);
				//System.out.println("Head: " + head.getData());
			}
			
			//For those non-empty LinkedList
			Node curr = head;
			//System.out.println("Head: " + head.getData());
			Node tmp = new Node(data);
			
			if(curr != null){
				while (curr.getNext() != null){
					curr = curr.getNext();
				}
			}
			curr.setNext(tmp);
			incrementCounter();
		}// End of add(Object data)
		
		public int getCounter(){
			return counter;
		}
		
		public void incrementCounter(){
			counter++;
		}
		
		public void decrementCounter(){
			counter--;
		}
		
		public void add(Object data, int index){
			Node tmp = new Node(data);
			Node curr = head;
			
			if (curr != null){
				//We start at 1 since we set curr to be head and we got here since curr is not null. 
				// head locate at 0. so we can skip 0 for the for loop
				for (int i = 0; i<index && curr.getNext() != null; i++){
					curr = curr.getNext();
				}

			}
			tmp.setNext(curr.getNext().getNext());
			curr.setNext(tmp);
			incrementCounter();
		}
		
		public Object get(int index){
			if (index <= 0){
				return null;
			}
			
			Node curr = null;
			if(head != null){
				curr = head.getNext();
				for (int i = 0; i<index; i++){
					if (curr.getNext() == null){
						return null;
					}
					curr = curr.getNext();
				}// End of for loop
				return curr.getData();
				
			}// end of if
			
			//get to this if head == null
			return curr; //which will be null
		}// end of get
		
		// Remove node with given index
		public boolean remove(int index){
			if (index < 1 || index > size()){
				return false;
			}
			
			Node curr = head;
			if (head != null){
				for (int i=0; i<index; i++){
					if (curr.getNext() == null){
						return false;
					}
					
					curr = curr.getNext();
				}
				
				curr.setNext(curr.getNext().getNext());
				decrementCounter();
				return true;
			}
			
			//head == null
			return false;
		}//end of remove
		
		public int size(){
			return getCounter();
		}
		
		/*
		 * 2.1 Remove duplicates from unsorted linked list
		 */
		
		//Approach 1
		public void removeDup(){
			Hashtable table = new Hashtable();
			Node pre = null;
			
			if (head != null){
				Node curr = head.getNext();
			while (curr != null){
				if (table.containsKey(curr.getData())){
					//The node already exist in the table. We skip it
					pre.setNext(curr.getNext());
				}else{
					table.put(curr.getData(), true);
					pre = curr;
				}
				curr = curr.getNext();
			}
			}
			
		}// end of removeDup
		
		//Approach 2
		public void removeDupNoBuffer(){
			if (head == null){
				return;
			}
			
			Node pre = head.getNext();
			Node curr = pre.getNext();
			if (head != null){
				while(curr != null){
					Node runner = head;
					while (runner != curr){
						if (runner.getData() == curr.getData()){
							Node tmp = curr.getNext();
							pre.setNext(tmp);
							curr = tmp;							
							break;
						}
						runner = runner.getNext();
					}
					if (runner == curr){
						pre = curr;
						curr = curr.getNext();

					}
				}
			}
		}//End of removeDupNoBuffer
		
		//Approach 3
		public void removeDupWithGC(){
			if (head == null) return;
			
			Node ptr1 = null;
			Node ptr2 = null;
			Node dup = null;
			
			ptr1 = head.getNext();
			System.out.println("head: " + head.getData());
			System.out.println("head.getNext(); " + head.getNext().getData());
			
			//Pick element one by one
			while (ptr1 != null && ptr1.getNext() != null){
				//set up second pointer. They start off at the same place
				ptr2 = ptr1;
				// Increment pointer 2 while keeping pointer1. So that we can compare all the element of the linkedlist with pointer 1
				while (ptr2 != null && ptr2.getNext() != null){
					//If we find a match. Which means we find a duplicate
					if (ptr1.getData() == ptr2.getNext().getData()){
						//we want to delete what pointer 2 is pointing to
						dup = ptr2.getNext();
						ptr2.setNext(ptr2.getNext().getNext());
						
					}else{
						//else we havn't found a match yet. we incremenet the pointer2
						ptr2 = ptr2.getNext();
					}
				}
				//now we increment pointer1
				ptr1 = ptr1.getNext();
			}
		}// End of removeDupWithGC
		
		/*
		 * 2.2  Find the nth to last element of a singly linked list
		 */
		
		// Approach 1
		public void nToLast(int n){
			Node curr = head;
			for (int i=0; i<n; i++){
				curr = curr.getNext();
			}
			
			//at this point. curr is at index n-1
			head.setNext(curr.getNext());
		}
		
		// Approach 2: which I believe it is slower than my first approach
		public void nToLast2(int n){
			if (head == null || n<1) return;
			
			Node p1 = head;
			Node p2 = head;
			
			for (int j=0; j<n; ++j){
				if (p2 == null) return;
				
				p2 = p2.getNext();
			}
			
			while(p2.getNext() != null){
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
			
			head.setNext(p1);
		}
		
		public String toString(){
			String output = "";
			if (head!=null){
				Node curr = head.getNext();
				while (curr != null){
				output += curr.getData().toString() + " ";
				curr = curr.getNext();
				}
			}
			return output;
		}
		
		
		
		
		
		private class Node{
			Node next;
			Object data;
			
			public Node(Object dataVal){
				next = null;
				data = dataVal;
			}
			
			public Node(Object dataVal, Node next){
				next = next;
				data = dataVal;
			}
			
			public Object getData(){
				return data;
			}
			
			public void setData(Object dataVal){
				data = dataVal;
			}
			
			public Node getNext(){
				return next;
			}
			
			public void setNext(Node nextNode){
				next = nextNode;
			}
		}//End of node Class
	}//End of linkedlist class
	



