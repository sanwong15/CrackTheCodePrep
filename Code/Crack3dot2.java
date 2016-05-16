/*
San Wong
Crack The Code 3.2

How would you design a stack which, in addition to push and pop,
also has a function min which returns the minimum element?
 Push, pop and min should all operate in O(1) time.

 Brainstorm: when adding new element to the stack. Keep track to the min value
 when a new min is found. Make sure pushing the old min value
*/

public class MyStack{
	//Gobal min val
	int GobalMin = 0;
	Stack newStack = new Stack();

	//Constructor
	public void MyStack(){
		
	}
	
	public void push(int val){
		if (val < GobalMin || GobalMin == 0){
			newStack.push(GobalMin);
			GobalMin = val;
		}
		newStack.push(val);

	}

	public int pop(){
		int valToReturn;
		if (newStack.peek() == GobalMin){
			valToReturn = newStack.pop();
			GobalMin = newStack.pop();
		}else{
			valToReturn = newStack.pop();
		}
		return valToReturn;
	}

	/%
	public int pop(){
			int valToReturn;
			if (newStack.peek().equals(GobalMin)){
				valToReturn = (int) newStack.pop();
				GobalMin = (int) newStack.pop();
			}else{
				valToReturn = (int) newStack.pop();
			}
			return valToReturn;
		}
	%/

	public int min(){
		return GobalMin;
	}
}
