package dev.fun.links;

public final class DoublyLinkedList<E> {
	
	private class Node {
		E value;
		Node next;
		Node prev;
		
		Node(E value) {
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public void insert(E e, int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("argument cannot be: " + index);
		}
		if (index == 0) {
			insertFirst(e);
		}
		if (index == size - 1) {
			insertLast(e);
		}
		Node current = first.next;
		for (int i = 1; i < index - 1; i++) {
			current = current.next;
		}
		Node node = new Node(e);
		node.next = current.next;
		node.prev = current;
		current.next.prev = node;
		current.next = node;
		size++;
	}
	
	public void insertFirst(E e) {
		Node node = new Node(e);
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
		Node node = new Node(e);
		if (isEmpty()) {
			first = node;
		} else {
			node.prev = last;
			last.next = node;
		}
		last = node;
		size++;
	}
	
	public boolean remove(E e) {
		if (isEmpty()) {
			return false;
		}
		if (first.value.equals(e)) {
			removeFirst();
			return true;
		}
		Node current = first.next;
		while (current != null && !current.value.equals(e)) {
			current = current.next;
		}
		if (current == null) {
			return false;
		}
		if (last.value.equals(current)) {
			removeLast();
			return true;
		}
		current.prev.next = current.next;
		current.next.prev = current.prev;
		size--;
		return true;
	}
	
	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("argument cannot be: " + index);
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		Node current = first.next;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		E tmp = current.value;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		size--;
		return tmp;
	}
	
	public E removeFirst() {
		E tmp = peekFirst();
		if (tmp == null) {
			return null;
		}
		first = first.next;
		if (isEmpty()) {
			last = null;
		} else {
			first.prev = null;
		}
		size--;
		return tmp;
	}
	
	public E removeLast() {
		E tmp = peekLast();
		if (tmp == null) {
			return null;
		}
		last = last.prev;
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
		size--;
		return tmp;
	}
	
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}
		
	public int indexOf(E e) {
		Node current = first;
		int index = 0;
		while(current != null) {
			if (current.value.equals(e)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
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
