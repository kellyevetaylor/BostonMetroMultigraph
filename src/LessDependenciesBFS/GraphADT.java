package LessDependenciesBFS;

import java.util.ArrayList;

public interface GraphADT {
    void addNode(INode n);

    void addEdge(IEdge edge);

    ArrayList<Integer> getSuccessors(int n);

    ArrayList<Integer> processPath(int id, int id1, ArrayList<Integer> path);
}
