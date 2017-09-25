package BFS;

import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearch {
    public void BFS(Graph g, int startNode, int endNode) {
        boolean found = false;

        boolean[] visited = new boolean[g.V];
        Queue<Integer> nextToCheck = new LinkedList<>();

        nextToCheck.add(startNode);
        while (!nextToCheck.isEmpty() && !found) {
            int n = nextToCheck.poll();
            System.out.println(" " + n);
            visited[n] = true;
            Node head = g.nodes[n].head;

            found = (Integer) head.item == endNode;

            while (head != null && !found) {
                if (!visited[(Integer)head.item]) {
                    found = (Integer) head.item == endNode;
                    nextToCheck.add((Integer)head.item);
                    visited[(Integer)head.item] = true;
                }
                head = head.next;
            }
        }
    }
}
