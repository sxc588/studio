package leetcode.t00xx.t0005;

/**
 * 6. Z 字形变换
 */

class Solution {
	public String longestPalindrome(String s) {

		if (s== null || s.length() ==0)
		{
			return s;
		}
		
		
		char[] array = s.toCharArray();

		String subStr = new String(array, 0, 1);

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (longestPalindrome(array, i, j)) {
					if (j - i >= subStr.length()) {
						subStr = new String(array, i, j - i + 1);
					}
				}
			}
		}

		return subStr;

	}

	public boolean longestPalindrome(char[] array, int i, int j) {

		while (j > i) {
			if (array[i++] != array[j--]) {
				return false;
			}

		}
		return true;
	}

}