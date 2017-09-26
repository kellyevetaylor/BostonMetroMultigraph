package BFS;

/**
 * Graph class. Represented as adjancency list.
 */
public class Graph {
    int V; // total number of Nodes
    public Bag[] nodes; // all of the nodes in graph

    /**
     * Creates graph of size V vertices.
     *
     * @param V - number of nodes in the graph.
     */
    public Graph(int V) {
        this.V = V;
        nodes = new Bag[V];

        for (int i = 0; i < V; i++) {
            nodes[i] = new Bag();
            nodes[i].head = null;
        }
    }

    /**
     * Adds new edge to adjecency list. Since graph is undirected we just add to both.
     *
     * @param src
     * @param dest
     */
    public void addEdge(int src, int dest) {
        if (dest != 0) { // ignore 0 since it's the end station.
            nodes[src].add(dest);
            nodes[dest].add(src);
        }
    }

    /**
     * Adds new edge to adjecency list. Since graph is undirected we just add to both.
     * Also casts to to Integer for graph id's.
     *
     * @param src
     * @param dest
     */
    public void addEdge(String src, String dest) {
        Integer srcInt = Integer.parseInt(src);
        Integer destInt = Integer.parseInt(dest);
        addEdge(srcInt, destInt);
    }
}
