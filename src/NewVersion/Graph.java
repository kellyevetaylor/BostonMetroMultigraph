package NewVersion;

import java.util.*;

public class Graph implements GraphADT {
    private List<INode> nodes;
    private List<IEdge> edges;
    List<Integer> shortest = new ArrayList();

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


    public ArrayList<Integer> getSuccessors(int n) {
        ArrayList<Integer> successors = new ArrayList<>();

        for (IEdge edge : edges) {
            if (edge.getFirstNode().getId() == n) {
                successors.add(edge.getSecondNode().getId());
            }

            if (edge.getSecondNode().getId() == n) {
                successors.add(edge.getFirstNode().getId());
            }
        }
        return successors;
    }

    

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    public void search(int startNode, int endNode) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        visited.add(startNode);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            ArrayList<Integer> successors = getSuccessors(n);

            for (int child : successors) {

                path.add(child);
                path.add(n);

                visited.add(n);
                if (child == endNode) {
                    processPath(startNode, endNode, path);

                } else {
                    if (!visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
         printPath();
    }


    private void printPath() {
        int pos = Integer.MAX_VALUE;
        for(int i=1;i<shortest.size();i++)
            if(shortest.get(i)==shortest.get(0))
            {
               pos = i;
                break;
            }
        for (int i=0;i<shortest.size() && i<pos;i++) {
            for (INode node : nodes)
                if (shortest.get(i) == node.getId()) {
                    System.out.println(node.getName());
                }
        }
    }



    private List<Integer> processPath(int src, int destination, ArrayList<Integer> path) {

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