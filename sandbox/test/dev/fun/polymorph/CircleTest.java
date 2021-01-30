package dev.fun.polymorph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleTest {

	@Test
	void test() {
		
		Figure circle = new Circle(10.0f);
		
		float area = circle.area();
		
		assertEquals(314.0f, area);
		
	}

}
