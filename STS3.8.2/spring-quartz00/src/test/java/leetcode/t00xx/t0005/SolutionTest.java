package leetcode.t00xx.t0005;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();
	
	int [] make(int ...vals)
	{
		return vals;
	}
	
	
	@Test
	public void test()
	{
		assertEquals("bab",s.longestPalindrome("babad"));
	}
	
	@Test
	public void test2()
	{
		assertEquals("bb",s.longestPalindrome("cbbd"));
	}
	
}