package LessDependenciesBFS;

public class Station implements Node {
    private int id;
    private String stationName;

    public Station(int id, String stationName) {
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
