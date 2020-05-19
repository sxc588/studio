package leetcode.t03xx.t0367;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		Assert.assertEquals(true,s.isPerfectSquare(16));
		Assert.assertEquals(false,s.isPerfectSquare(2147483647));
	}
}
