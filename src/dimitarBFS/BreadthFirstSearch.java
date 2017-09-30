package dimitarBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	ArrayList<Node> path = new ArrayList();
	ArrayList<Node> visited = new ArrayList();
	ArrayList<Node> shortest = new ArrayList();
	
    public ArrayList<Node> BFS(Graph g, Node startNode, Node endNode) {
    	
    	Queue queue = new LinkedList();
    	queue.add(startNode);
    	//startNode.setVisited(true);
    	visited.add(startNode);
    	
		while(!queue.isEmpty()) {
			Node n=(Node)queue.poll();
			
			for (Node child : g.getSuccessors(n)) {
				
				path.add(child);
                path.add(n);

                if (child.equals(endNode)) {
                    return processPath(startNode, endNode, path);
                } else {
                    if (!visited.contains(child)) {
                        queue.add(child);
                    }
                }
			}
			
			
		}
		
		return null;
    	
		 
    	
    }

	public ArrayList<Node> processPath(Node src, Node destination, ArrayList<Node> path) {

		// Finds out where the destination node directly comes from.
		int index = path.indexOf(destination);
		Node source = path.get(index + 1);

		// Adds the destination node to the shortestPath.
		shortest.add(0,destination);

		if (source.equals(src)) {
			// The original source node is found.
			shortest.add(0,src);
			return shortest;
		} else {
			// We find where the source node of the destination node
			// comes from.
			// We then set the source node to be the destination node.
			return processPath(src, source, path);
		}
	}
}