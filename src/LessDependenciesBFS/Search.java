package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
    public ArrayList<Integer> BFS(GraphADT graph, INode startNode, INode endNode) {

        ArrayList<Integer> path = new ArrayList();
        ArrayList<Integer> visited = new ArrayList();
        Queue queue = new LinkedList();
        queue.add(startNode.getId());
        visited.add(startNode.getId());

        while (!queue.isEmpty()) {
            int n = (int) queue.poll();
            ArrayList<Integer> successors = graph.getSuccessors(n);
            for (int child : successors) {

                path.add(child);
                path.add(n);

                if (child == endNode.getId()) {
                    return graph.processPath(startNode.getId(), endNode.getId(), path);
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
