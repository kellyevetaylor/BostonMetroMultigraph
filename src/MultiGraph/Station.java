package MultiGraph;

public class Station implements INode {
    private int ID;
    private String label;

    public Station(int ID, String label){
        this.ID = ID;
        this.label = label;
    }


    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
        return label;
    }
}
