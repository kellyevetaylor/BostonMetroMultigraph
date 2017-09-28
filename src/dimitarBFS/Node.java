package dimitarBFS;

import java.util.ArrayList;
import java.util.List;

public class Node {
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
