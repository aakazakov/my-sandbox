package dev.fun.tree;

import java.util.Random;

public class Main {

	static Random random = new Random();
	
	public static void main(String[] args) {
		
		int quantity = 20;
		int balanced = 0;
		
		for (int i = 0; i < quantity; i++) {
			BTreeMap<Integer, Integer> t = createRandomBTreeMap(6, -100, 100);
			if (t.isBalanced()) {
				balanced++;
			}
		}
		
		
		int percent = (balanced * 100) / quantity;
		System.out.println("The percentage of balanced trees is " + percent);		
	}
	
	static BTreeMap<Integer, Integer> createRandomBTreeMap(int depth, int minKey, int maxKey) {
		BTreeMap<Integer, Integer> tree = new BTreeMap<>();
		int currentDepth = 0;
		while (currentDepth < depth) {
			int num = random.nextInt(maxKey - minKey + 1) + minKey;
			tree.put(num, num);
			currentDepth = tree.depth();
		}
		
		return tree;
	}

}
