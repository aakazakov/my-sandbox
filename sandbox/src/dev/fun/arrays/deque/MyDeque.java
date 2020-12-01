package dev.fun.arrays.deque;

import java.util.NoSuchElementException;

public class MyDeque<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] base;
	private int size;
	private int begin;
	private int end;
	
	public Object[] getBase() {
		return base;
	}
	
	public MyDeque() {
		base = new Object[DEFAULT_CAPACITY];
	}
	
	public MyDeque(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity cannot be " + capacity);
		base = new Object[capacity];
	}
	
	public void insertRight(E e) throws MyDequeOverflowException {
		if (isFull())
			throw new MyDequeOverflowException(base.length);
		size++;
		base[end] = e;
		end = nextIndex(end);
	}
	
	public void insertLeft(E e) throws MyDequeOverflowException {
		if (isFull())
			throw new MyDequeOverflowException(base.length);
		size++;
		begin = previousIndex(begin);
		base[begin] = e;
	}
	
	private int nextIndex(int index) {
		return (index + 1) % base.length;
	}
	
	private int previousIndex(int index) {
		return index == 0 ? base.length - 1: index - 1;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == base.length;
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public E peakLeft() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		return (E) base[begin];
	}
	
	@SuppressWarnings("unchecked")
	public E peakRight() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		return (E) base[end - 1];
	}
	
}
