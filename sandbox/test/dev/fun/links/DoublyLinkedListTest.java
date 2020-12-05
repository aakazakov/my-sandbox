package dev.fun.links;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

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
	
	@Test
	void should_remove_first() {
		links.insertFirst(1);
		links.insertFirst(2);
		
		Integer actual = links.removeFirst();
		
		assertEquals(2, actual);
		assertEquals(1, links.size());
		assertEquals(1, links.peekLast());
		
		actual = links.removeFirst();
		
		assertEquals(1, actual);
		assertEquals(0, links.size());
		assertNull(links.peekLast());
		assertNull(links.peekFirst());
		
		actual = links.removeFirst();
		
		assertNull(actual);
	}
	
	@Test
	void should_remove_last() {
		links.insertLast(1);
		links.insertLast(2);
		
		Integer actual = links.removeLast();
		
		assertEquals(2, actual);
		assertEquals(1, links.size());
		assertEquals(1, links.peekFirst());
		
		actual = links.removeLast();
		
		assertEquals(1, actual);
		assertEquals(0, links.size());
		assertNull(links.peekLast());
		assertNull(links.peekFirst());
		
		actual = links.removeFirst();
		
		assertNull(actual);
	}
	
	@Test
	void check_index_of() {
		links.insertFirst(1);
		links.insertFirst(2);
		links.insertLast(3);
		links.insertLast(4);
		
		int actual = links.indexOf(3);
		
		assertEquals(2, actual);
		
		actual = links.indexOf(5);
		
		assertEquals(-1, actual);
	}
	
	@Test
	void should_remove_random_element() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		links.insertLast(4);
		
		boolean actual = links.remove(Integer.valueOf(2));
		
		assertTrue(actual);
		
		actual = links.remove(Integer.valueOf(5));
		
		assertFalse(actual);
		assertEquals(3, links.size());
	}
	
	@Test
	void should_remove_element_by_index() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		links.insertLast(4);
		
		Integer actual = links.remove(2);
		
		assertEquals(3, actual);
		assertEquals(3, links.size());
	}
	
	@Test
	void chould_insert_by_index() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		links.insertLast(4);
		
		links.insert(Integer.valueOf(10), 2);
		
		assertEquals(5, links.size());
		assertEquals(2, links.indexOf(Integer.valueOf(10)));
	}
	
	@Test
	void should_return_iterator() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		links.insertLast(4);
		
		Iterator<Integer> iterator = links.iterator();
		
		assertNotNull(iterator);
		
		int i = 0;
		while (iterator.hasNext()) {
			Integer actual = iterator.next();
			assertNotNull(actual);
			i++;
		}
		assertEquals(4, i);
	}
	
	@Test
	void check_contains() {
		links.insertLast(1);
		links.insertLast(2);
		links.insertLast(3);
		links.insertLast(4);
		
		boolean actual = links.contains(2);
		
		assertTrue(actual);
		
		actual = links.contains(5);
		
		assertFalse(actual);
	}
}
