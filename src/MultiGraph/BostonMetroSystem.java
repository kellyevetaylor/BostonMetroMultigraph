package MultiGraph;

import java.util.List;

public class BostonMetroSystem {

    /**
     * Creates GraphADT object
     */
    private GraphADT g;

    public BostonMetroSystem() {
        g = new Graph();
    }

    /**
     * Adds a station to the map
     */
    void addStation(int ID, String stationName) {
        g.addNode(new Station(ID, stationName));
    }

    /**
     * Adds a line to the map
     */
    void addLine(Line line) {
        g.addEdge(line);
    }

    /**
     * Calls on search method within the GraphADT
     */
    public void search(int start, int end) {
        g.search(start, end);
    }

    /**
     * Returns the list of stations
     */
    List<INode> getStations() {
        return g.getNodes();
    }

}
