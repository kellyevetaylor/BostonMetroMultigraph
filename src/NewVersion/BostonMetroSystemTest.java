package NewVersion;

import org.junit.Test;

import static org.junit.Assert.*;

public class BostonMetroSystemTest {
    @Test
    public void createMetroSystem() throws Exception {
        BostonMetroSystem bms = new BostonMetroSystem();
        assertNotNull("System should have a graph.", bms.getStations());
        assertEquals("Graph should be empty.", bms.getStations().size(), 0);
    }

    @Test
    public void addStation() throws Exception {

    }

    @Test
    public void addLine() throws Exception {
    }

    @Test
    public void search() throws Exception {
    }

    @Test
    public void getStations() throws Exception {
    }

}