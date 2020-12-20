package dev.fun.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChainingHashMapTest {
	
	ChainingHashMap<Integer, String> chm;
	
	@BeforeEach
	void init() {
		chm = new ChainingHashMap<>();
	}

	@Test
	@DisplayName("put, get, size and contains method checking")
	void test() {
		assertNotNull(chm);
		assertEquals(0, chm.size());
		
		chm.put(1, "1");
		
		assertEquals(1, chm.size());
		
		String actual = chm.get(1);
		
		assertEquals("1", actual);
		
		assertTrue(chm.contains(1));
		assertFalse(chm.contains(5));
	}

}
