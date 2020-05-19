package leetcode.t00xx.t0021;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	
	    	ListNode root = null;
	    	ListNode curr = null;
	    	
	    	ListNode loop1 = l1;
	    	ListNode loop2 =l2;
	    	while (loop1 != null || loop2 != null)
	    	{
	    		
	    		ListNode loop = null;
	    		if (loop1 == null )
	    		{
	    			loop = loop2;
	    			loop2 = loop2.next;
	    			
	    		}else if (loop2 == null ){
	    			loop = loop1;	
	    			loop1 = loop1.next;
				}    		
	    		else if (loop1.val <= loop2.val)
	    		{
	    			loop = loop1;
	    			loop1 = loop1.next;
	    		}
	    		else 
	    		{
	    			loop = loop2;	
	    			loop2 = loop2.next;
				}
	    		
	    		if (root == null)
	    		{
	    			root = loop;
	    			curr = root;
	    		}
	    		else {
	    			curr.next = loop;
	    			curr = loop;
				}
	    		
	    	}
	    	

	    	return root;
	    }
}
