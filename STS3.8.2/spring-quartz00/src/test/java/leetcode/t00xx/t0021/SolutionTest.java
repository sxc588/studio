package leetcode.t00xx.t0021;

import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	
	ListNode make(int ...vals)
	{
		
		ListNode root = new ListNode(vals[0]);
		ListNode tail =root;
		
		for (int i= 1; i<vals.length; i++)
		{
			tail.next =  new ListNode(vals[i]);
			tail= tail.next;
		}
		
		return root;
	}
	
	void print(ListNode node)
	{
		ListNode root = node;
		while(root != null)
		{
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}
	
	
	@Test
	public void test0()
	{
		print(make(1,2,4));
	}

	
	@Test
	public void test()
	{
		ListNode node =s.mergeTwoLists(make(1,2,4), make(1,3,4));
		print(node);
	}
}
