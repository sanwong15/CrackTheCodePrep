import java.util.Stack;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Implement a Queue with 2 stacks
 */
public class Ch3Dot5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue newQueue = new MyQueue();
		newQueue.enQueue(1);
		newQueue.enQueue(2);
		newQueue.enQueue(3);
		newQueue.enQueue(4);
		newQueue.enQueue(5);
		
		System.out.println("Let's dequeu the whole MyQueue");
		System.out.println(newQueue.deQueue());
		System.out.println(newQueue.deQueue());
		System.out.println(newQueue.deQueue());
		System.out.println(newQueue.deQueue());
		System.out.println(newQueue.deQueue());
	}

}

class MyQueue{
	Stack st1;
	Stack st2;
	
	public MyQueue(){
		st1 = new Stack();
		st2 = new Stack();
	}
	
	public void enQueue(int d){
		st1.push(d);
	}
	
	public int deQueue(){
		
		int valToReturn;
		
		while(!st1.empty()){
			int temp = (int) st1.pop();
			st2.push(temp);
		}
		
		valToReturn = (int) st2.pop();
		
		
		while(!st2.empty()){
			int temp1 = (int) st2.pop();
			st1.push(temp1);
		}
		
		return valToReturn;
	}
}
