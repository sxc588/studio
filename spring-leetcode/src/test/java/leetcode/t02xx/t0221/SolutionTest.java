package leetcode.t02xx.t0221;

import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		char [][] aray = new char[][] {{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1' ,'1'},
		{'1', '1', '1', '1', '1'},
		{'1', '1', '0', '1', '0'}};
		System.out.println(s.maximalSquare(aray));
	}
	
	
	@Test
	public void test2()
	{
		char [][] aray = new char[][] {{'1', '0', '1', '0', '0'},
		{'1', '0', '1', '1' ,'1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'}};
		System.out.println(s.maximalSquare(aray));
	}

}
