package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class RouteBetweenNodesTest {
    RouteBetweenNodes routeBetweenNodes;

    @BeforeEach
    public void setup() {
        routeBetweenNodes = new RouteBetweenNodes();
    }

    @Test
    public void test1() {
        List<Integer> a = new LinkedList<>();
        a.add(2);
        List<Integer> b = new LinkedList<>();
        b.add(1);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, a);
        graph.put(2, b);

        assert (routeBetweenNodes.RouteBetweenNodes(graph, 1, 2));
    }

    @Test
    public void test2() {
        List<Integer> a = new LinkedList<>();
        a.add(3);
        List<Integer> b = new LinkedList<>();
        b.add(3);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, a);
        graph.put(2, b);
        graph.put(3, new LinkedList<>());
        assert (!routeBetweenNodes.RouteBetweenNodes(graph, 1, 2));
    }
}
