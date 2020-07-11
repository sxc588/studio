package leetcode.t09xx.t0974;

class Solution {
	public int subarraysDivByK(int[] A, int K) {

		if (kk(A))
		{
			return A.length*A.length -1;
		}
		
		int result = 0;
		for (int i = 0; i < A.length; i++) {

			int sum = 0;

			for (int j = i; j < A.length; j++) {
				sum = (sum + A[j]) % K;
				if (sum == 0) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean kk(int[] a) {
		
		for (int i:a)
		{
			if(i != 0)
			{
				return false;
			}
			
		}
		return true;
	}
}