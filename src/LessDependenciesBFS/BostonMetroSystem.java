package LessDependenciesBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BostonMetroSystem implements GraphADT {

    private List<NodeADT> nodes;
    private List<EdgeADT> edges;


    public BostonMetroSystem() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public BostonMetroSystem(List<NodeADT> nodes, List<EdgeADT> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    public void addNode(NodeADT n) {
        nodes.add(n);
    }

    @Override
    public void addEdge(EdgeADT e) {
        edges.add(e);
    }
}
