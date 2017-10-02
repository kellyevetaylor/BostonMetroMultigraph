package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BostonMetroSystem implements GraphADT {

    private List<NodeADT> nodes;
    private List<EdgeADT> edges;
    private ArrayList<Integer> path = new ArrayList();
    private ArrayList<Integer> visited = new ArrayList();
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

    public ArrayList<Integer> getSuccessors(int n) {
        ArrayList<Integer> successors = new ArrayList<>();

        for (EdgeADT edge : edges) {
            if (edge.getFirstID() == n) {
                successors.add(edge.getSecondID());
            }

            //this is so that it can go in both directions

            if (edge.getSecondID() == n) {
                successors.add(edge.getFirstID());
            }
        }
        return successors;
    }


    public ArrayList<Integer> BFS(NodeADT startNode, NodeADT endNode) {

        Queue queue = new LinkedList();
        queue.add(startNode.getId());
        //startNode.setVisited(true);
        visited.add(startNode.getId());

        while (!queue.isEmpty()) {
            int n = (int) queue.poll();
            ArrayList<Integer> successors = getSuccessors(n);
            for (int child : successors) {

                path.add(child);
                path.add(n);

                if (child == endNode.getId()) {
                    return processPath(startNode.getId(), endNode.getId(), path);
                } else {
                    if (!visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<Integer> processPath(int src, int destination, ArrayList<Integer> path) {

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
