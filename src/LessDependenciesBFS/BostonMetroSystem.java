package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.List;

public class BostonMetroSystem implements GraphADT {

    private List<INode> nodes;
    private List<IEdge> edges;
    ArrayList<Integer> shortest = new ArrayList();


    public BostonMetroSystem() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
    @Override
    public void addNode(int ID, String name) {
       nodes.add(new Node(ID, name));
    }

    @Override
    public void addEdge(int inID, int outID, String lineColor) {
        edges.add(new Edge(inID, outID, lineColor));
    }

    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public ArrayList<Integer> getSuccessors(int n) {
        ArrayList<Integer> successors = new ArrayList<>();

        for (IEdge edge : edges) {
            if (edge.getFirstID() == n) {
                successors.add(edge.getSecondID());
            }

            if (edge.getSecondID() == n) {
                successors.add(edge.getFirstID());
            }
        }
        return successors;
    }

    public ArrayList<Integer> processPath(int src, int destination, ArrayList<Integer> path) {

        // Finds out where the destination node directly comes from.
        int index = path.indexOf(destination);
        int source = path.get(index + 1);

        // Adds the destination node to the shortestPath.
        shortest.add(0, destination);

        if (source == src) {
            // The original source node is found.
            shortest.add(0, src);
            return shortest;
        } else {
            // We find where the source node of the destination node
            // comes from.
            // We then set the source node to be the destination node.
            return processPath(src, source, path);
        }
    }
    public List<IEdge> getEdges(){
        return edges;
    }
}
