package leetcode.t00xx.t0015;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{ 
		System.out.println(JSON.toJSON(s.threeSum(make(-1, 0, 1, 2, -1, -4))));
	}

    private int[] make(int ...arr) {
        // TODO Auto-generated method stub
        return arr;
    }
}
