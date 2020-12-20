package dev.fun.hash;

public class LinearProbingHashMap<K, V> {
	
	@SuppressWarnings("unchecked")
	private final K REMOVED = (K) new Object();
	
	private int capacity = 16;
	private K[] keys;
	private V[] values;
	private int size;
	
	//for tests
	public Object[] getKeys() {
		return keys;
	}
	
	//for tests
	public Object[] getValues() {
		return values;
	}
	
	// for tests
	public Object getREMOVED() {
		return REMOVED;
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashMap() {
		keys = (K[]) new Object[capacity];
		values = (V[]) new Object[capacity];
		size = 0;
	}
	
	public boolean put(K key, V value) {
		if (haveRemainingCapacity()) {
			checkKeyIsNotNull(key);
			int index = hash(key);
			int step = step(key);
			while (keys[index] != null && !keys[index].equals(REMOVED)) {
				if (key.equals(keys[index])) {
					values[index] = value;
					return true;
				}
				index = (index + step) % capacity;
			}
			keys[index] = key;
			values[index] = value;
			size++;
			return true;
		}
		return false;
	}
	
	public V remove(K key) {
		checkKeyIsNotNull(key);
		int index = hash(key);
		int step = step(key);
		while (keys[index] != null) {
			if (key.equals(keys[index])) {
				keys[index] = REMOVED;
				V tmp = values[index];
				values[index] = null;
				size--;
				return tmp;
			}
			index = (index + step) % capacity;
		}
		return null;
	}
	
	public boolean contains(K key) {
		return get(key) != null;
	}
	
	public V get(K key) {
		checkKeyIsNotNull(key);
		int index = hash(key);
		int step = step(key);
		while (keys[index] != null) {
			if (key.equals(keys[index])) {
				return values[index];
			}
			index = (index + step) % capacity;
		}		
		return null;
	}
	
	private void checkKeyIsNotNull(K key) {
		if (key == null)
			throw new IllegalArgumentException("the key must not be null");
	}
	
	private boolean haveRemainingCapacity() {
		return size < capacity - 1;
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	private int step(K key) {
		return 7 - (key.hashCode() & 0x7fffffff) % 7;
	} 
	
	public boolean isEmpty() {
		return size != 0;
	}
	
	public int size() {
		return size;
	}
	
}
