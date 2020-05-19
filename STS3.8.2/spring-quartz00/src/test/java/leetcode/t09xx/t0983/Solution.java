package leetcode.t09xx.t0983;

class Solution {
	public int mincostTickets(int[] days, int[] costs) {
		if (days == null || days.length == 0 || costs == null || costs.length == 0) {
			return 0;
		}

		int max = days[days.length - 1];

		int[] dp = new int[max + 1];

		dp[0] = 0;
		for (int i : days) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= max; i++) {
			if (dp[i] == 0) {
				dp[i] = dp[i - 1];
			} else {
				int a = dp[i - 1] + costs[0];
				int b = i > 7 ? dp[i - 7] + costs[1] : costs[1];
				int c = i > 30 ? dp[i - 30] + costs[2] : costs[2];
				dp[i] = Math.min(a, Math.min(b, c));
			}
		}
		return dp[max];
	}
}