package dev.fun.graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
	
	private int startVertex;
	private boolean[] marked;
	private int[] steps;

	public DepthFirstSearch(Graph graph, int startVertex) {
		this.startVertex = startVertex;
		marked = new boolean[graph.getVertexCount()];
		steps = new int[graph.getVertexCount()];
		dfs(graph, startVertex);
	}
	
	private void dfs(Graph graph, int currentVertex) {
		marked[currentVertex] = true;
		for (int v : graph.getAdjList(currentVertex)) {
			if (!marked[v]) {
				steps[v] = currentVertex;
				dfs(graph, v);
			}
		}
 	}
	
	public List<Integer> path(int destination) {
		LinkedList<Integer> stack = null;		
		if (hasPathTo(destination)) {
			stack = new LinkedList<>();
			int vertex = destination;
			while (vertex != startVertex) {
				stack.push(vertex);
				vertex = steps[vertex];
			}
		}
		return stack;
	}
	
	public boolean hasPathTo(int destination) {
		return marked[destination];
	}
	
}
