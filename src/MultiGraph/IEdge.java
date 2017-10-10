package MultiGraph;

public interface IEdge {

    INode getFirstNode();

    INode getSecondNode();

    /**
     * @return ID of the first station
     */
    int getFirstId();

    /**
     * @return ID of the second station
     */
    int getSecondId();

    /**
     * @return the label connecting the nodes
     */
    String getLabel();

}
