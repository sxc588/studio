package leetcode.t00xx.t0007;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	@SuppressWarnings("boxing")
	public int reverse(int x) {

		int flag = x > 0 ? 1 : -1;
		int absX = Math.abs(x);

		Queue<Integer> st = new LinkedList<Integer>();

		while (absX > 0) {
			st.offer(absX % 10);
			absX = absX / 10;
		}

		Long value = 0L;

		while (!st.isEmpty()) {
			Integer kv = st.poll();
			value = value * 10 + kv;
		}

		if (value > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) (value * flag);
	}
}