package leetcode.t02xx.t0236;


class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		boolean left = isChild(root.left, p, q);
		if (left) {
			return lowestCommonAncestor(root.left, p, q);
		}

		boolean right = isChild(root.right, p, q);
		if (right) {

			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}

	public boolean isChild(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
		{
			return false;
		}
		
		boolean bleft = isChild(root, p) && isChild(root, q);
		return bleft;
	}

	public boolean isChild(TreeNode root, TreeNode p) {

		if (root == null)
		{
			return false;
		}
		
		if (root.val == p.val) {
			return true;
		}

		boolean bleft = isChild(root.left, p);
		if (bleft) {
			return true;
		}

		boolean right = isChild(root.right, p);

		if (right) {
			return true;
		}

		return false;
	}
}