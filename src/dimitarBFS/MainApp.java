package dimitarBFS;

import com.company.BadFileException;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        MetroMapParser mmp = new MetroMapParser("aasd");

        try {
            BostonMetroSystem bms = (BostonMetroSystem) mmp.generateGraphFromFile();
        } catch (BadFileException e) {
            e.printStackTrace();
        }
    }
}
