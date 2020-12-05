package dev.fun.arrays.examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseStringTest {

	@Test
	void should_reverse_a_string() {
		String str = "Hello, World";
		String expected = "dlroW ,olleH";
		String reversed = ReverseString.reverse(str);
		
		assertEquals(expected, reversed);
	}

}
