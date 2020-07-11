package leetcode.t07xx.t0639;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class SolutionTest {

    private static Solution s = new Solution();

    @Test
	public void test()
	{
//	    temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
//
//	            来源：力扣（LeetCode）
//	            链接：https://leetcode-cn.com/problems/daily-temperatures
//	            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		System.out.println(JSON.toJSON(s.dailyTemperatures(make(73, 74, 75, 71, 69, 72, 76, 73))));
	}
    
    @Test
    public void test2()
    {
//      temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
//
//              来源：力扣（LeetCode）
//              链接：https://leetcode-cn.com/problems/daily-temperatures
//              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        System.out.println(JSON.toJSON(s.dailyTemperatures(make(55,38,53,81,61,93,97,32,43,78))));
    }


    private int[] make(int... ary) {
        return ary;
    }
}
