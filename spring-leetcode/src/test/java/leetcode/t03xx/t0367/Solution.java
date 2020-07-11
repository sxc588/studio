package leetcode.t03xx.t0367;

class Solution {
	public boolean isPerfectSquare(int num) {
		
		if(num == 1)
			return true;
		
		long i = 2L;
		long result = 0;
		do {
			
			result = i * i;
			if (result == num)
				return true;
			
			if (result == 0)
			{
				System.err.println(result);
			}
			
			if(num %result == 0)
			{
				num /=result;
				continue;
			}
			i++;
			if (result > num)
				return false;
			
		} while (true);
	}
}