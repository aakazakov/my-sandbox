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
		
		lphm.put(1, "5");
		
		actual = lphm.get(1);
		
		assertEquals("5", actual);
	}
	
	@Test
	void checkRemove() {
		lphm.put(0, "0");
		lphm.put(1, "1");
		lphm.put(2, "2");
		lphm.put(3, "3");
		lphm.put(4, "4");
		lphm.put(5, "5");
		lphm.put(6, "6");
		lphm.put(7, "7");
		lphm.put(8, "8");
		
		assertEquals(9, lphm.size());
		
		String actual = lphm.remove(5);
		
		assertEquals("5", actual);	
		assertEquals(8, lphm.size());
		
		Object[] keys = lphm.getKeys();
		
		assertEquals(lphm.getREMOVED(), keys[5]);
		
		Object[] values = lphm.getValues();
		
		assertNull(values[5]);
		
		lphm.put(5, "15");
		
		assertEquals(5, keys[5]);
		assertEquals("15", values[5]);
		
		// if an occupied slot contains REMOVED (Object),
		// the new key should occupy this slot
		lphm.remove(5);
		lphm.put(16, "16");
		
		assertEquals(16, keys[5]);
		assertEquals("16", values[5]);	
		assertEquals("16", lphm.get(16));
	}

}
