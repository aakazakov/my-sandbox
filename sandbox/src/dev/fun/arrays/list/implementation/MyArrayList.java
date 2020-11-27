package dev.fun.arrays.list.implementation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.logging.Logger;

import dev.fun.arrays.list.adapter.ListAdapter;

public class MyArrayList<T> extends ListAdapter<T> {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
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
	
	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index < 0) {
			return false;
		} 
		remove(index);
		return true;
	}
	
	@Override
	public final int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (base[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				Object obj = base[i];
				if (o.equals(obj)) return i;
			}
		}
		return -1;
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
	
	@SuppressWarnings("unchecked")
	public void bubbleSort(Comparator<T> comparator) {
		long startLog = System.currentTimeMillis();
		
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				int compare = comparator.compare((T) base[j], (T) base[j + 1]);
				if (compare > 0) {
					swap(j, j + 1);
				}
			}
		}
		
		long finishLog = System.currentTimeMillis();
		String log = String.format("Bubble sort, time: %d ms", finishLog - startLog);
		logger.info(log);
	}
	
	@SuppressWarnings("unchecked")
	public void selectionSort(Comparator<T> comparator) {
		long startLog = System.currentTimeMillis();
		
		int min;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				int compare = comparator.compare((T) base[min], (T) base[j]);
				if (compare > 0) {
					min = j;
				}
			}
			swap(i, min);
		}
		
		long finishLog = System.currentTimeMillis();
		String log = String.format("Selection sort, time: %d ms", finishLog - startLog);
		logger.info(log);
	}
	
	@SuppressWarnings("unchecked")
	public void insertionSort(Comparator<T> comparator) {
		long startLog = System.currentTimeMillis();
		
		T tmp;
		int i, j;
		for (i = 1; i < size; i++) {
			tmp = (T) base[i];
			j = i;
			while (j > 0 && comparator.compare(tmp, (T) base[j - 1]) < 0) {
				base[j] = base[j - 1];
				j--;
			}
			base[j] = tmp;
		}
		
		long finishLog = System.currentTimeMillis();
		String log = String.format("Insertion sort, time: %d ms", finishLog - startLog);
		logger.info(log);
	}
	
	private void swap(int index1, int index2) {
		Object tmp = base[index1];
		base[index1] = base[index2];
		base[index2] = tmp;
	}
	
}
