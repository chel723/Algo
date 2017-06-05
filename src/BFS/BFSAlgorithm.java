package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSAlgorithm implements Algorithm{
 
    private List<String> visitedVertex;
 
    private Map<String, String> path; 
   
   @Override
    public void perform(Graph g, String sourceVertex) {
        if (null == visitedVertex) {
            visitedVertex = new ArrayList<>();
        }
        if (null == path) {
            path = new HashMap<>();
        }
        
        BFS(g, sourceVertex);
    }

    @Override
    public Map<String, String> getPath() {
        return path;
    }
    
    private void BFS(Graph g, String sourceVertex) {
    	
        Queue<String> queue = new LinkedList<String>();    
        visitedVertex.add(sourceVertex);   
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            String ver = queue.poll();
            List<String> toBeVisitedVertex = g.getAdj().get(ver);
           
            for (String v : toBeVisitedVertex) {           		
                if (!visitedVertex.contains(v)) {
                	
                    visitedVertex.add(v);
                    path.put(v, ver);                    
                    queue.add(v);
                    
                   // System.out.println("Path: " + path);                    
                }
            }
        }
    }
}
