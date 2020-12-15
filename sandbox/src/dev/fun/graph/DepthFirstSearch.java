package dev.fun.graph;

public class DepthFirstSearch extends Search {

	public DepthFirstSearch(Graph graph, int startVertex) {
		this.startVertex = startVertex;
		marked = new boolean[graph.getVertexCount()];
		steps = new int[graph.getVertexCount()];
		run(graph, startVertex);
	}
	
	@Override
	protected void run(Graph graph, int currentVertex) {
		marked[currentVertex] = true;
		for (int v : graph.getAdjList(currentVertex)) {
			if (!marked[v]) {
				steps[v] = currentVertex;
				run(graph, v);
			}
		}
 	}
	
}
