package dev.fun.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KnapsackSolution {
	
	private class Entry {
		private List<Thing> things;
		private int totalValue;
		private int totalVolume;
		
		List<Thing> getThings() { 
			return things.stream().filter(t -> t.getValue() != 0).collect(Collectors.toList()); 
		}
		
		int getTotalValue() { return totalValue; }
		
		int getTotalVolume() { return totalVolume; }
		
		Entry(Thing t) {
			things = new ArrayList<>();
			add(t);
		}
		
		void add(Thing t) {
			if (!things.contains(t)) {
				things.add(t);
				totalValue += t.getValue();
				totalVolume += t.getVolume();
			}
		}
		
		void add(Entry e) {
			e.getThings().forEach(this::add);
		}
	}
	
	private List<Thing> list;
	
	public KnapsackSolution() {
		this.list = new ArrayList<>();
	}

	public List<Thing> greedySolution(List<Thing> things, int knapsackVolume, int index) {
		if (knapsackVolume > 0 && index >= 0) {
			Thing thing = things.get(index);
			if (thing.getVolume() <= knapsackVolume) {
				list.add(thing);
				knapsackVolume -= thing.getVolume();
				--index;
				return greedySolution(things, knapsackVolume, index);
			}
		}
		return list;
	}

	// Dynamic programming method ))
	public void solution(List<Thing> things, int knapsackVolume) {
		int minVol = things.get(0).getVolume(); // Minimum volume
		int parts = knapsackVolume / minVol; // Quantity of minimum volumes
		
		Entry[][] matrix = new Entry[things.size() + 1][parts + 1];
		
		// If there is no things
		for (int part = 0; part < parts + 1; part++) {
			matrix[0][part] = new Entry(new Thing(0, 0, "null"));
		}
		
		// If there is no capacity
		for (int thing = 0; thing < things.size() + 1; thing++) {
			matrix[thing][0] = new Entry(new Thing(0, 0, "null"));
		}
		
		run(things, matrix, 1, 1, 0);
		
		System.out.println(matrix[things.size()][parts].getThings());
		
	}
	
	/**
	 * Fills the 2D array
	 * @param things list of things i want to put in the knapsack
	 * @param matrix 2D array of possible solutions for different volumes
	 * @param row row number in matrix
	 * @param col column number in matrix (shows volume)
	 * @param index thing number in the list
	 */
	private void run(List<Thing> things, Entry[][] matrix, int row, int col, int index) {
		if (row >= matrix.length || col >= matrix[0].length) {
			return;
		}
		
		for (int vol = col; vol < matrix[row].length; vol++) {
			
			Entry current = new Entry(things.get(index));
			int currentVolume = current.getTotalVolume();
			
			Entry previous = matrix[row - 1][vol];
			
			if (currentVolume <= vol) {
				int freeVolume = vol - currentVolume;				
				current.add(matrix[row -1][freeVolume]);
			} else {
				matrix[row][vol] = previous;
			}
			
			if (current.getTotalValue() > previous.getTotalValue()) {
				matrix[row][vol] = current;
			} else {
				matrix[row][vol] = previous;
			}
			
		}
		
		
		run(things, matrix, ++row, col, ++index);
	}
 	
}
