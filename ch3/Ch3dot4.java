/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Tower of Hanoi Question
 */
public class Ch3dot4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		Tower[] towers = new Tower[n];
		for(int i=0; i<3; i++){
			towers[i] = new Tower(i);
		}
		for(int i=n-1; i>=0; i--){
			towers[0].add(i);
		}
		
		System.out.println("Before moving: towers[0]");
		towers[0].print();
		
		towers[0].moveDisks(n, towers[2], towers[1]);
		
		System.out.println("Result: towers[2]");
		towers[2].print();

	}

}

/*  FOR REFERENCE -----------------------------
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
-------------------------------------------------
*/ 

//TOHStack is short for Tower of Hanoi Stack
class TOHStack{
	StackNode top;
	int size;
	//I am reusing the StackNode that I define back in Ch3dot3
	
	//Constructor
	public TOHStack(){
		top = null;
		size = 0;
	}
	
	public StackNode pop(){
		if(top!=null){
			Object item = top.getData();
			StackNode popNode = new StackNode(item);
			top.setNext(top.getNext());
			size--;
			return popNode;
		}
		return null;
	}
	
	public void push(Object item){
		StackNode newNode = new StackNode(item,top);
		//newNode.setNext(top);
		size++;
		top = newNode;
	}
	
	public int peek(){
		if (top!=null){
			return (int)top.getData();
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public int get(int i){
		int count = size-1;
		StackNode current = top;
		while (current.getNext() != null){
			//Bottom is refer to zero
			if(count == i){
				return (int)current.getData();
			}
			
			count--;
			
		}
		
		return -1;
	}
}

class Tower{
	private TOHStack disks;
	private int index;
	
	//Constructor
	public Tower(int i){
		disks = new TOHStack();
		index = i;
	}
	
	public int index(){
		return index;
	}
	
	public void add(int d){
		if(!disks.isEmpty() && disks.peek() <=d){
			System.out.println("Error Placing Disk " + d);
		}else{
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t){
		StackNode topNode = disks.pop();
		int top = (int) topNode.getData();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void print(){
		System.out.println("Contents of Tower " + index());
		for (int i=disks.size-1; i>=0;i--){
			System.out.println("   " + disks.get(i));
		}
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
}