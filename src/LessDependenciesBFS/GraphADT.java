package LessDependenciesBFS;

import java.util.ArrayList;

public interface GraphADT {
    void addNode(int ID, String name);

    void addEdge(int inID, int outID, String lineColor);

    ArrayList<Integer> getSuccessors(int n);

    ArrayList<Integer> processPath(int id, int id1, ArrayList<Integer> path);
}
