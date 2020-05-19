package leetcode.t06xx.t0680;

import org.junit.Test;



//680. 验证回文字符串 Ⅱ
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
//示例 1:
//
//输入: "aba"
//输出: True
//示例 2:
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//注意:
//
//字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
public class SolutionTest
{

	private static Solution s = new Solution();

	@Test
	public void test()
	{
		System.out.println(s.validPalindrome("aba"));
	}
	
	
	@Test
	public void test2()
	{
		System.out.println(s.validPalindrome("abca"));
	}

	
	@Test
	public void test32()
	{
		System.out.println(s.validPalindrome("abc"));
	}
}
