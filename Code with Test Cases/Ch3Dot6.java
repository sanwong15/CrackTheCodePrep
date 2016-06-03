import java.util.Stack;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Write a program to sort Stack in ascening order. 
 * Implement only with PUSH | PEEK | POP | isEmpty
 */
public class Ch3Dot6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack test = new Stack();
		test.push(17);
		test.push(9);
		test.push(21);
		test.push(13);
		test.push(5);
		
		System.out.println("Before sorting");
		for (int i = 0; i < test.size(); i++) { 
			   System.out.println(test.get(i).toString());
			}
		
		Stack result = new Stack();
		result = sort(test);
		
		System.out.println("After sorting");
		for (int i = 0; i < result.size(); i++) { 
			   System.out.println(result.get(i).toString());
			}

	}
	
	public static Stack<Integer> sort(Stack<Integer> st1){
		Stack st2 = new Stack();
		
		while(!st1.empty()){
			int temp = st1.pop();
			while(!st2.empty() && (int)st2.peek() > temp){
				st1.push((int)st2.pop());
			}
			
			st2.push(temp);
		}
		return st2;
	}

}
