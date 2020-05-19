package leetcode.t00xx.t0001;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

	
	private static Solution s = new Solution();
	
	int[] make(int... vals) {
		return vals;
	}

	void print(int... vals) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int val:vals)
		{
			if (sb.length()>0)
			{
				sb.append(",");
			}
			sb.append(val);
		}
		System.out.println("[" + sb.toString() + "]");
	}
	
	@Test
	public void test() {
		int [] resut = s.twoSum(make(2, 7, 11, 15), 9);
		print(resut);
		assertArrayEquals(make(0,1), resut);	
	}

}
