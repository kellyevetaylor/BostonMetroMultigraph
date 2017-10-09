package NewVersion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    private Graph TestGraph;

    @Before
    public void setUp() throws Exception {
        TestGraph = new Graph();
    }

    @Test
    public void createGraph() throws Exception {
        assertEquals("Graph should be empty", TestGraph.getNodes().size(), 0);
    }

    @Test
    public void addNode() throws Exception {
        INode node = new Station(1, "Test Station");
        TestGraph.addNode(node);
        assertEquals("Added node should match name", TestGraph.getNodes().get(0).getName(), "Test Station");
        assertEquals("Id of node shoud match", TestGraph.getNodes().get(0).getId(), 1);
    }

    @Test
    public void getSuccessors() throws Exception {
        INode station1 = new Station(1, "Test Station 1");
        INode station2 = new Station(2, "Test Station 2");
        IEdge line = new Line(station1, station2, "Blue");

        TestGraph.addEdge(line);
        assertNotEquals("Successors shouldn't be empty", TestGraph.getSuccessors(1).size(), 0);
        assertTrue("Successor should be node 2", TestGraph.getSuccessors(1).get(0) == 2);
    }
}