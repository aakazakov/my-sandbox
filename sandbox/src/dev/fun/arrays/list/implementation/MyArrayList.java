package dev.fun.arrays.list.implementation;

import java.util.Arrays;
import java.util.Collection;

import dev.fun.arrays.list.adapter.ListAdapter;

public class MyArrayList<T> extends ListAdapter<T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] BASIC_INITIALIZATION = {};
	private Object[] base;
	private int size;
	
	public MyArrayList() {
		this.base = BASIC_INITIALIZATION;
	}
	
	public MyArrayList(int capacity) {
		if (capacity < 0) 
			throw new IllegalArgumentException("Capacity: " + capacity);
		else if (capacity == 0) 
			this.base = BASIC_INITIALIZATION;
		else 
			this.base = new Object[capacity];
	}
	
	public MyArrayList(Collection<? extends T> collection) {
		Object[] arr = collection.toArray();
		this.size = arr.length;
		if (size == 0) {
			this.base = BASIC_INITIALIZATION;
		} else {
			if (collection.getClass() == this.getClass()) {
				this.base = arr;
			} else {
				this.base = Arrays.copyOf(arr, size, Object[].class);
			}
		}
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void add(int index, T element) {
		check(index);
		if (freeCapacity() > 0) {
			addByIndex(index, element);
		} else {
			increaseCapacity();
			addByIndex(index, element);
		}
	}
	
	private void addByIndex(int index, T element) {
		for (int i = size; i > index; i--) {
			base[i] = base[i - 1];
		}
		base[index] = element;
		size++;
	}

	@Override
	public boolean add(T e) {	
		if (freeCapacity() > 0) {
			addAtTheEnd(e);
		} else {
			increaseCapacity();
			addAtTheEnd(e);
		}	
		return true;
	}
	
	private void addAtTheEnd(T e) {
		base[size] = e;
		size++;
	}
	
	private int freeCapacity() {
		return base.length - size;
	}
	
	private void increaseCapacity() {
		int newCapacity = base.length + DEFAULT_CAPACITY;
		Object[] tmp = new Object[newCapacity];
		System.arraycopy(base, 0, tmp, 0, size);
		base = tmp;
	}
	
	public int capacity() {
		return base.length;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		check(index);
		return (T) base[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		check(index);
		T removed = (T) base[index];
		for (int i = index; i < size - 1; i++) {
			base[i] = base[i + 1];
		}
		size--;
		base[size] = null;
		return removed;
	}
	
	private void check(int index) {
		if (index > size || index < 0)
			throw new IllegalArgumentException("Index: " + index);
	}
	
}
