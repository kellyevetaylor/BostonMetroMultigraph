package dimitarBFS;

import java.util.ArrayList;
import java.util.List;

public class Graph implements GraphADT{
    private final List<NodeADT> nodes;
    private final List<EdgeADT> edges;

    public Graph(List<NodeADT> nodes, List<EdgeADT> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
    
    public void addNode(NodeADT n){
		nodes.add(n);
	}
    
    public NodeADT getNode(NodeADT id){
		for(NodeADT n : nodes){
			if(n.getId().equals(id)){
				return n;
			}
		}
		return null;
	}


    public List<NodeADT> getNodes() {
        return nodes;
    }

    public void addEdge(NodeADT node1, NodeADT node2, String lineColor){
    		edges.add(new Edge(node1, node2, lineColor));
    	}
        

    public List<EdgeADT> getEdges() {
        return edges;
    }
    
    public List<NodeADT> getSuccessors(Node n){
		List<NodeADT> successors = new ArrayList<NodeADT>();
		
		for(EdgeADT edge : edges){
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