package leetcode.t02xx.t0239;

class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {

		if (k == 1) {
			return nums;
		}

		int[] resutl = new int[nums.length - k + 1];

		int val = nums[0];

		for (int i = 0; i <= nums.length - k; i++) {
			val = maxValu(nums, i, val, k);
			resutl[i] = val;
		}
		return resutl;

	}

//	    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//	    		Output: [3,3,5,5,6,7] 
	private int maxValu(int[] nums, int begin, int preMax, int k) {

		if (begin > 0 && preMax > nums[begin + k - 1] ) {
			return preMax;
		}
		int max = nums[begin];
		for (int j = begin; j < begin + k; j++) {
			if (nums[j] > max) {
				max = nums[j];
			}
		}
		return max;
	}
}