package com.github.t0190;

import java.util.LinkedList;
import java.util.Queue;

class Solution
{

	public long reverseBits(long x)
	{

		Queue<Long> st = new LinkedList<Long>();

		long absX = x;

		while (absX > 0)
		{
			st.offer(absX % 2);
			absX = absX / 2;
		}

		long value = 0L;

		int i = 0;

		while (i < 32)
		{

			Long kv = st.isEmpty() ? 0L : st.poll();
			value = value * 2 + kv;

			i++;
		}

		// if (value > Integer.MAX_VALUE) {
		// return 0;
		// }

		return (int) value;
	}
}