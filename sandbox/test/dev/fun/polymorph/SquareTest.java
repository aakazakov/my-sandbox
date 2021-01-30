package dev.fun.polymorph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void test() {
		
		Figure square = new Square(10.0f, 20.0f);
		
		float area = square.area();
		
		assertEquals(200.0f, area);
	}

}
