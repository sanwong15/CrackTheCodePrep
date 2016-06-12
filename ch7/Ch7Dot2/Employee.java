package ch7;

public class Employee {
	//Just like the Card class.
	int level;
	int ID;
	boolean free;
	CallHandler callHandler;
	
	public Employee(int l){
		this.level = l;
	}
	
	//For fresher
	public Employee(int l, int id){
		this.level = l;
		this.ID = id;
	}
	
	public int getLevel(){
		return level;
	}
	
	public boolean avaiablity(){
		return free;
	}
	
	public void setOccupy(){
		free = false;
	}
	
	public void setFree(){
		free = true;
	}
	
	public void PickUpCall(Call call){
		call.answer();
		this.setOccupy();
	}
	
	public void EndCall(Call call){
		call.finished();
		this.setFree();
		callHandler.getNetCall(this);
	}
	
	public void CannotHandleCall(Call call){
		call.level += 1;
		callHandler.reroute(call, this.getLevel());
	}
}
