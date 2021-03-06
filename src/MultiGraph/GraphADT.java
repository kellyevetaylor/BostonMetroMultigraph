package MultiGraph;
import java.util.List;

/**
 * Graph interface.
 */
public interface GraphADT {
    /**
     * Creates and adds new INode to the graph.
     *
     * @param node   - The INode which is added to the graph.
     */
    void addNode(INode node);

    /**
     * Line connecting two nodes.
     *
     * @param edge - The IEdge which has to be added in the graph.
     */
    void addEdge(IEdge edge);


    /**
     * Searches the graph.
     */
    void search(int start, int end);

    List<INode> getNodes();

}
