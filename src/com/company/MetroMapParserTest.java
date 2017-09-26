package com.company;

import BFS.Bag;
import BFS.Graph;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MetroMapParserTest {
    @org.junit.Test
    public void generateGraphFromFile() throws Exception {
        String filename = "/Users/megamolis/IdeaProjects/CS308-Multigraph-ADT/src/com/company/bostonmetro.txt";
        MetroMapParser mmp = new MetroMapParser(filename);
        Graph graph = mmp.generateGraphFromFile();

        Stream<Bag> adjList = Stream.of(graph.nodes) ;

        assertTrue("Graph should be filled with nodes", adjList.allMatch(node -> node.head != null));
    }

}