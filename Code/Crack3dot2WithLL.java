/*
San Wong
Crack The Code 3.2 (Including Stack implementation with LinkedList)

How would you design a stack which, in addition to push and pop,
also has a function min which returns the minimum element?
 Push, pop and min should all operate in O(1) time.

 Brainstorm: when adding new element to the stack. Keep track to the min value
 when a new min is found. Make sure pushing the old min value
*/

public class LinkedListStack implements Stack{
	private Node top;
	private int size;
	private int GobalMin;
	

	//Set up empty list
	public LinkedListStack(){
		top = null;
		size = 0;
		GobalMin = 0;
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}

	public int peek(){
		return (Integer)top.getData();
	}

	//Using Object GobalMin to keep track with min val
	public void push(int element){
		Node newElement = new Node(element, null);

		if (element < GobalMin || GobalMin == 0){
			Node minBackUp = new Node(GobalMin, null);
			minBackUp.setNext(top);
			top = minBackUp;
			GobalMin = element;
		}

		newElement.setNext(top);
		top = newElement;
		size++;
	}

	public int pop(){
		int valToReturn;
		if ((Integer)top.getData() == GobalMin){
			valToReturn = (Integer)top.getData();
			top.setData(top.getNext().getData());
			top.setNext(top.getNext().getNext());
			//At this point. Our top should be referring to the previous min on the stack.
			// Time to update our GobalMin
			GobalMin = (Integer)top.getData();
			//Once we have update the GobalMin, we have no use of the top value of the stack. So we can pop it
			// Update the correct top
			top.setData(top.getNext().getData());
			top.setNext(top.getNext().getNext());
		}else{
			valToReturn = (Integer)top.getData();
			top.setData(top.getNext().getData());
			top.setNext(top.getNext().getNext());
		}
		
		size--;
		return valToReturn;

	}

	public int min(){
		return GobalMin;
	}

}

public class Node{
	private Object data;
	private Node next;

	//Constructor
	public Node(){
		data = null;
		next = null;
	}

	public Node(Object o, Node n){
		this.data = o;
		this.next = n;
	}

	Object getData(){
		return data;
	}

	Node getNext(){
		return next;
	}

	void setData(Object d){
		data = d;
	}

	void setNext (Node Next){
		next = Next;
	}
}