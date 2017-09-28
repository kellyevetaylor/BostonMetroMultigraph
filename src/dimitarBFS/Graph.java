package dimitarBFS;

import java.util.ArrayList;
import java.util.List;

public class Graph implements GraphADT{
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
    
    public void addNode(Node n){
		nodes.add(n);
	}
    
    public Node getNode(Node id){
		for(Node n : nodes){
			if(n.getId().equals(id)){
				return n;
			}
		}
		return null;
	}
    

    public List<Node> getNodes() {
        return nodes;
    }
    
    public void addEdge(Node node1, Node node2, String lineColor){
    		edges.add(new Edge(node1, node2, lineColor));
    	}
        

    public List<Edge> getEdges() {
        return edges;
    }
    
    public List<Node> getSuccessors(Node n){
		List<Node> successors = new ArrayList<Node>();
		
		for(Edge edge : edges){
			if(edge.getFirstNode() == n){
				successors.add(edge.getSecondNode());
			}
			
			//this is so that it can go in both directions 
			
			if(edge.getSecondNode() == n){
				successors.add(edge.getFirstNode());
			}
		}
		return successors;
	}

}