package NewVersion;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BostonMetroSystemTest {

    private BostonMetroSystem bms;

    @Before
    public void setUp() throws Exception {
        bms = new BostonMetroSystem();
    }

    @Test
    public void createMetroSystem() throws Exception {
        bms = new BostonMetroSystem();
        assertNotNull("System should have a graph.", bms.getStations());
        assertEquals("Graph should be empty.", bms.getStations().size(), 0);
    }

    @Test
    public void addStation() throws Exception {

        bms.addStation( 1, "Test station 1");
        bms.addStation( 2, "Test station 2");

        List<INode> stations = bms.getStations();
        assertEquals("Graph should have stations in it", stations.get(0).getClass(), Station.class );
        assertEquals("Graph should have 2 stations added", stations.size(), 2);
        assertEquals("Station name didn't match", stations.get(0).getName(), "Test station 1");
    }
}