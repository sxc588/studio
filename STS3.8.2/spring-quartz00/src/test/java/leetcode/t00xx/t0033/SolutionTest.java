package leetcode.t00xx.t0033;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		Assert.assertEquals(4,s.search(new int[] {4,5,6,7,0,1,2},0));
		Assert.assertEquals(-1,s.search(new int[] {4,5,6,7,0,1,2},3));
	}
}
