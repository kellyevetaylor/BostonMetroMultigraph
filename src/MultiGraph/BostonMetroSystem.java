package MultiGraph;

import java.util.List;

public class BostonMetroSystem {

    private GraphADT g;

    public BostonMetroSystem() {
        g = new Graph();
    }

    /**
     * Adds a station to the map
     *
     * @param ID
     * @param stationName
     */
    void addStation(int ID, String stationName) {
        g.addNode(new Station(ID, stationName));
    }

    /**
     * Adds a line to the map
     *
     * @param line
     */
    void addLine(Line line) {
        g.addEdge(line);
    }

    /**
     * Calls on search method within the GraphADT
     *
     * @param start
     * @param end
     */
    public void search(int start, int end) {
        g.search(start, end);
    }

    /**
     *
     * @return
     */
    List<INode> getStations() {
        return g.getNodes();
    }

}
