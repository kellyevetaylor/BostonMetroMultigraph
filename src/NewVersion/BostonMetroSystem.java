package NewVersion;

public class BostonMetroSystem {
    public  GraphADT g;

    public BostonMetroSystem(){
        g = new Graph();
    }

    public void addStation(int ID, String stationName) {
        g.addNode(new Station(ID,stationName));
    }

    public void addLine(Line line){
        g.addEdge(line);
    }

    public void search(String start, String end){
        g.search(start, end);
    }


}
