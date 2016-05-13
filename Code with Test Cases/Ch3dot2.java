import java.util.Stack;

public class Ch3dot2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack testingStack = new MyStack();
		System.out.println("Push 13");
		testingStack.push(13);
		System.out.println("min " + testingStack.min());
		System.out.println("Push 43");
		testingStack.push(43);
		System.out.println("min " + testingStack.min());
		System.out.println("Push 58");
		testingStack.push(58);
		System.out.println("min " + testingStack.min());
		System.out.println("Push 61");
		testingStack.push(61);
		System.out.println("min " + testingStack.min());
		System.out.println("Push 4");
		testingStack.push(4);
		System.out.println("min " + testingStack.min());
		System.out.println("Pop");
		testingStack.pop();
		System.out.println("min " + testingStack.min());
		System.out.println("Pop again");
		testingStack.pop();
		System.out.println("min " + testingStack.min());
		

	}
	
	
	

}

class MyStack{
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
		if (newStack.peek().equals(GobalMin)){
			valToReturn = (int) newStack.pop();
			GobalMin = (int) newStack.pop();
		}else{
			valToReturn = (int) newStack.pop();
		}
		return valToReturn;
	}

	public int min(){
		return GobalMin;
	}
}
