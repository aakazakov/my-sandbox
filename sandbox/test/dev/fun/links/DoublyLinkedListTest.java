package dev.fun.links;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
	
	DoublyLinkedList<Integer> links;
	
	@BeforeEach
	void init() {
		links = new DoublyLinkedList<>();
	}

	@Test
	void should_create_new_object() {
		assertNotNull(links);
		assertNull(links.peekFirst());
		assertNull(links.peekLast());
	}
	
	@Test
	void should_insert_first() {
		links.insertFirst(1);
		links.insertFirst(2);
		links.insertFirst(3);
		
		Integer actual = links.peekFirst();
		
		assertEquals(3, actual);
		assertEquals(3, links.size());
		assertEquals(1, links.peekLast());
	}

	@Test
	void should_insert_last() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		
		Integer actual = links.peekLast();
		
		assertEquals(3, actual);
		assertEquals(3, links.size());
		assertEquals(1, links.peekFirst());
	}
}
