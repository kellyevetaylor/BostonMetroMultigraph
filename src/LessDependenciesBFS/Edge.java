package LessDependenciesBFS;

public class Edge implements IEdge {

    private int node1;
    private int node2;
    private String lineColor;

    public Edge(int node1, int node2, String lineColor) {
        this.node1 = node1;
        this.node2 = node2;
        this.lineColor = lineColor;
    }

    public int getFirstID() {
        return node1;
    }

    public int getSecondID() {
        return node2;
    }

    public String getLineColor() {
        return lineColor;
    }
}
