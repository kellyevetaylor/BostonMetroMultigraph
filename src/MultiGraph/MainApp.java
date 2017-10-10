package MultiGraph;


import java.io.IOException;

public class MainApp {

    static BostonMetroSystem bms;

    /**
     * Starts the program. Throws IOException if input file is incorrect
     */
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
