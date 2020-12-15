package dev.fun.graph;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph(16);
		g.addEdge(0, 12);
		g.addEdge(1, 2);
		g.addEdge(1, 13);
		g.addEdge(2, 6);
		g.addEdge(2, 7);
		g.addEdge(2, 3);
		g.addEdge(3, 7);
		g.addEdge(3, 4);
		g.addEdge(6, 11);
		g.addEdge(6, 12);
		g.addEdge(11, 12);
		g.addEdge(7, 5);
		g.addEdge(5, 9);
		g.addEdge(5, 11);
		g.addEdge(9, 10);	
		g.addEdge(8, 14);
		g.addEdge(14, 15);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
		
		int destination = 10;
		
		List<Integer> shortestPath = bfs.path(destination);
		
		System.out.println("Shortest path to the destination point [" + destination + "] is " 
				+ shortestPath + ".\nLength " 
				+ shortestPath.size() + " steps.");
		
//		System out:
//		
//		Shortest path to the destination point [10] is [12, 11, 5, 9, 10].
//		Length 5 steps.
		
	}
	
}
