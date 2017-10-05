package LessDependenciesBFS;

/**
 * Implementation of IEdge interface.
 */
public class Edge implements IEdge {

    private int node1;
    private int node2;
    private String lineColor;

    /**
     * @param node1     - id first node.
     * @param node2     - id of the second node.
     * @param lineColor - string name of line color.
     */
    public Edge(int node1, int node2, String lineColor) {
        this.node1 = node1;
        this.node2 = node2;
        this.lineColor = lineColor;
    }

    /**
     * Get id of first connected node.
     *
     * @return id of node1.
     */
    public int getFirstID() {
        return node1;
    }

    /**
     * Get id of second connected node.
     *
     * @return id of node2.
     */
    public int getSecondID() {
        return node2;
    }

    /**
     * Getter for name of the color.
     * @return String representation fo the name.
     */
    public String getLineColor() {
        return lineColor;
    }
}
