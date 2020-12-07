package dev.fun.recursion;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	private int volume;
	private List<Thing> things;
		
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public List<Thing> getThings() {
		return things;
	}

	public void setThings(List<Thing> things) {
		this.things = things;
	}

	public Knapsack() {
		this.things = new ArrayList<>();
	}

	public Knapsack(int volume) {
		this();
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		StringBuilder contains = new StringBuilder();
		int totalVolume = 0;
		int totalValue = 0;
		for (Thing thing : things) {
			contains.append(thing.getTitle()).append(',');
			totalValue += thing.getValue();
			totalVolume += thing.getVolume();
		}
		int length = contains.length();
		if (length > 0) {
			contains.setLength(length - 1);
		}
		return String.format("total value = %d, total volume = %d, things {%s}%n",
				totalValue, totalVolume, contains.toString());
	}
	
}
