package dev.fun.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class BreadthFirstSearchTest {

	@Test
	void testAll() {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
		
		List<Integer> path = bfs.path(4);
		
		assertEquals(4, path.get(0));
		
		path = bfs.path(3);
		
		assertEquals(1, path.get(0));
		assertEquals(3, path.get(1));
	}

}
