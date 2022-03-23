package fis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
	void testAdd() {
		int a = 10;
		int b = 20;
		int expected = 20;
		int result  = MathUtil.add(a, b);
		assertEquals(expected, result);
	}

}
