package NewVersion;

public class Line implements IEdge {
    private INode node1;
    private INode node2;
    private String label;

    public Line(INode node1, INode node2, String label){
        this.node1 = node1;
        this.node2 = node2;
        this.label = label;
    }

    @Override
    public INode getFirstNode() {
        return node1;
    }

    @Override
    public INode getSecondNode() {
        return node2;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
