package hit;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class Text2GraphTestWhite {

    private Graph graph;
    private Text2Graph text2Graph;

    /*@Before
    public void setUp() {
        graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("a", "c");
        graph.addEdge("c", "d");
        graph.addEdge("d", "a");

        text2Graph = new Text2Graph(graph);
    }*/

    @Test
    public void testNoNode() {
        graph = new Graph();
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wA","wB");
        assertEquals("No path found between wA and wB", result);
    }
    @Test
    public void testOneNode() {
        graph = new Graph();
        graph.addNode("wA");
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wA","wA");
        assertEquals("Shortest path between wA and wA: wA with length 0", result);
    }

    @Test
    public void testPath() {
        graph = new Graph();
        graph.addNode("wA");
        graph.addNode("wB");
        graph.addNode("wC");
        graph.addEdge("wA", "wB");
        graph.addEdge("wB", "wC");
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wA","wC");
        assertEquals("Shortest path between wA and wC: wA->wB->wC with length 2", result);
    }

    @Test
    public void testShorterPath() {
        graph = new Graph();
        graph.addNode("wA");
        graph.addNode("wB");
        graph.addNode("wC");
        graph.addEdge("wA", "wB");
        graph.addEdge("wB", "wC");
        graph.addEdge("wA", "wC");
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wA","wC");
        assertEquals("Shortest path between wA and wC: wA->wC with length 1", result);
    }
    @Test
    public void testNoneRight() {
        graph = new Graph();
        graph.addNode("wA");
        graph.addNode("wB");
        graph.addNode("wC");
        graph.addNode("wD");
        graph.addEdge("wA", "wB");
        graph.addEdge("wB", "wC");
        graph.addEdge("wA", "wC");
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wA","wD");
        assertEquals("No path found between wA and wD", result);
    }
    @Test
    public void testNoneLeft() {
        graph = new Graph();
        graph.addNode("wA");
        graph.addNode("wB");
        graph.addNode("wC");
        graph.addNode("wD");
        graph.addEdge("wA", "wB");
        graph.addEdge("wB", "wC");
        graph.addEdge("wA", "wC");
        text2Graph = new Text2Graph(graph);
        String result = text2Graph.calcShortestPath("wE","wB");
        assertEquals("No path found between wE and wB", result);
    }
}
