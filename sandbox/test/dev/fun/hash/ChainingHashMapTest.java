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
	
	@Test
	void checkRemove() {
		chm.put(1, "1");
		chm.put(2, "2");
		chm.put(3, "3");
		chm.put(4, "4");
		chm.put(5, "5");
		chm.put(6, "6");
		chm.put(7, "7");
		chm.put(8, "8");
		
		assertEquals(8, chm.size());
		
		String actual = chm.remove(5);
		
		assertEquals("5", actual);
		assertFalse(chm.contains(5));
		assertEquals(7, chm.size());
		
		actual = chm.remove(10);
		
		assertNull(actual);
	}

}
