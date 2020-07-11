package leetcode.t02xx.t0202;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		Assert.assertTrue(s.isHappy(19));
	}
	
	@Test
	public void test2()
	{
		Assert.assertTrue(s.isHappy(2));
	}
}
