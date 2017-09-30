package dimitarBFS;

import java.util.List;

public interface GraphADT {
	public void addNode(NodeADT n);
	public NodeADT getNode(NodeADT n);
	public List<NodeADT> getNodes();
	public void addEdge(NodeADT node1, NodeADT node2, String lineColor);
	public List<EdgeADT> getEdges();
	public List<NodeADT> getSuccessors(Node n);

}
