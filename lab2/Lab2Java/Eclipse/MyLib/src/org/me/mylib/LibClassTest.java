package org.me.mylib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibClassTest {

	@Test
	void testAcrostic() {
		System.err.println("Running testAcrostic...");
		String result = LibClass.acrostic(new String[] {"fnord", "polly", "tropism"});
		System.err.println("Finishing testAcrostic..." + result);
		assertEquals("Correct value", "foo", result);
	}

}
