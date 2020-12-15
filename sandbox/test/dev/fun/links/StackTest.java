package dev.fun.links;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
	
	Stack<String> stack;
	
	@BeforeEach
	void init() {
		stack = new Stack<>();
	}

	@Test
	void check_emptiness() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void check_size() {
		assertEquals(0, stack.size());
	}
	
	@Test
	void check_push() {
		stack.push("a");
		
		assertEquals(1, stack.size());
		
		stack.push("b");
		
		assertEquals(2, stack.size());
	}
	
	@Test
	void check_peek() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		assertEquals("c", stack.peek());
	}
	
	@Test
	void check_pop() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		assertEquals("c", stack.pop());
	}
	
	@Test
	void check_search() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		assertEquals(1, stack.search("b"));
	}

}
