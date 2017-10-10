package NewVersion;

import java.util.List;

public class BostonMetroSystem {
    private GraphADT g;

    public BostonMetroSystem() {
        g = new Graph();
    }

    void addStation(int ID, String stationName) {
        g.addNode(new Station(ID, stationName));
    }

    void addLine(Line line) {
        g.addEdge(line);
    }

    public void search(int start, int end) {
        g.search(start, end);
    }

    List<INode> getStations() {
        return g.getNodes();
    }

}
