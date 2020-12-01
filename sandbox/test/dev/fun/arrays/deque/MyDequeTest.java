package dev.fun.arrays.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyDequeTest {

	@Test
	void should_check_emptiness() {
		MyDeque<Integer> deque = new MyDeque<>();
		assertTrue(deque.isEmpty());
	}

}
