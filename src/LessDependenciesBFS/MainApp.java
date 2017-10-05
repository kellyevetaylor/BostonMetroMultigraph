package LessDependenciesBFS;

import java.io.IOException;

public class MainApp {
    private static BostonMetroSystem bms;

    public static void main(String[] args) throws IOException {
        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");

        try {
            bms = (BostonMetroSystem) mmp.generateGraphFromFile();
            int start = 1; // OakStreet
            int finish = 3; // 105

            bms.search(bms, start, finish);
            System.out.println("Path is: ");
            bms.getNodes().stream()
                    .filter(node -> bms.shortest.stream().anyMatch(id -> id == node.getId()))
                    .forEach(System.out::println);

        } catch (BadFileException e) {
            e.printStackTrace();
        }
    }


}
