package leetcode.t13xx.t1371;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	int[] make(int... vals) {
		return vals;
	}

	@Test
	public void test() {
		assertEquals(13, s.findTheLongestSubstring("eleetminicoworoep"));
	}

	@Test
	public void test2() {
		assertEquals(5, s.findTheLongestSubstring("leetcodeisgreat"));
	}
}
