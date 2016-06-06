package ch4;

/*
 * San Wong
 * hswong1@uci.edu
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Digraph<V> {
	
	// key = Vertex and ; value = neighbor vertex
	public Map<V,List<V>> neighbors = new HashMap<V,List<V>>(); //List<V> here eventually is the ArrayList
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(V v: neighbors.keySet()){
			sb.append("\n    " + v + "->" + neighbors.get(v));
		}
		return sb.toString();
	}
	
	//Add vertex. Skip if the vertex already exist
	public void add(V vertex){
		if(neighbors.containsKey(vertex)) return;
		
		neighbors.put(vertex, new ArrayList<V>());
	}
	
	//Check if it is a valid vertex
	public boolean contains(V vertex){
		return neighbors.containsKey(vertex);
	}
	
	//Add an edge to the graph
	public void add(V from, V to){
		this.add(from);
		this.add(to);
		neighbors.get(from).add(to); //get function return a neighbors list
		//and we add the TO vertex to the list
	}
	
	//Find the out-degree of each vertex
	public Map<V,Integer> outDegree(){
		Map<V,Integer> result = new HashMap<V,Integer>();
		for (V v: neighbors.keySet()){
			result.put(v, neighbors.get(v).size());
		}
		
		return result;
	}
	
	public Map<V,Integer> inDegree(){
		Map<V,Integer> result = new HashMap<V,Integer>();
		//Set up an empty table with all Vertex in the graph
		for(V v: neighbors.keySet()){
			result.put(v, 0);
		}
		for(V from: neighbors.keySet()){
			for(V to:neighbors.get(from)){
				result.put(to, result.get(to) + 1);
			}
		}
		
		return result;
	}
	
	//Topologcal Sort
	public List<V> topSort(){
		Map<V,Integer> degree = inDegree();
		//Determine all vertices with Zero Indegree
		Stack<V> zeroVerts = new Stack<V>();
		for(V v: degree.keySet()){
			if(degree.get(v) == 0){
				zeroVerts.push(v);
			}
		}
		
		//Determine the topological order
		List<V> result = new ArrayList<V>();
		while(!zeroVerts.isEmpty()){
			V v = zeroVerts.pop(); //pop a vertex with zero indegree
			result.add(v);
			//Remove vertex v by updating its neighbors
			for (V neighbor: neighbors.get(v)){
				degree.put(neighbor, degree.get(neighbor) - 1);
                // Remember any vertices that now have zero in-degree
                if (degree.get(neighbor) == 0) zeroVerts.push(neighbor);
			}
		}
        // Check that we have used the entire graph (if not, there was a cycle)
        if (result.size() != neighbors.size()) return null;
        return result;
	}
	
	 public Map bfsDistance (V start) {
	        Map<V,Integer> distance = new HashMap<V,Integer>();
	        // Initially, all distance are infinity, except start node
	        for (V v: neighbors.keySet()) distance.put(v, null);
	        distance.put(start, 0);
	        // Process nodes in queue order
	        Queue<V> queue = new LinkedList<V>();
	        queue.offer(start);                                    // Place start node in queue
	        while (!queue.isEmpty()) {
	            V v = queue.remove();
	            int vDist = distance.get(v);
	            // Update neighbors
	            for (V neighbor: neighbors.get(v)) {
	                if (distance.get(neighbor) != null) continue;  // Ignore if already done
	                distance.put(neighbor, vDist + 1);
	                queue.offer(neighbor);
	            }
	        }
	        return distance;
	    }
	
	
	//Detect Directed Acyclic Graph
	public boolean isDag(){
		return topSort() != null;
	}
}
