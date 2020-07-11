package leetcode.t10xx.t1053;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	int[] make(int... vals) {
		return vals;
	}

	@Test
	public void test6() {
		System.out.println(s.maxSubArray(make(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
	}

	@Test
	public void test() {
		System.out.println(s.maxSubArray(make(1, 2, 3, 4, 5, 3, 1)));
	}
}
