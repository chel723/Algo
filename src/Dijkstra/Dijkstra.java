package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
 
public class Dijkstra {
	
	public static void main(String[] args) throws Exception {
     
	  List<Graph.Edge>  list = new ArrayList<Graph.Edge>();
      BufferedReader in = new BufferedReader(new FileReader("/Users/chelseaw/Documents/workspace/Algo_v1/data/dijkstra.csv"));
      String line = "";
     
      while ((line = in.readLine())!= null) {     	
          String parts[] = line.split(",");
            
        list.add( new Graph.Edge(parts[0], parts[1], Double.parseDouble(parts[2])));       
             
      }
              
      in.close();
      
      Graph.Edge[] edges = list.toArray(new Graph.Edge[list.size()]);
      
      Graph graph = new Graph(edges);
    
      	Scanner sc = new Scanner(System.in); 
      	System.out.println("Enter the Source Station: ");
	    String source=sc.nextLine();  
	    System.out.println("Enter the Destination Station: ");  
	    String dest=sc.nextLine();
	    System.out.println();
	    
      graph.dijkstra(source);
      graph.printPath(dest);
      //graph.printAllPaths();
   }
	
}



