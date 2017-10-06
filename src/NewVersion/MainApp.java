package NewVersion;

import java.io.IOException;

public class MainApp {

    static BostonMetroSystem bms;


    public static void main(String[] a) throws IOException {

        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");

        try {
            bms = mmp.generateGraphFromFile();
            String start = "OakGrove";
            String end = "Riverside";
            bms.search(start,end);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadFileException e) {
            e.printStackTrace();
        }



    }
}
