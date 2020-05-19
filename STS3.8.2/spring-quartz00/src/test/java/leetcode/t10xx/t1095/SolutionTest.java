package leetcode.t10xx.t1095;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	int[] make(int... vals) {
		return vals;
	}

	@Test
	public void test() {
		assertEquals(3, s.jump(make(1, 2, 3, 4, 5, 3, 1)));
	}

	@Test
	public void test2() {
		assertEquals(2, s.jump(make(2, 3, 1, 1, 4)));
	}

	@Test
	public void test3() {
		assertEquals(0, s.jump(make(2)));
	}

	@Test
	public void test4() {
		assertEquals(1, s.jump(make(3, 2, 1)));
	}
}
