package DijkstraImplementation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDijkstraAlgorithm {

    private List<Node> nodes;
    private List<Edge> edges;

    @Test
    public void testExcute() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Node location = new Node("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1);
        addLane("Edge_1", 0, 2);
        addLane("Edge_2", 0, 4);
        addLane("Edge_3", 2, 6);
        addLane("Edge_4", 2, 7);
        addLane("Edge_5", 3, 7);
        addLane("Edge_6", 5, 8);
        addLane("Edge_7", 8, 9);
        addLane("Edge_8", 7, 9);
        addLane("Edge_9", 4, 9);
        addLane("Edge_10", 9, 10);
        addLane("Edge_11", 1, 10);

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(4));
        LinkedList<Node> path = dijkstra.getPath(nodes.get(9));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Node node : path) {
            System.out.println(node);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo) {
        Edge lane = new Edge(nodes.get(sourceLocNo), nodes.get(destLocNo), laneId);
        edges.add(lane);
    }
}