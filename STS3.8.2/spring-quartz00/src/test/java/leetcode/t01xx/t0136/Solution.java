package leetcode.t01xx.t0136;


class Solution {
    public int singleNumber(int[] nums) {

    	for(int i= 1; i<nums.length; i++)
    	{
    		nums[0]  = nums[0] ^ nums[i];
    	}
    	return nums[0];
    }
}