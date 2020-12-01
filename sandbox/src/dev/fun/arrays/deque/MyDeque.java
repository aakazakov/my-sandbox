package dev.fun.arrays.deque;

public class MyDeque<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] base;
	private int size;
	private int begin;
	private int end;
	
	public MyDeque() {
		base = new Object[DEFAULT_CAPACITY];
	}
	

	public MyDeque(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity cannot be " + capacity);
		base = new Object[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
}
