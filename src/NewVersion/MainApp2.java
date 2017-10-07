package NewVersion;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp2 {

    static BostonMetroSystem bms;

    public static void main(String[] a) throws IOException {

        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");
        UI ui = new UI();
        ArrayList<Integer> path = new ArrayList<Integer>();

        try {
            bms = mmp.generateGraphFromFile();

            while (1 == 1) {
                ui.selectStationName(bms, true);
                ui.selectStationName(bms, false);

                bms.search(ui.getFirstStationName(), ui.getSecondStationName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadFileException e) {
            e.printStackTrace();
        }
    }
}
