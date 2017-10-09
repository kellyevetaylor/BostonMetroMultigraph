package NewVersion;

import java.util.List;

public class BostonMetroSystem {
    public GraphADT g;

    public BostonMetroSystem() {
        g = new Graph();
    }

    public void addStation(int ID, String stationName) {
        g.addNode(new Station(ID, stationName));
    }

    public void addLine(Line line) {
        g.addEdge(line);
    }

    public void search(int start, int end) {
        g.search(start, end);
    }

    public List<INode> getStations() {
        return g.getNodes();
    }

}
