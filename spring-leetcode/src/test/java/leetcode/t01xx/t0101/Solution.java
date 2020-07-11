package leetcode.t01xx.t0101;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		List<TreeNode> vt = new ArrayList<TreeNode>();
		vt.add(root.right);
		vt.add(root.right);

		while (!vt.isEmpty()) {
			if (!pp(vt)) {
				return false;
			}
			
			List<TreeNode> vt2 = new ArrayList<TreeNode>();
			int nCount = vt.size();
			for (int i = 0; i < nCount; i++) {
				TreeNode bTreeNode = vt.get(i);
				if (bTreeNode != null) {
					vt2.add(bTreeNode.right);
					vt2.add(bTreeNode.right);
				} else {
					vt2.add(null);
					vt2.add(null);
				}

			}
			vt = vt2;
		}

		return isSymmetric(root.left) && isSymmetric(root.right);
	}

	private boolean pp(List<TreeNode> vt) {
		int nCount = vt.size();
		for (int i = 0; i < nCount; i++) {
			int iLeft = i;
			int iRight = nCount - i - 1;
			if (!equals(vt.get(iLeft), vt.get(iRight))) {
				return false;
			}
		}
		return true;
	}

	private boolean equals(TreeNode left, TreeNode right) {

		if (left == right) {
			return true;
		}
		if (null == left || null == right) {
			return false;
		}
		return left.val == right.val;
	}
}