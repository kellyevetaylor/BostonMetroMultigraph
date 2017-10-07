package NewVersion;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    static BostonMetroSystem bms;


    public static void main(String[] a) throws IOException {

        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");

        try {
            bms = mmp.generateGraphFromFile();

            boolean valid = false;
            String startStation = null;
            String endStation = null;

            Scanner scanner = new Scanner(System.in);
            do
            {
                System.out.println("Enter starting station: ");
                startStation = scanner.next();
                for (INode n: bms.getStations()) {
                    if (n.getName().equals(startStation)) {
                        valid=true;
                    }
                }
                if(!valid)
                   System.out.println("Not a valid station, try again.");
            }
            while (!valid);
            valid=false;
            do
            {
                System.out.println("Enter ending station: ");
                endStation = scanner.next();
                for (INode n: bms.getStations()) {
                    if (n.getName().equals(endStation)) {
                        valid=true;
                    }
                }
                if(!valid)
                    System.out.println("Not a valid station, try again.");
            }
            while (!valid);
            bms.search(startStation,endStation);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadFileException e) {
            e.printStackTrace();
        }



    }
}
