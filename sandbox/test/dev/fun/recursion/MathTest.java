package dev.fun.recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathTest {

	@Test
	void check_power() {
		int actual = Math.power(2, 3);
		
		assertEquals(8, actual);
		
		actual = Math.power(5, 9);
		
		assertEquals(1953125, actual);
	}

}
