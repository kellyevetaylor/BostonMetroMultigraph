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


    public List<Integer> getSuccessors(int n) {
        List<Integer> successors = new ArrayList<>();

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

        List<Integer> ids = new ArrayList<>();

        for (int i=0;i<shortest.size() && i<pos;i++) {
            for (INode node : nodes)
                if (shortest.get(i) == node.getId()) {
                    ids.add(node.getId());
                }
        }

        for(int i=0;i<ids.size()-2;i++){
            int j = i+1;
            String label = getLabel(ids.get(i),ids.get(j));
            while(j<ids.size()-1){
                if(getLabel(ids.get(j),ids.get(j+1)).equals(label))
                    j++;
                else
                    break;
            }
            String station1 = null;
            String station2 = null;
            for(INode node:nodes)
            {
                if(node.getId()==ids.get(i))
                    station1 = node.getName();
                if(node.getId()==ids.get(j))
                    station2 = node.getName();
            }
            System.out.println("From station "+ station1 + " to station " + station2 + " go on the " + label + " line.");
            i = j-1;
        }

                
    }

    private String getLabel(int i, int j) {
        for(IEdge edge : edges) {
            if ((edge.getFirstNode().getId() == i && edge.getSecondNode().getId() == j) || (edge.getFirstNode().getId() == j && edge.getSecondNode().getId() == i))
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