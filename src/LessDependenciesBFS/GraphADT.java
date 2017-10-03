package LessDependenciesBFS;

import java.util.ArrayList;

/**
 * Graph interface.
 */
public interface GraphADT {
    /**
     * Creates and adds new node to the graph.
     *
     * @param ID   - id of the node.
     * @param name - human readable string representation of the node.
     */
    void addNode(int ID, String name);

    /**
     * Edge connecting two nodes.
     *
     * @param inID      - id of incoming connection.
     * @param outID     - id of outgoing direction.
     * @param lineColor - color of the train line.
     */
    void addEdge(int inID, int outID, String lineColor);

    /**
     * Ids of nodes connected to given node.
     *
     * @param n - id of the current node.
     * @return List of connected ids.
     */
    ArrayList<Integer> getSuccessors(int n);

    /**
     * Get just the path between start and end.
     *
     * @param id   - source.
     * @param id1  - destination.
     * @param path - all visited nodes.
     * @return path to take.
     */
    ArrayList<Integer> processPath(int id, int id1, ArrayList<Integer> path);
}
