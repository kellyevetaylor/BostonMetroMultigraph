package LessDependenciesBFS;

import java.io.IOException;

public class MainApp {
    private static BostonMetroSystem bms;

    public static void main(String[] args) throws IOException {
        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");

        try {
            bms = (BostonMetroSystem) mmp.generateGraphFromFile();
            NodeADT node1 = new Node(1,"OakStreet");
            NodeADT node2 = new Node(105,"Ashmont");
            bms.BFS(node1,node2);
            System.out.println("Path is: ");
            for (Integer n:bms.shortest){
                System.out.println(n);
            }
        } catch (BadFileException e) {
            e.printStackTrace();
        }
    }


}
