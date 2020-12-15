package dev.fun.graph;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
	
	private int startVertex;
	private boolean[] marked;
	private int[] steps;
	
	public BreadthFirstSearch(Graph graph, int startVertex) {
		this.startVertex = startVertex;
		marked = new boolean[graph.getVertexCount()];
		steps = new int[graph.getVertexCount()];
		bfs(graph, startVertex);
	}
	
	private void bfs(Graph graph, int startVertex) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(startVertex);
		marked[startVertex] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.removeFirst();
			for (int v : graph.getAdjList(currentVertex)) {
				if (!marked[v]) {
					queue.addLast(v);
					marked[v] = true;
					steps[v] = currentVertex;
				}
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
