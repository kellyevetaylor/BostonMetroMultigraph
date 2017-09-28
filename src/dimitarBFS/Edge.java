package dimitarBFS;

public class Edge implements EdgeADT{
	

	    private Node node1;
	    private Node node2;
	    private String lineColor;

	    public Edge(Node node1, Node node2, String lineColor) {
	        this.node1 = node1;
	        this.node2 = node2;
	        this.lineColor = lineColor;
	    }

	    public Node getFirstNode() {
	        return node1;
	    }

	    public Node getSecondNode() {
	        return node2;
	    }

	    public String getLineColor() {
	        return lineColor;
	    }
	}

