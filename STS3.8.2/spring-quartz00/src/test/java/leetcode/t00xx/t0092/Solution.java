package leetcode.t00xx.t0092;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
    	
      if (root == null)
      {
    	  return true;
      }
      
      if ( root.left != null && root.left.val >= root.val)
      {
    	  return false;
      }
      
      if ( root.right != null && root.right.val <= root.val)
      {
    	  return false;
      }
      
      boolean bLeft = isValidBST(root.left);
      
      if (!bLeft)
      {
    	  return true;
      }
      
      boolean right =  isValidBST(root.right);
      if (!right)
      {
    	  return true;
      }
      
		return true;
    }
    
    
    public boolean m(TreeNode root) {
    	
        if (root == null)
        {
      	  return true;
        }
        
        if ( root.left != null && root.left.val >= root.val)
        {
      	  return false;
        }
        
        if ( root.right != null && root.right.val <= root.val)
        {
      	  return false;
        }
        
        boolean bLeft = isValidBST(root.left);
        
        if (!bLeft)
        {
      	  return true;
        }
        
        boolean right =  isValidBST(root.right);
        if (!right)
        {
      	  return true;
        }
        
  		return true;
      }
    
    
    
}