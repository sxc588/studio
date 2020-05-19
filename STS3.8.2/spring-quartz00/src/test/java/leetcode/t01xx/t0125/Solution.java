package leetcode.t01xx.t0125;

class Solution {
	public boolean isPalindrome(String s) {

		int left = 0;
		int right = s.length()-1;

		while (left < right) {
			if (isNotNumber(s.charAt(left)) && isNotAlpha(s.charAt(left))) {
				left++;
				continue;
			}

			if (isNotNumber(s.charAt(right)) &&  isNotAlpha(s.charAt(right))) {
				right--;
				continue;
			}

			if (isEqualAlpha(s.charAt(left), s.charAt(right))) {
				left++;
				right--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isEqualAlpha(char charAt, char charAt2) {
		
		if (charAt == charAt2)
		{
			return  true;
		}
		
		if (isNotAlpha(charAt)) {
		return false;
		}

		if (isNotAlpha(charAt2)) {
		return false;
		}
		
		
		
		int delt =charAt - charAt2;
		int delt0= 'a' -'A';
		
		if (delt - delt0 == 0 || delt + delt0== 0)
		{
			return  true;
		}
		
		
		return false;
	}

	private boolean isNotNumber(char charAt) {
		if (charAt >= '0' && charAt <= '9') {
			return false;
		}
		return true;
	}
	
	
	
	private boolean isNotAlpha(char charAt) {

		if (charAt >= 'a' && charAt <= 'z') {
			return false;
		}
		if (charAt >= 'A' && charAt <= 'Z') {
			return false;
		}
		return true;
	}
}