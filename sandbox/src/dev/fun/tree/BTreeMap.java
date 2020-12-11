package dev.fun.tree;

import java.util.NoSuchElementException;

public final class BTreeMap<K extends Comparable<K>, V> {

	private class Node {
		 K key;
		 V value;
		 Node left;
		 Node right;
		 int size;
		 
		 Node(K key, V value) {
			 this.key = key;
			 this.value = value;
			 this.size = 1;
		 }
	}
	
	private Node root;
	
	public void put(K key, V value) {
		checkKeyForNull(key);
		root = put(key, value, root);
	}
	
	private Node put(K key, V value, Node node) {
		if (node == null) {
			return new Node(key, value);
		}
		int result = key.compareTo(node.key);
		if (result == 0) {
			node.value = value;
		}
		if (result < 0) {
			node.left = put(key, value, node.left);
		}
		if (result > 0) {
			node.right = put(key, value, node.right);
		}
		node.size = calcSize(node);
		return node;
	}
	
	public boolean contains(K key) {
		return get(key, root) != null;
	}
	
	public V get(K key) {
		checkKeyForNull(key);
		return get(key, root);
	}
	
	private V get(K key, Node node) {
		if (node == null) {
			return null;
		}
		int result = key.compareTo(node.key);
		if (result == 0) {
			return node.value;
		}
		if (result < 0) {
			return get(key, node.left);
		}
		return get(key, node.right);
	}
	
	private void checkKeyForNull(K key) {
		if (key == null) {
			throw new IllegalArgumentException("The key must not be null");
		}
	}
	
	public void removeMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("Emptiness...");
		}
		root = removeMin(root);
	}
	
	private Node removeMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = removeMin(node.left);
		node.size = calcSize(node);
		return node;
	}
	
	public void removeMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("Emptiness...");
		}
		root = removeMax(root);
	}
	
	private Node removeMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = removeMax(node.right);
		node.size = calcSize(node);
		return node;
	}
	
	public K minKey() {
		if (isEmpty()) {
			return null;
		}
		return min(root).key;
	}
	
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}
	
	public K maxKey() {
		if (isEmpty()) {
			return null;
		}
		return max(root).key;
	}
	
	private Node max(Node node) {
		if (node.right == null) {
			return node;
		}
		return max(node.right);
	}
	
	private int calcSize(Node node) {
		return size(node.left) + size(node.right) + 1;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		return node == null ? 0 : node.size;
	}	
	
	public boolean isEmpty() {
		return root == null;
	}
	
}
