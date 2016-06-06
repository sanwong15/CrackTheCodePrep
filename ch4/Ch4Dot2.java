package ch4;

/*
 * San Wong
 * hswong1@uci.edu
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Given a directed graph, determine whether there is a route between two nodes.
 */
public class Ch4Dot2 {

	public static void main(String[] args) {        
		Digraph<GraphNode> graph = new Digraph<GraphNode>();
		GraphNode NodeZero = new GraphNode(0);
		GraphNode NodeOne = new GraphNode(1);
		GraphNode NodeTwo = new GraphNode(2);
	    GraphNode NodeThree = new GraphNode(3);
	    GraphNode NodeFour = new GraphNode(4);
	    GraphNode NodeFive = new GraphNode(5);
	   	GraphNode NodeSix = new GraphNode(6);
	    
	    graph.add(NodeZero, NodeOne); graph.add(NodeZero, NodeTwo); graph.add(NodeZero, NodeThree);
        graph.add(NodeOne, NodeTwo); graph.add(NodeOne, NodeThree); graph.add(NodeTwo, NodeThree);
        graph.add(NodeTwo, NodeFour); graph.add(NodeFour, NodeFive); graph.add(NodeFive, NodeSix);

        System.out.println("The current graph: " + graph);
        
        System.out.println("Is 1 and 3 connected?");
        System.out.println("Result: " + search(graph,NodeOne,NodeThree));
        System.out.println("Is 2 and 4 connected?");
        System.out.println("Result: " + search(graph,NodeTwo,NodeFour));
        System.out.println("Is 0 and 6 connected?");
        System.out.println("Result: " + search(graph,NodeZero,NodeSix));
        System.out.println("Is 1 and 4 connected?");
        System.out.println("Result: " + search(graph,NodeOne,NodeFour));
        
	}
	
	public enum State {
		Unvisited, Visited, Visiting;
	} 
	
	public static boolean search(Digraph g, GraphNode start, GraphNode end){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>(); 
		Map<GraphNode,List<GraphNode>> neighborList = g.neighbors;
		
		for (GraphNode u: neighborList.keySet()){
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		GraphNode u;
		while(!q.isEmpty()){
			u = q.removeFirst();
			if(u != null){
				for(GraphNode v: neighborList.get(u)){ //u.getAdjacent(). neighborList.get(u) is an ArrayList<GraphNode>
					if(v.state == State.Unvisited){
						if(v.equals(end)){ // it was just v == end
							return true;
						}else{
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;

			}
		}
		return false;
	}
}


