package dev.fun.links;

public final class DoublyLinkedList<E> {
	
	@SuppressWarnings("hiding")
	private class Node<E> {
		E value;
		@SuppressWarnings("unused")
		Node<E> next;
		@SuppressWarnings("unused")
		Node<E> prev;
		
		public Node(E value) {
			this.value = value;
		}
	}
	
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public void insertFirst(E e) {
		Node<E> node = new Node<>(e);
		node.next = first;
		if (isEmpty()) {
			last = node;
		} else {
			first.prev = node;
		}
		first = node;
		size++;
	}
	
	public void insertLast(E e) {
		Node<E> node = new Node<>(e);
		node.next = last;
		if (isEmpty()) {
			first = node;
		} else {
			node.prev = last;
			last.next = node;
		}
		last = node;
		size++;
	}
	
	public E peekFirst() {
		return isEmpty() ? null : first.value;
	}
	
	public E peekLast() {
		return isEmpty() ? null : last.value;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
}
