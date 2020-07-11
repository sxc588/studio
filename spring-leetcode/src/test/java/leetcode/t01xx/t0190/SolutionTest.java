package leetcode.t01xx.t0190;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		Assert.assertTrue(s.isAdditiveNumber("112358"));
		Assert.assertTrue(s.isAdditiveNumber("199100199"));
	}
}
