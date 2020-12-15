package dev.fun.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphTest {

	@Test
	void should_return_an_object() {
		Graph graph = new Graph(10);
		assertNotNull(graph);
	}
	
	@Test
	void should_to_add_an_edge() {
		Graph graph = new Graph(4);
		graph.addEdge(1, 3);
		
		assertTrue(graph.getAdjList(1).contains(3));
		assertTrue(graph.getAdjList(3).contains(1));
	}

}
