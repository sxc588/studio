package leetcode.t09xx.t0974;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();

	int[] make(int... vals) {
		return vals;
	}

	@Test
	public void test() {
		System.out.println(s.subarraysDivByK(make(4,5,0,-2,-3,1), 5));
	}
	
	@Test
	public void test2() {
		System.out.println(s.subarraysDivByK(make(0,0), 5));
	}
}
