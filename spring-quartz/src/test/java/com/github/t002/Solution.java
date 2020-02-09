package com.github.t002;


/**
 * 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 */
class Solution {
	
	 public int cal(int n) {
		 
		 if (n<=1)
			 return n;
			 
		 return (cal(n-1)+cal(n-2));
	    }
}