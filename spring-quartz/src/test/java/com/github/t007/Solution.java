package com.github.t007;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public int reverse(int x) {

		int flag = x > 0 ? 1 : -1;
		long absX = Math.abs(x);

		Queue<Long> st = new LinkedList<Long>();

		while (absX > 0) {
			st.offer(absX % 10);
			absX = absX / 10;
		}

		Long value = 0L;

		while (!st.isEmpty()) {
			Long kv = st.poll();
			value = value * 10 + kv;
		}

		if (value > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) (value * flag);
	}
}