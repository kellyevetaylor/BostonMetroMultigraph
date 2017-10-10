package NewVersion;

import java.util.*;

public class Graph implements GraphADT {
    private List<INode> nodes;
    private List<IEdge> edges;
    private List<Integer> shortest = new ArrayList();


    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(IEdge edge) {
        edges.add(edge);
    }


    List<Integer> getSuccessors(int n) {
        List<Integer> successors = new ArrayList<>();

        for (IEdge edge : edges) {
            int firstId = edge.getFirstId();
            int secondId = edge.getSecondId();

            if (firstId == n) successors.add(secondId);
            if (secondId == n) successors.add(firstId);
        }
        return successors;
    }


    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    public void search(int startNode, int endNode) {
        List path = bfs(startNode, endNode);
        processPath(startNode, endNode, path);
        printPath();
    }

    private List bfs(int startNode, int endNode) {
        List<Integer> path = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        visited.add(startNode);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            List<Integer> successors = getSuccessors(n);

            for (int child : successors) {

                path.add(child);
                path.add(n);

                visited.add(n);
                if (child == endNode) {
                    return path;
                } else {
                    if (!visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
        return null;
    }


    private void printPath() {
        int pos = Integer.MAX_VALUE;
        for (int i = 1; i < shortest.size(); i++)
            if (shortest.get(i) == shortest.get(0)) {
                pos = i;
                break;
            }

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < shortest.size() && i < pos; i++) {
            for (INode node : nodes)
                if (shortest.get(i) == node.getId()) {
                    ids.add(node.getId());
                }
        }

        for (int i = 0; i < ids.size() - 2; i++) {
            int j = i + 1;
            String label = getLabel(ids.get(i), ids.get(j));
            while (j < ids.size() - 1) {
                if (getLabel(ids.get(j), ids.get(j + 1)).equals(label))
                    j++;
                else
                    break;
            }
            String station1 = null;
            String station2 = null;
            for (INode node : nodes) {
                if (node.getId() == ids.get(i))
                    station1 = node.getName();
                if (node.getId() == ids.get(j))
                    station2 = node.getName();
            }
            System.out.format("From %s to %s go on the %s line.\n", station1, station2, label);
            i = j - 1;
        }

        System.out.println("You have reached your destination!\n");

    }

    private String getLabel(int i, int j) {
        for (IEdge edge : edges) {
            int firstId = edge.getFirstId();
            int secondId = edge.getSecondId();

            if ((firstId == i && secondId == j) || (firstId == j && secondId == i))
                return edge.getLabel();
        }
        return null;
    }


    private List<Integer> processPath(int src, int destination, List<Integer> path) {
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