package dev.fun.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class DepthFirstSearchTest {

	@Test
	void testAll() {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 3);
		graph.addEdge(3, 5);
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph, 1);
		
		List<Integer> path = dfs.path(5);
		
		assertEquals(1, path.get(0));
		assertEquals(5, path.get(1));
		
		path = dfs.path(4);
		
		assertEquals(1, path.get(0));
		assertEquals(2, path.get(1));
		assertEquals(4, path.get(2));
	}

}
