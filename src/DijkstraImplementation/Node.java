package DijkstraImplementation;

public class Node{

    private String id;
    private String stationName;

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

    public String toString(){
        return stationName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
