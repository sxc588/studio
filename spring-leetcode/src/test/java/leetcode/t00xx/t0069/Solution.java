package leetcode.t00xx.t0069;

class Solution {
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}

		long i = 1;
		
		int t= 1;
		
		long k = (i + 1) * (i + 1);
		
		while (k <= x) {
			
		if (x%k == 0)
		{
			t *= i;
			i= 1;
		}
			i++;
			k = (i + 1) * (i + 1);
		}
		return (int) i*t;
	}
}