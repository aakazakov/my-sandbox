package dev.fun.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private int vertexCount;
	private int edgeCount;
	private LinkedList<Integer>[] adjList;
	
	public int getVertexCount() {
		return vertexCount;
	}

	public int getEdgeCount() {
		return edgeCount;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAdjList(int vertex) {
		return (LinkedList<Integer>) adjList[vertex].clone();
	}

	@SuppressWarnings("unchecked")
	public Graph(int vertexCount) {
		if (vertexCount <= 0) {
			throw new IllegalArgumentException("the argument must be greater than 0");
		} 
		this.vertexCount = vertexCount;
		this.edgeCount = 0;
		this.adjList = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int vertex1, int vertex2) {
		if (vertex1 < 0 || vertex2 < 0 || vertex1 >= vertexCount || vertex2 >= vertexCount) {
			throw new IllegalArgumentException("invalid arguments passed");
		}
		adjList[vertex1].add(vertex2);
		if (vertex1 != vertex2) {
			adjList[vertex2].add(vertex1);
		}
		edgeCount++;
	}
	
}
