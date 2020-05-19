package leetcode.t00xx.t0098;

class Solution {
	  public boolean isValidBST(TreeNode root) {
	    	
	      if (root == null)
	      {
	    	  return true;
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
	      
	      
	      if ( root.left != null && root.left.val >= root.val)
	      {
	    	  return false;
	      }
	      
	      if ( root.right != null && root.right.val <= root.val)
	      {
	    	  return false;
	      }

			return true;
	    }
}