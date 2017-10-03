package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
    /**
     * Executes the search on the given graph.
     * @param graph instance of graph to search.
     * @param startNode starting node id.
     * @param endNode our destination.
     * @return path - path of nodes to visit for the path.
     */
    public ArrayList<Integer> search(GraphADT graph, int startNode, int endNode) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        visited.add(startNode);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            ArrayList<Integer> successors = graph.getSuccessors(n);
            for (int child : successors) {

                path.add(child);
                path.add(n);

                if (child == endNode) {
                    return graph.processPath(startNode, endNode, path);
                } else {
                    if (!visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
        return null;
    }
}
