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
	}
	
	@Test
	void check_left_peak() throws MyDequeOverflowException {
		deque.insertLeft(1);
		deque.insertLeft(2);
		deque.insertLeft(3);
		
		Integer actual = deque.peakLeft();
		
		assertNotNull(actual);
		assertEquals(3, actual);
	}
	
	@Test
	void check_right_peak() throws MyDequeOverflowException {
		deque.insertRight(0);
		deque.insertRight(1);
		deque.insertRight(2);
		
		Integer actual = deque.peakRight();
		
		assertNotNull(actual);
		assertEquals(2, actual);
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
