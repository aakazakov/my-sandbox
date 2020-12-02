package dev.fun.arrays.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyDequeTest {
	
	MyDeque<Integer> deque;
	
	@BeforeEach
	void init() {
		deque = new MyDeque<>();
	}

	@Test
	void should_check_emptiness() {
		assertTrue(deque.isEmpty());
	}
	
	@Test
	void check_right_insert() throws MyDequeOverflowException {
		deque.insertRight(0);
		deque.insertRight(1);
		deque.insertRight(2);
		
		int size = deque.size();
		Object[] base = deque.getBase();
		
		assertEquals(3, size);
		assertEquals(0, (Integer) base[0]);
		assertEquals(1, (Integer) base[1]);
		assertEquals(2, (Integer) base[2]);
	}
	
	@Test
	void check_left_insert() throws MyDequeOverflowException {
		deque.insertLeft(1);
		deque.insertLeft(2);
		deque.insertLeft(3);
		
		int size = deque.size();
		Object[] base = deque.getBase();
		
		assertEquals(3, size);
		assertEquals(1, (Integer) base[base.length - 1]);
		assertEquals(2, (Integer) base[base.length - 2]);
		assertEquals(3, (Integer) base[base.length - 3]);
		assertEquals(7, deque.getBegin());
	}
	
	@Test
	void check_left_peak() throws MyDequeOverflowException {
		deque.insertLeft(1);
		deque.insertLeft(2);
		deque.insertLeft(3);
		
		Integer actual = deque.peekLeft();
		
		assertNotNull(actual);
		assertEquals(3, actual);
	}
	
	@Test
	void check_right_peak() throws MyDequeOverflowException {
		deque.insertRight(0);
		deque.insertRight(1);
		deque.insertRight(2);
		
		Integer actual = deque.peekRight();
		
		assertNotNull(actual);
		assertEquals(2, actual);
	}
	
	@Test
	void should_remove_and_return_an_element_to_the_left() throws MyDequeOverflowException {
		deque.insertLeft(1);
		deque.insertLeft(2);
		deque.insertLeft(3);
		
		Integer removed = deque.removeLeft();
		
		assertNotNull(removed);
		assertNull(deque.getBase()[2]);
		assertEquals(3, removed);
		assertEquals(2, deque.size());
		assertEquals(8, deque.getBegin());
	}
	
	@Test
	void should_remove_and_return_an_element_to_the_right() throws MyDequeOverflowException {
		deque.insertRight(0);
		deque.insertRight(1);
		deque.insertRight(2);
		
		Integer removed = deque.removeRight();
		
		assertNotNull(removed);
		assertNull(deque.getBase()[deque.getBase().length - 1]);
		assertEquals(2, removed);
		assertEquals(2, deque.size());
		assertEquals(2, deque.getEnd());
	}
	
	@Test
	void check_overflow_exception() {
		Exception e = assertThrows(MyDequeOverflowException.class, () -> {
			for (int i = 0; i < 11; i++) {
				deque.insertRight(i);
			}
		});
		
		assertEquals("deque overflow, max size: 10", e.getMessage());
	}

}
