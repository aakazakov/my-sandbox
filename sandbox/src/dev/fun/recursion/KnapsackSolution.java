package dev.fun.recursion;

import java.util.ArrayList;
import java.util.List;

public class KnapsackSolution {
	
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
	
}
