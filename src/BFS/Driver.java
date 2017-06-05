package BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Driver{
	    
		public static void main(String[] args) throws Exception {
			 
	        Graph g = new Graph(new BFSAlgorithm());
	        
	        BufferedReader in = new BufferedReader(new FileReader("/Users/chelseaw/Documents/workspace/Algo_v1/graph.txt"));
	        String line = "";
	        while ((line = in.readLine()) != null) {
	        	
	            String parts[] = line.split(",");
	            g.addVertex(parts[0]);
	            g.addVertex(parts[1]);
	            g.addEdge(parts[0], parts[1]);
	            
	        }
	        in.close();       
	        g.done();
	     
		    Scanner sc = new Scanner(System.in); 
		    System.out.println("Enter the Source Station: ");  
		    String source=sc.nextLine();
		    g.setSource(source);
		    System.out.println("Enter the Destination Station: ");  
		    String dest=sc.nextLine();  
		    
		    Stack<String> result = g.findPathTo(dest);
		    
		    System.out.println("\nBFS: From " +source+ " to " + dest);
		    		    
		    while (!result.isEmpty()) {
		        System.out.println(result.pop());
	    
		    }
		}
		  
}