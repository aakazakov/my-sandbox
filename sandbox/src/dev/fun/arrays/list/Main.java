package dev.fun.arrays.list;

import java.util.Random;

import dev.fun.arrays.list.implementation.MyArrayList;

public class Main {
	
	public static void main(String[] args) {
		int capacity = 1000000;
		Random random = new Random();
		MyArrayList<Integer> list = new MyArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			list.add(random.nextInt(1000));
		}
		
		/* Bubble sort speed */
		// list.bubbleSort((o1, o2) -> o1 - o2);
		/*
		 		capacity | time (ms)
		 		--------------------
		 		100      | 1
		 		1000		 | 13
		 		10000    | 447
		 		100000   | 45250
		 		1000000  | very long
		 */
		
		/* Selection sort speed */
		// list.selectionSort((o1, o2) -> o1 - o2);
		/*
		 		capacity | time (ms)
		 		--------------------
		 		100      | 1
		 		1000		 | 6
		 		10000    | 71
		 		100000   | 7821
		 		1000000  | very long
		 */
		
		/* Insertion sort speed */
		// list.insertionSort((o1, o2) -> o1 - o2);
		/*
		 		capacity | time (ms)
		 		--------------------
		 		100      | 1
		 		1000		 | 7
		 		10000    | 143
		 		100000   | 14611
		 		1000000  | very long
		 */
		
	}

}
