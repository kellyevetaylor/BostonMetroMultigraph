package LessDependenciesBFS;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Main run = new Main();
        run.fillGraph();
    }

    public void fillGraph() {

        ArrayList<NodeADT> nodes = new ArrayList<>();
        ArrayList<EdgeADT> edges = new ArrayList<>();


        Node a = new Node(0, "AAA");
        Node b = new Node(1, "BBB");
        Node c = new Node(2, "CCC");
        Node d = new Node(3, "DDD");
        Node e = new Node(4, "EEE");
        Node f = new Node(5, "FFF");
        Node g = new Node(6, "GGG");

        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);

        edges.add(new Edge(0, 1, "green"));
        edges.add(new Edge(1, 2, "red"));
        edges.add(new Edge(2, 3, "yellow"));
        edges.add(new Edge(3, 4, "blue"));
        edges.add(new Edge(1, 5, "blue"));
        edges.add(new Edge(5, 6, "blue"));
        edges.add(new Edge(6, 3, "blue"));
        edges.add(new Edge(2, 4, "blue"));

        Graph gr = new Graph(nodes, edges);
        Node h = new Node(7, "HHH");
        gr.addNode(h);
        gr.addEdge(new Edge(1,7,"whatevs"));

        gr.BFS(e, h);
        System.out.println("Path is: ");
        for (Integer n:gr.shortest){
            System.out.println(n);
        }
    }

}
