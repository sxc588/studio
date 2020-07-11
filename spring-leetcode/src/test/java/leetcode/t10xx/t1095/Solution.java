package leetcode.t10xx.t1095;

class Solution {
	public int jump(int[] nums) {

		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			result[i] = i;
		}

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j <= i + nums[i] && j < result.length; j++) {
				if (result[j] > result[i] + 1)
					result[j] = result[i] + 1;
			}
		}
		return result[result.length - 1];
	}
}