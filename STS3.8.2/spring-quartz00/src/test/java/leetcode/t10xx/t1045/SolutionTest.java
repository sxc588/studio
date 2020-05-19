package leetcode.t10xx.t1045;

import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();
	
	MountainArray make(int ...vals)
	{
		MountainArray root = new MountainArrayImpl(vals);
		return root;
	}
	
	

	@Test
	public void test()
	{
		System.out.println(s.findInMountainArray(5,make(1,2,3,4,5,3,1)));
	}
	
	
	@Test
	public void test2()
	{
		System.out.println(s.findInMountainArray(6,make(1,2,3,4,5,7,6,3,1)));
	}
	
	@Test
	public void test3()
	{
		System.out.println(s.findInMountainArray(1,make(1,5,2)));
	}
	
	
}
