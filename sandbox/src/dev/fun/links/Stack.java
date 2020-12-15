package dev.fun.links;

public class Stack<E> {
	
	private DoublyLinkedList<E> list;
	
	public Stack() {
		this.list = new DoublyLinkedList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public void push(E e) {
		list.insertFirst(e);
	}
	
	public E pop() {
		return list.removeFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public E peek() {
		return list.peekFirst();
	}
	
	public int search(E e) {
		return list.indexOf(e);
	}
}
