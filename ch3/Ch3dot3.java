import java.util.ArrayList;

/*
San Wong
hswong1@uci.edu

Crack The Code 3.3

Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack
exceeds some threshold. 

(1) Implement a data structure SetOfStacks that mimics this. 
SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
(that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

public class Ch3dot3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Create a new 'SetOfStaacks' object with 5 elements added");
		SetOfStacks newSet = new SetOfStacks(5);
		newSet.push(1);
		newSet.push(2);
		newSet.push(3);
		newSet.push(4);
		newSet.push(5);
		
		System.out.println("current newSet size: " + newSet.getSize());
		System.out.println("Add the sixth element");
		
		newSet.push(6);
		System.out.println("current newSet size: " + newSet.getSize());
		
		System.out.println("Pop the sixth element: " + newSet.pop());
		System.out.println("current newSet size: " + newSet.getSize());
		
		newSet.push(6);
		newSet.push(7);
		newSet.push(8);
		newSet.push(9);
		newSet.push(10);
		newSet.push(11);
		newSet.push(12);
		newSet.push(13);
		newSet.push(14);
		newSet.push(15);
		
		System.out.println("Just add number 6 to 15");
		System.out.println("current newSet size: " + newSet.getSize());
		System.out.println("Try out pop1(0) and see what it return: " + newSet.pop1(0));
		System.out.println("Try out pop1(1) and see what it return: " + newSet.pop1(1));
		System.out.println("Try out pop1(2) and see what it return: " + newSet.pop1(2));
		System.out.println("current newSet size: " + newSet.getSize());
		System.out.println("The pop1 method allow stacks that is not at its full cap");

		System.out.println();
		System.out.println("Create a new set: anotherSet");
		SetOfStacks anotherSet = new SetOfStacks(5);
		System.out.println("Pushing element 1 - 30");
		anotherSet.push(1);
		anotherSet.push(2);
		anotherSet.push(3);
		anotherSet.push(4);
		anotherSet.push(5);
		
		anotherSet.push(6);
		anotherSet.push(7);
		anotherSet.push(8);
		anotherSet.push(9);
		anotherSet.push(10);
		
		anotherSet.push(11);
		anotherSet.push(12);
		anotherSet.push(13);
		anotherSet.push(14);
		anotherSet.push(15);
		
		anotherSet.push(16);
		anotherSet.push(17);
		anotherSet.push(18);
		anotherSet.push(19);
		anotherSet.push(20);
		
		anotherSet.push(21);
		anotherSet.push(22);
		anotherSet.push(23);
		anotherSet.push(24);
		anotherSet.push(25);
		
		anotherSet.push(26);
		anotherSet.push(27);
		anotherSet.push(28);
		anotherSet.push(29);
		anotherSet.push(30);
		System.out.println("current anotherSet size: " + anotherSet.getSize());

		System.out.println("Try out pop2(0) and see what it return: " + anotherSet.pop2(0));
		System.out.println("Try out pop2(1) and see what it return: " + anotherSet.pop2(1));
		System.out.println("Try out pop2(2) and see what it return: " + anotherSet.pop2(2));
		System.out.println("Try out pop2(3) and see what it return: " + anotherSet.pop2(3));
		System.out.println("Try out pop2(4) and see what it return: " + anotherSet.pop2(4));
		//System.out.println("Try out pop2(5) and see what it return: " + anotherSet.pop2(5));

		System.out.println("current anotherSet size: " + anotherSet.getSize());
	}

}

class Stack{
	private int cap;
	public StackNode top;
	public StackNode bottom;
	public int size = 0;
	
	public Stack(int capcity){
		this.cap = capcity;
	}
	
	public boolean isFull(){
		return cap == size;
	}
	
/*	
	//Solution suggest to have the join function.
	public void join(StackNode above, StackNode below){
		if(below!=null){
			below.above = above;
		}
		
		if(above!=null){
			above.below = below;
		}
	}
*/	
	
	public boolean push(int v){
		if(size>=cap){
			return false;
		}

		StackNode newStackNode = new StackNode(v);
		if (size == 0){
			top = newStackNode;
			bottom = newStackNode;
			size++;
		}else{
			newStackNode.setNext(top);
			top = newStackNode;
			size++;
		}
		
		return true;
	}
	
	public int pop(){
		int valToReturn = (Integer)top.getData();
		top = top.getNext();
		size--;
		return valToReturn;
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}
	
	public int peek(){
		return (Integer)top.getData();
	}
}


class SetOfStacks{
	public int capacity;
	public int setSize;
	
	public SetOfStacks(int capacity){
		this.capacity = capacity;
	}

	ArrayList<Stack> myList = new ArrayList<Stack>();
	
	public int getSize(){
		return setSize;
	}
	
	public Stack getLastStack(){
		if(myList.size() == 0) return null;
		
		return myList.get(myList.size()-1);
	}
	
	public void push(int d){
		Stack lastStack = getLastStack();
		if(lastStack != null && !lastStack.isFull()){
			lastStack.push(d);
		}else{
			Stack newStack = new Stack(capacity);
			newStack.push(d);
			myList.add(newStack);
			setSize++;
		}
	}
	
	public int pop(){
		Stack lastStack = getLastStack();
		System.out.println(myList.size());
		int valToReturn = lastStack.pop();
		
		if (lastStack.size == 0){
			myList.remove(myList.size()-1);
			setSize--;
		}
		
		return valToReturn;
	}
	
	public int pop1(int index){
		Stack returnStack = myList.get(index);
		int valToReturn = returnStack.pop();
		
		return valToReturn;
	}
	
	public int pop2(int index){
		
		Stack targetStack = myList.get(index);
		int valToReturn = targetStack.pop();

		//Fix the shifting
		for (int i=index; i<myList.size()-1; i++){
			//Search for bottom from next stack and fill it up to current stack
			Stack currentStack = myList.get(i);
			Stack nextStack = myList.get(i+1);
			StackNode currentNode = nextStack.top;
			StackNode preNode = currentNode;
			while(currentNode.getNext() != null){
				preNode = currentNode;
				currentNode = currentNode.getNext();
			}
			
			StackNode bottomNode = currentNode;
			int bottomVal = (Integer)bottomNode.getData();
			currentStack.push(bottomVal);
			preNode.setNext(null);
			nextStack.size--;
		}
		
		Stack lastStack = myList.get(myList.size()-1);
		if(lastStack.isEmpty()){
			myList.remove(myList.size()-1);
			setSize--;
		}
		return valToReturn;
	}
	

}

class StackNode{
	private Object data;
	private StackNode next;

	//Constructor 
	public StackNode(Object d){
		this.data = d;
		this.next = null;
	}
	
	public StackNode(Object d, StackNode n){
		this.data = d;
		this.next = n;
	}

	Object getData(){
		return data;
	}

	StackNode getNext(){
		return next;
	}

	void setData(Object d){
		data = d;
	}

	void setNext(StackNode Next){
		next = Next;
	}
}

