package ch7;

public class Call {
	int level = 0;
	int state = 0; // 0 = waiting; 1 = answering; 2 = finished call
	
	public void answer(){
		this.state = 1;
	}
	
	public void finished(){
		this.state = 2;
	}
}
