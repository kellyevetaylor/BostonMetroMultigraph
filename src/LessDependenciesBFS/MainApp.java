package LessDependenciesBFS;


        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Scanner;

public class MainApp {
    private static BostonMetroSystem bms;
    int start;
    int finish;

    public static void main(String[] args) throws IOException {
        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");
        Search search = new Search();

        MainApp main = new MainApp();

        Scanner scanner = new Scanner(System.in);
        String startnode = null;
        String endnode = null;


        try {
            bms = (BostonMetroSystem) mmp.generateGraphFromFile();

            boolean valid = false;

            do
            {
            	System.out.println("Enter starting station: ");
             startnode = scanner.next();
              for (INode n: bms.getNodes()) {
  				if (n.getStationName().equals(startnode)) {
  					main.start = n.getId();
  					 valid=true;
  				}
              }
              //System.out.println("Not a valid station, try again.");
            }
            while (!valid);
            System.out.println("wew");
            valid=false;
            do
            {
            System.out.println("Enter ending station: ");
            endnode = scanner.next();
              for (INode n: bms.getNodes()) {
  				if (n.getStationName().equals(endnode)) {
  					main.finish = n.getId();
  					 valid=true;
  				}
              }
             // System.out.println("Not a valid station, try again.");
            }
            while (!valid);
            valid=false;

            search.search(bms, main.start, main.finish);
            main.directions(bms);
            System.out.println("Path is: ");
            for (Integer n : bms.shortest) {
                for (INode node : bms.getNodes())
                    if (n == node.getId()) {
                        System.out.println(node.getStationName());
                    }
            }
//            bms.getNodes().stream()
//                    .filter(node -> bms.shortest.stream().anyMatch(id -> id == node.getId()))
//                    .forEach(System.out::println);

        } catch (BadFileException e) {
            e.printStackTrace();
        }

    }

    public void directions(BostonMetroSystem g) {
        //spn == shortest path nodes
//    	ArrayList<INode> spn = new ArrayList<INode>();
//    	for (Integer n: bms.shortest){
//        	for(INode node: bms.getNodes())
//        	if (n==node.getId()){
//        	spn.add(node);
//        	}
//        }
        ArrayList<IEdge> edges = new ArrayList();
        ArrayList<IEdge> sortededges = new ArrayList();


        for (IEdge edge : bms.getEdges()) {
            for (int i = 0; i < bms.shortest.size() - 1; i++) {
                if ((edge.getFirstID() == bms.shortest.get(i) && edge.getSecondID() == bms.shortest.get(i + 1))
                        || (edge.getSecondID() == bms.shortest.get(i) && edge.getFirstID() == bms.shortest.get(i + 1))) {
                    edges.add(edge);
                }

            }
        }
        for (IEdge e : edges) {
            for (Integer i : bms.shortest) {
                if (i == e.getFirstID()) {
                    sortededges.add(e);
                }
            }
        }
        for (IEdge e : sortededges) {
            System.out.println(e.getLineColor());
        }

    }
}
