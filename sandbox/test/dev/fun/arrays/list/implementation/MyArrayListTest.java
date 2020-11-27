package dev.fun.arrays.list.implementation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MyArrayList class testing...")
class MyArrayListTest {

	@Test
	void should_create_object_using_constuctor_without_args() {
		MyArrayList<Integer> testList = new MyArrayList<>();
		int testListCapacity = testList.capacity();
		int testListSize = testList.size();
		
		assertNotNull(testList);
		assertEquals(0, testListCapacity);
		assertEquals(0, testListSize);
	}
	
	@Test
	void should_create_object_by_passing_capacity_to_constuctor() {
		MyArrayList<Integer> testList = new MyArrayList<>(5);
		int testListCapacity = testList.capacity();
		int testListSize = testList.size();
		
		assertNotNull(testList);
		assertEquals(5, testListCapacity);
		assertEquals(0, testListSize);
		
		MyArrayList<Integer> testList0 = new MyArrayList<>(0);
		int testListCapacity0 = testList0.capacity();
		int testListSize0 = testList0.size();
		
		assertNotNull(testList0);
		assertEquals(0, testListCapacity0);
		assertEquals(0, testListSize0);
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			new MyArrayList<>(-2);
		});
		
		assertEquals("Capacity: -2", e.getMessage());
	}
	
	@Test
	void should_create_object_by_passing_collection_to_constuctor() {
		ArrayList<Integer> collection = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
		MyArrayList<Integer> testList = new MyArrayList<>(collection);
		
		assertNotNull(testList);
		assertEquals(collection.size(), testList.size());
	}
	
	@Test
	void check_add_at_the_end() {
		MyArrayList<Integer> testList = new MyArrayList<>();
		testList.add(5);
		int actualSize = testList.size();
		int actualCapacity = testList.capacity();
		
		assertEquals(1, actualSize);
		assertEquals(10, actualCapacity);
	}
	
	@Test
	void should_return_true_if_empty_otherwise_false() {
		MyArrayList<Integer> testList = new MyArrayList<>();		
		assertTrue(testList.isEmpty());
		
		testList.add(5);
		assertFalse(testList.isEmpty());
	}
	
	@Test
	void check_add_by_index() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(0, 1, 2, 3));
		
		testList.add(2, 10);
		assertEquals(5, testList.size());
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			testList.add(100, 10);
		});
		assertEquals("Index: 100", e.getMessage());
		
		Exception e0 = assertThrows(IllegalArgumentException.class, () -> {
			testList.add(-1, 10);
		});
		assertEquals("Index: -1", e0.getMessage());	
	}
	
	@Test
	void should_return_an_element() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(0, 1, 2, 3));	
		Integer num = testList.get(2);
		
		assertEquals(2, num);
	}
	
	@Test
	void should_remove_by_index() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(0, 1, 2, 3));
		Integer num = testList.remove(2);
		int size = testList.size();
		
		assertNotNull(num);
		assertEquals(2, num);
		assertEquals(3, size);
		assertNull(testList.get(size));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void should_return_index() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(0, 1, 2, 3));
		int index;
		
		index = testList.indexOf(3);		
		assertEquals(3,  index);
		
		index = testList.indexOf(null);
		assertEquals(-1,  index);
		
		index = testList.indexOf("3");
		assertEquals(-1,  index);
	}
	
	@Test
	void should_remove_object() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(0, 1, 2, 3));
		
		assertTrue(testList.remove(Integer.valueOf(3)));
		assertFalse(testList.remove(Integer.valueOf(100)));
		assertFalse(testList.remove(null));
	}
	
	@Test
	void check_bubble_sort() {
		MyArrayList<Integer> testList = new MyArrayList<>(Arrays.asList(3, 1, 0, 2, 5, 7, 4, 6));
		testList.bubbleSort((o1, o2) -> o1 - o2);
		int[] expectedSeq = {0, 1, 2, 3, 4, 5, 6, 7};
		for (int i = 0; i < testList.size(); i++) {
			assertEquals(expectedSeq[i], testList.get(i).intValue());
		}
	}

}
