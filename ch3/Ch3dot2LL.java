
public class Ch3dot2LL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack testingStack = new LinkedListStack();
		System.out.println("Push 13");
		testingStack.push(13);
		System.out.println("Peek at the stack: " + testingStack.peek());
		System.out.println("min " + testingStack.min());
		System.out.println("Push 43");
		System.out.println("Peek at the stack: " + testingStack.peek());
		testingStack.push(43);
		System.out.println("min " + testingStack.min());
		System.out.println("Push 58");
		testingStack.push(58);
		System.out.println("Peek at the stack: " + testingStack.peek());
		System.out.println("min " + testingStack.min());
		System.out.println("Push 61");
		testingStack.push(61);
		System.out.println("Peek at the stack: " + testingStack.peek());
		System.out.println("min " + testingStack.min());
		System.out.println("Push 4");
		testingStack.push(4);
		System.out.println("Peek at the stack: " + testingStack.peek());
		System.out.println("min " + testingStack.min());
		System.out.println("Pop: " + testingStack.pop());
		System.out.println("Peek at the stack after we pop once: " + testingStack.peek());
		System.out.println("min " + testingStack.min());
		System.out.println("Pop again");
		System.out.println("Peek at the stack after we pop again: " + testingStack.peek());
		System.out.println("Pop: " + testingStack.pop());
		System.out.println("min " + testingStack.min());
		System.out.println("Pop the third time");
		System.out.println("Peek at the stack after we pop the third time: " + testingStack.peek());
		System.out.println("Pop: " + testingStack.pop());
		System.out.println("min " + testingStack.min());
		System.out.println("Pop the forth time");
		System.out.println("Peek at the stack after we pop the forth time: " + testingStack.peek());
		System.out.println("Pop: " + testingStack.pop());
		System.out.println("min " + testingStack.min());
	}

}

class LinkedListStack{
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

class Node{
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