package dimitarBFS;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	
    BreadthFirstSearch searcher = new BreadthFirstSearch();
    
    
    
	public static void main(String[] args) {
		Main run = new Main();
		run.fillGraph();
		

			
	}
	
	public void fillGraph() {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
	    
	    
		Node a = new Node("0", "AAA");
		Node b = new Node("1", "BBB");
		Node c = new Node("2", "CCC");
		Node d = new Node("3", "DDD");
		Node e = new Node("4", "EEE");
		Node f = new Node("5", "FFF");
		Node g = new Node("6", "GGG");
		
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
		
		edges.add(new Edge(a, b, "green"));
		edges.add(new Edge(b, c, "red"));
		edges.add(new Edge(c, d, "yellow"));
		edges.add(new Edge(d, e, "blue"));
		edges.add(new Edge(b, f, "blue"));
		edges.add(new Edge(f, g, "blue"));
		edges.add(new Edge(g, d, "blue"));
		edges.add(new Edge(c, e, "blue"));
		
		Graph gr = new Graph(nodes, edges);
		
		searcher.BFS(gr, e, b);
		System.out.println("Path is: ");
		for (Node n:searcher.shortest){
			System.out.println(n.getStationName());
			}
	}

}
