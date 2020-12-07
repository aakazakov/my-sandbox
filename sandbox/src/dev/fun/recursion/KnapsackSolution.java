package dev.fun.recursion;

import java.util.List;

public class KnapsackSolution {

	public StringBuilder greedySolution(List<Thing> things, int knapsackVolume, int index, StringBuilder seq) {
		if (knapsackVolume > 0 && index >= 0) {
			Thing thing = things.get(index);
			if (thing.getVolume() <= knapsackVolume) {
				seq.append(thing.getTitle()).append(", ");
				knapsackVolume -= thing.getVolume();
				--index;
				return greedySolution(things, knapsackVolume, index, seq);
			}
		}
		if (seq.length() > 0) {
			seq.setLength(seq.length() - 2);
		}
		return seq;
	}
	
}
