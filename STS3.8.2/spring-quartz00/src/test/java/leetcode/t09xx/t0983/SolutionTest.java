package leetcode.t09xx.t0983;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	int[] make(int... vals) {
		return vals;
	}

	@Test
	public void test() {
		assertEquals(11, s.mincostTickets(make(1,4,6,7,8,20), make(2,7,15)));
	}

	@Test
	public void test2() {
		assertEquals(17, s.mincostTickets(make(1,2,3,4,5,6,7,8,9,10,30,31), make(2,7,15)));
	}
}
