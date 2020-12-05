package dev.fun.arrays.deque;

public class MyDequeOverflowException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MyDequeOverflowException(int baseLength) {
		super("deque overflow, max size: " + baseLength);
	}
	
	public MyDequeOverflowException() {
		
	}
	
}
