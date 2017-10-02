package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BostonMetroSystem implements GraphADT {

    private List<NodeADT> nodes;
    private List<EdgeADT> edges;
    ArrayList<Integer> shortest = new ArrayList();


    public BostonMetroSystem() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public BostonMetroSystem(List<NodeADT> nodes, List<EdgeADT> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    public void addNode(NodeADT n) {
        nodes.add(n);
    }

    @Override
    public void addEdge(EdgeADT e) {
        edges.add(e);
    }

    @Override
    public ArrayList<Integer> getSuccessors(int n) {
        ArrayList<Integer> successors = new ArrayList<>();

        for (EdgeADT edge : edges) {
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
}
