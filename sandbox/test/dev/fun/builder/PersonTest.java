package dev.fun.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		
		Person actual = Person.builder()
				.setFirstName("John")
				.setLastName("Doe")
				.setGender("male")
				.setPhone("+1234567890")
				.build();
		
		assertNotNull(actual);
		assertEquals("John", actual.getFirstName());
		assertEquals("Doe", actual.getLastName());
		assertEquals("male", actual.getGender());
		assertEquals("+1234567890", actual.getPhone());
		
	}

}
