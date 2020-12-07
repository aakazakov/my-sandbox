package dev.fun.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

	public static void main(String[] args) {
		
		List<Thing> thingList = new ArrayList<>(
				Arrays.asList(
						new Thing(15, 17, "a"), new Thing(7, 17, "b"), new Thing(10, 10, "c"),
						new Thing(25, 25, "d"), new Thing(5, 5, "e"), new Thing(15, 1, "f"))
				);
		thingList.sort((o1, o2) -> o1.getValue() - o2.getValue());
		
		KnapsackSolution solution = new KnapsackSolution();
		StringBuilder sb = solution.greedySolution(thingList, 50, thingList.size() - 1, new StringBuilder());
		
		System.out.println(sb.toString());
		
	}
}
