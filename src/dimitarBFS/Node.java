package dimitarBFS;

public class Node implements NodeADT{
    private String id;
    private String stationName;
//    private boolean visited;

    public Node(String id, String stationName){
        this.id = id;
        this.stationName = stationName;
    }

    public String getId(){
        return id;
    }

    public String getStationName(){
        return stationName;
    }

}