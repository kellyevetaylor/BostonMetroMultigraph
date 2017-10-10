package NewVersion;


import java.io.IOException;
import java.util.ArrayList;

public class MainApp {

    static BostonMetroSystem bms;

    public static void main(String[] a) throws IOException {

        MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");
        UI ui = new UI();

        try {
            bms = mmp.generateGraphFromFile();

                ui.selectStationName(bms, true);
                ui.selectStationName(bms, false);

               bms.search(ui.getFirstStationId(), ui.getSecondStationId());

        } catch (IOException | BadFileException e) {
            e.printStackTrace();
        }
    }
}
