package leetcode.t00xx.t0006;

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
		assertEquals("LCIRETOESIIGEDHN",s.convert("LEETCODEISHIRING", 3));
	}
	
	@Test
	public void test2()
	{
		assertEquals("LEE",s.convert("LEE", 3));
	}
	
}