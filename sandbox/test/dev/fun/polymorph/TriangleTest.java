package dev.fun.polymorph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void test() {
		
		Figure triangle = new Triangle(20.0f, 10.0f);
		
		float area = triangle.area();
		
		assertEquals(100.0f, area);
		
	}

}
