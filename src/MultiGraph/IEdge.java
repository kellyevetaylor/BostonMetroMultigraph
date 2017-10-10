package MultiGraph;

public interface IEdge {

    INode getFirstNode();

    INode getSecondNode();

    int getFirstId();

    int getSecondId();

    String getLabel();

}
