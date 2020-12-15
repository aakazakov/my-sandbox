package dev.fun.graph;

import java.util.LinkedList;

public class BreadthFirstSearch extends Search{

	public BreadthFirstSearch(Graph graph, int startVertex) {
		this.startVertex = startVertex;
		marked = new boolean[graph.getVertexCount()];
		steps = new int[graph.getVertexCount()];
		run(graph, startVertex);
	}
	
	@Override
	protected void run(Graph graph, int startVertex) {
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
	
}
