package leetcode.t01xx.t0102;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> arrayList = new ArrayList<List<Integer>>();

		if(root == null)
		{
			return arrayList;
		}
		List<TreeNode> parents = new ArrayList<TreeNode>();
		parents.add(root);
		while (!parents.isEmpty()) {
			List<TreeNode> sub = new ArrayList<TreeNode>();
			List<Integer> vals = new ArrayList<Integer>();
			for (TreeNode cur : parents) {
				vals.add(new Integer(cur.val));
				if (cur.left != null)

					sub.add(cur.left);
				if (cur.right != null)
					sub.add(cur.right);
			}
			if (!vals.isEmpty()) {
				arrayList.add(vals);
			}

			parents = sub;

		}

		return arrayList;
	}
}