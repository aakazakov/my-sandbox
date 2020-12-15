package dev.fun.graph;

import java.util.LinkedList;
import java.util.List;

public abstract class Search {
	
	protected int startVertex;
	protected boolean[] marked;
	protected int[] steps;
	
	protected abstract void run(Graph graph, int startVertex);
	
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
