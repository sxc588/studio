package leetcode.t00xx.t0006;

/**
 * 6. Z 字形变换
 */

class Solution {
	public String convert(String s, int numRows) {

		int length = s.length();

		int n = length / numRows;

		if (length % numRows > 0) {
			n += 1;
		}

		char[][] array = new char[numRows][(numRows - 1) * n];
		char[] chars = s.toCharArray();

		int delta = numRows + numRows - 2;

		for (int i = 0; i < n; i++) {
			int j = i * delta;
			for (int row = 0; row < numRows && j < length; row++) {
				int col = i * numRows;
				array[row][col] = chars[j++];
			}

			for (int row = 1; row < numRows - 1 && j < length; row++) {
				int col = i * numRows + 1;
				array[row][col] = chars[j++];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {

			for (int j = 0; j < (numRows - 1) * n; j++) {
				if (array[i][j] != '\0') {
					sb.append(array[i][j]);
				}
			}
		}

		return sb.toString();
	}
}