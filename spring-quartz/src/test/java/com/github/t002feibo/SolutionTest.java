package com.github.t002feibo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	private static Solution s = new Solution();
	@Test
	public void test() {
		System.out.println(s.convert("LEETCODEISHIRING", 3));
	}

	@Test
	public void test2() {
		System.out.println(s.convert("PAYPALISHIRING", 4));
	}

}
