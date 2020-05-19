package leetcode.t00xx.t0007;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	@Test
	public void test() {
		org.junit.Assert.assertEquals(123, s.reverse(321));
		org.junit.Assert.assertEquals(-123, s.reverse(-321));
		org.junit.Assert.assertEquals(0, s.reverse(0));
		org.junit.Assert.assertEquals(-0, s.reverse(0));

		org.junit.Assert.assertEquals(0, s.reverse(1534236469));
	}
}
