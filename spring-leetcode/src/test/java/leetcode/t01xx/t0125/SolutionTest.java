package leetcode.t01xx.t0125;

import org.junit.Test;

///125. 验证回文串
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//说明：本题中，我们将空字符串定义为有效的回文串。
//
//示例 1:
//
//输入: "A man, a plan, a canal: Panama"
//输出: true
//示例 2:
//
//输入: "race a car"
//输出: false
		
public class SolutionTest
{
	Solution s= new Solution();

	@Test
	public void testLevel() {
		boolean result = s.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(result);
	}
	
	@Test
	public void testLevel2() {
		boolean result = s.isPalindrome("race a car");
		System.out.println(result);
	}
	
	@Test
	public void testLevel3() {
		boolean result = s.isPalindrome("0P");
		System.out.println(result);
	}
}
