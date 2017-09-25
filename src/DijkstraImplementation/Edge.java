package DijkstraImplementation;

public class Edge {

    private Node node1;
    private Node node2;
    private String lineColor;

    public Edge(Node node1, Node node2, String lineColor) {
        this.node1 = node1;
        this.node2 = node2;
        this.lineColor = lineColor;
    }

    public Node getSource() {
        return node1;
    }

    public Node getDestination() {
        return node2;
    }

    public int getWeight(){
        return 1;
    }
    public String getLineColor() {
        return lineColor;
    }
}

