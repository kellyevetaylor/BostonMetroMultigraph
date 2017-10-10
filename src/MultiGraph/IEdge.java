package MultiGraph;

/**
 * Edge interface.
 */
public interface IEdge {

    INode getFirstNode();

    INode getSecondNode();

    /**
     * Returns ID of the first station
     */
    int getFirstId();

    /**
     * Returns ID of the second station
     */
    int getSecondId();

    /**
     * Returns the label connecting the nodes
     */
    String getLabel();

}
