package dev.fun.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

	public static void main(String[] args) {
		
		List<Thing> thingList = new ArrayList<>(
				Arrays.asList(
						new Thing(5, 17, "a"), new Thing(7, 17, "b"), new Thing(1, 10, "c"),
						new Thing(2, 25, "d"), new Thing(3, 5, "e"), new Thing(4, 1, "f"))
				);
		thingList.sort((o1, o2) -> o1.getValue() - o2.getValue()); // it's easier with sort )
		
		KnapsackSolution solution = new KnapsackSolution();
		List<Thing> list = solution.greedySolution(thingList, 15, thingList.size() - 1);
		
		System.out.println(list);
		
		thingList.sort((o1, o2) -> o1.getVolume() - o2.getVolume()); // it's easier with sort )
		solution.solution(thingList, 15);
		
		
	}
}
