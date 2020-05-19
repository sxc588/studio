package leetcode.t10xx.t1053;

class Solution {
	public int maxSubArray(int[] nums) {

		int maxVal = nums[0];
		int curMax = maxVal;

		for (int i = 1; i < nums.length; i++) {

			if (curMax <= 0) {
				curMax = nums[i];
			} else {

				curMax += nums[i];
			}

			if (curMax > maxVal) {
				maxVal = curMax;
			}
		}

		return maxVal;
	}
}