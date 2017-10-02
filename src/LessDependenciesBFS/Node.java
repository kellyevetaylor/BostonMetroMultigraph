package LessDependenciesBFS;

public class Node implements NodeADT {
    private int id;
    private String stationName;
//    private boolean visited;

    public Node(int id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }

    public int getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    @Override
    public String toString() {
        return this.stationName;
    }
}
