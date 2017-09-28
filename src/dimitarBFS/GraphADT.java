package dimitarBFS;

import java.util.List;

public interface GraphADT {
	public void addNode(Node n);
	public Node getNode(Node n);
	public List<Node> getNodes();
	public void addEdge(Node node1, Node node2, String lineColor);
	public List<Edge> getEdges();
	public List<Node> getSuccessors(Node n);
	
}
