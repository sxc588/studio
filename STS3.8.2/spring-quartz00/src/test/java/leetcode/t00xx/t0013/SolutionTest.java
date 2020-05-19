package leetcode.t00xx.t0013;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		Assert.assertEquals(3,s.romanToInt("III"));
		Assert.assertEquals(9,s.romanToInt("IX"));
		Assert.assertEquals(58,s.romanToInt("LVIII"));
		Assert.assertEquals(1994,s.romanToInt("MCMXCIV"));
	}
}
