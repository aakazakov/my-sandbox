package dev.fun.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {
	
	static List<Thing> thingList;
	static Knapsack knapsack;
	
	static {
		thingList = new ArrayList<>(
				Arrays.asList(
						new Thing(15, 17, "a"), new Thing(7, 17, "b"), new Thing(10, 10, "c"),
						new Thing(25, 25, "d"), new Thing(5, 5, "e"), new Thing(15, 1, "f"))
				);
		thingList.sort((o1, o2) -> o1.getValue() - o2.getValue());
		
		knapsack = new Knapsack(50);
	}
	
	public static void main(String[] args) {
		
		greedySolution(knapsack.getVolume(), thingList.size() - 1);
		System.out.println(knapsack);
		
	}
	
	static void greedySolution(int freeVolume, int index) {
		if (index >= 0 && freeVolume > 0) {
			Thing current = thingList.remove(index);
			if (current.getVolume() <= freeVolume) {
				knapsack.getThings().add(current);
				freeVolume -= current.getVolume();
				index -= 1;
				greedySolution(freeVolume, index);
			}
		}
	}
}
