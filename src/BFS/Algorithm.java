package BFS;


import java.util.Map;

public interface Algorithm {
	 
    void perform(Graph g, String sourceVertex);

    Map<String, String> getPath();
}

