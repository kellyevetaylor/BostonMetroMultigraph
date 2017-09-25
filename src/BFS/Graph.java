package BFS;

/**
 * Graph class. Represented as adjancency list.
 */
class Graph {
    int V; // total number of Nodes
    Bag[] nodes; // all of the nodes in graph

    /**
     * Creates graph of size V vertices.
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
     * @param src
     * @param dest
     */
    public void addEdge(int src, int dest) {
        nodes[src].add(dest);
        nodes[dest].add(src);
    }

}
