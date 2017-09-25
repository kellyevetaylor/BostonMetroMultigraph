package BFS;

/**
 * Simple test.
 *
 * This implementation doesn't rely on nodes being representation of
 * stations directly. Rather it uses ID's to figure out the path.
 * TODO: once found print just the shortest path
 * TODO: Add enum for station representations
 * TODO: Load bigger graph
 */
public class GraphBFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        BreadthFirstSearch searcher = new BreadthFirstSearch();
        searcher.BFS(g, 0, 6);
    }
}



