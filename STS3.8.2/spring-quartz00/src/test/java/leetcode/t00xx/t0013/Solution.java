package leetcode.t00xx.t0013;

class Solution {

//	Assert.assertEquals(3,s.romanToInt("III"));
//	Assert.assertEquals(4,s.romanToInt("IV"));
//	Assert.assertEquals(9,s.romanToInt("IX"));
//	Assert.assertEquals(58,s.romanToInt("LVIII"));
//	Assert.assertEquals(1994,s.romanToInt("MCMXCIV"));

	public int romanToInt(String s) {

		char[] chars = s.toCharArray();

		int preV = get(chars[0]);
		int tatal = preV;
		for (int i = 1; i < s.length(); i++) {
			int curV = get(chars[i]);
			if (curV > preV) {
				tatal = curV - tatal;
			} else {
				tatal = curV + tatal;
			}
		}
		return tatal;
	}

	int get(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}