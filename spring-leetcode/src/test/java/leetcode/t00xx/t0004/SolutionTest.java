package leetcode.t00xx.t0004;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();
	
	@Test
	public void test() {
		
		System.out.println(s.findMedianSortedArrays(makeArray(1, 2),makeArray(1, 2)));
		System.out.println(s.findMedianSortedArrays(makeArray(1, 3),makeArray(2)));
		System.out.println(s.findMedianSortedArrays(makeArray(1, 2),makeArray(3, 4)));
		System.out.println(s.findMedianSortedArrays(makeArray(),makeArray(3, 4)));
		System.out.println(s.findMedianSortedArrays(makeArray(3,4),makeArray()));
	}

	private int[] makeArray(int ...i) {

		return i;
	}
}
