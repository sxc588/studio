package leetcode.t06xx.t0680;

class Solution {
	public boolean validPalindrome(String s) {

		char ar[] = s.toCharArray();
		
		int left=0;
		int right=ar.length - 1;
		while (left < right) {
			if (ar[left] == ar[right]) {
				left++;
				right--;
			} else {
				break;
			}
		}
		boolean value = validPalindrome(ar, left + 1, right) || validPalindrome(ar, left, right - 1);
		return value;
	}

	public boolean validPalindrome(char ar[], int left, int right) {

		while (left < right) {
			if (ar[left] == ar[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
}