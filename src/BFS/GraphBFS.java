package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);

        BreadthFirstSearch searcher = new BreadthFirstSearch();
        searcher.BFS(g, 0);
    }
}

class Node {
    int dest;
    Node next;

    public Node(int d) {
        dest = d;
        next = null;
    }
}

class adjList {
    Node head;
}

/**
 * Graph class. Represented as adjancency list.
 */
class Graph {
    int V; // total number of Nodes
    adjList[] nodes; // all of the nodes in graph

    public Graph(int V) {
        this.V = V;
        nodes = new adjList[V];

        for (int i = 0; i < V; i++) {
            nodes[i] = new adjList();
            nodes[i].head = null;
        }
    }

    public void addEdge(int src, int dest) {
        Node n = new Node(dest);
        n.next = nodes[src].head;
        nodes[src].head = n;
    }

}

class BreadthFirstSearch {
    public void BFS(Graph g, int startNode) {
        boolean[] visited = new boolean[g.V];
        Queue<Integer> s = new LinkedList<>();

        s.add(startNode);
        while (!s.isEmpty()) {
            int n = s.poll();
            System.out.println(" " + n);
            visited[n] = true;
            Node head = g.nodes[n].head;
            while (head != null) {
                if (!visited[head.dest]) {
                    s.add(head.dest);
                    visited[head.dest] = true;
                }
                head = head.next;
            }
        }
    }
}