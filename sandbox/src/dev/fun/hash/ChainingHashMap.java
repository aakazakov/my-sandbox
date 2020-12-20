package dev.fun.hash;

import dev.fun.links.DoublyLinkedList;

public class ChainingHashMap<K, V> {
	
	private class Node {
		K key;
		V value;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity = 16;
	private DoublyLinkedList<Node>[] st;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ChainingHashMap() {
		size = 0;
		st = new DoublyLinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			st[i] = new DoublyLinkedList<>();
		}
	}
	
	public void put(K key, V value) {
		checkKeyIsNotNull(key);
		int index = hash(key);
		for (Node node: st[index]) {
			if (key.equals(node.key)) {
				node.value = value;
				return;
			}
		}
		st[index].insertLast(new Node(key, value));
		size++;
	}
	
	public boolean contains(K key) {
		return get(key) != null;
	}
	
	public V get(K key) {
		checkKeyIsNotNull(key);
		int index = hash(key);
		for (Node node: st[index]) {
			if (key.equals(node.key)) {
				return node.value;			
			}
		}
		return null;
	}
	
	private void checkKeyIsNotNull(K key) {
		if (key == null)
			throw new IllegalArgumentException("the key must not be null");
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
}
