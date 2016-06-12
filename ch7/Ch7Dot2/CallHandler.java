package ch7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * CallHandler class is responsible to route call
 */

public class CallHandler {
	Queue<Call> PMqueue = new LinkedList<>();
	Queue<Call> TLqueue = new LinkedList<>();
	ArrayList<Queue<Call>> fresherQueue = new ArrayList<Queue<Call>>();
	
	//Constructor
	public CallHandler(int numOFfresher){
		for (int i=0; i<numOFfresher; i++){
			Queue<Call> newQueue = new LinkedList<Call>();
			fresherQueue.add(newQueue);
		}
	}
	
	public Call getNetCall(Employee e){
		int rank = e.level;
		Call NextCall;
		if(rank == 2){
			NextCall = PMqueue.remove();
			return NextCall;
		}else if(rank == 1){
			NextCall = TLqueue.remove();
			return NextCall;
		}else{
			//Determine which fresher is it
			Queue<Call> currentFresherQueue = new LinkedList<Call>();
			currentFresherQueue = fresherQueue.get(e.ID);
			NextCall = currentFresherQueue.remove();
			return NextCall;
		}
	}
	
	public void reroute(Call callToReroute, int level){
		if (level == 0){
			
		
			int fresherQueueSize = fresherQueue.size();
			for (int i = 0; i<fresherQueueSize; i++){
				Queue<Call> currentFresherQueue = new LinkedList<Call>();
				currentFresherQueue = fresherQueue.get(i);
				if (currentFresherQueue.isEmpty()){
					currentFresherQueue.add(callToReroute);
				}
			}
		}else if(level ==1){
			PMqueue.add(callToReroute);
		}else{
			System.out.println("Please wait. All representatives are busy");
		}
		
		
	}
}
