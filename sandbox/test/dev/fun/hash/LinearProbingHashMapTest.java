package dev.fun.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinearProbingHashMapTest {
	
	LinearProbingHashMap<Integer, String> lphm;
	
	@BeforeEach
	void init() {
		lphm = new LinearProbingHashMap<>();
	}

	@Test
	@DisplayName("put, get, size and contains method checking")
	void test() {
		assertNotNull(lphm);
		assertEquals(0, lphm.size());
		
		lphm.put(1, "1");
		
		assertEquals(1, lphm.size());
		
		String actual = lphm.get(1);
		
		assertEquals("1", actual);
	}

}
