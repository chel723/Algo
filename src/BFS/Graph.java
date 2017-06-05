package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import Dijkstra.Graph.Vertex;

public class Graph {

    private String source;
    private Map<String, List<String>> adj = new HashMap<>();
  
    public void addEdge(String fromVertex, String toVertex) {
        if (source == null) {
            source = fromVertex;
        }
        adj.get(fromVertex).add(toVertex);
        adj.get(toVertex).add(fromVertex);
    }

    public void addVertex(String vertex) {
        adj.put(vertex, new ArrayList<>());
    }

    public Map<String, List<String>> getAdj() {
        return adj;
    }

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
    // implementation
    private Algorithm algorithm;

    public Graph(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Graph(String source){
    	this.source = source;
    }
    
    public Graph(Algorithm algorithm,  String source) {
        this.algorithm = algorithm;
        this.source = source;
    }
    
    public void done() {
        algorithm.perform(this, source);
    } 

    //shortest path

    public Stack<String> findPathTo(String dest) {
        Stack<String> stack = new Stack<>();
        stack.add(dest);
        
        Map<String, String> path = algorithm.getPath();
        for (String location = path.get(dest) ; !location.equals(source) ; location = path.get(location)) {
        	
            stack.push(location);
            
        }
        stack.push(source);
        
        return stack;
    } 
}







