package dev.fun.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BTreeMapTest {

	BTreeMap<Integer, String> map;
	
	@BeforeEach
	void init() {
		map = new BTreeMap<>();
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(map.isEmpty());
		assertEquals(0, map.size());
	}
	
	@Test
	void testPut() {
		map.put(1, "1");
		map.put(2, "2");
		
		assertEquals(2, map.size());
	}
	
	@Test
	void testGet() {
		map.put(10, "10");
		map.put(2, "2");
		map.put(15, "15");
		map.put(7, "7");
		map.put(11, "11");
		map.put(22, "22");
		
		assertEquals("11", map.get(11));
	}
	
	@Test
	void testContains() {
		map.put(10, "10");
		map.put(2, "2");
		map.put(15, "15");
		map.put(7, "7");
		map.put(11, "11");
		map.put(22, "22");
		
		assertTrue(map.contains(2));
		assertFalse(map.contains(100));
	}
	
	@Test
	void testMinKey() {
		map.put(10, "10");
		map.put(2, "2");
		map.put(15, "15");
		map.put(7, "7");
		map.put(11, "11");
		map.put(22, "22");
		
		assertEquals(2, map.minKey());
	}
	
	@Test
	void testMaxKey() {
		map.put(10, "10");
		map.put(2, "2");
		map.put(15, "15");
		map.put(7, "7");
		map.put(11, "11");
		map.put(22, "22");
		
		assertEquals(22, map.maxKey());
	}

}
