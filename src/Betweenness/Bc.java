package Betweenness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Bc {
	
	public static void main(String[] args) throws Exception {
     	
		   SingleGraph graph = new SingleGraph("Betweenness Test"); 
		   BetweennessCentrality bcb = new BetweennessCentrality(); 
		   BufferedReader in = new BufferedReader(new FileReader("/Users/chelseaw/Documents/workspace/Algo_v1/data/Bc.csv"));
		      String line = "";
		     
		      while ((line = in.readLine())!= null) {
		    	  
		        String parts[] = line.split(",");	        	
				        Node A =  graph.addNode(parts[1]);
				        Node B =  graph.addNode(parts[2]);
				        
				        graph.setStrict(false);
				        graph.setAutoCreate( true );
		        
		        graph.addEdge(parts[0], parts[1], parts[2]);
		     
		        bcb.setWeight(A, B, Double.parseDouble(parts[3]));
		         
		      }
		              
		      in.close();

		   bcb.setWeightAttributeName("weight"); 
		   bcb.init(graph); 
		   bcb.compute(); 
	   
		   Scanner sc = new Scanner(System.in); 
	       System.out.println("Enter a Station: ");  
		   String node=sc.nextLine();  	   
		   
		   System.out.println(node +": "+ graph.getNode(node).getAttribute("Cb")); 
		 
   }
	
}



