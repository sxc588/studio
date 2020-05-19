package leetcode.t02xx.t0236;

import org.junit.Test;



//236. 二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
// 
//
//示例 1:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

public class SolutionTest
{

	private static Solution s = new Solution();
	private TreeNode createBinaryTreeByArray(int[] array, int index) {
		TreeNode tn = null;
		if (index < array.length) {
			int value = array[index];
			if (value == 0) {
				return null;
			}
			tn = new TreeNode(value);
			tn.left = createBinaryTreeByArray(array, 2 * index + 1);
			tn.right = createBinaryTreeByArray(array, 2 * index + 2);
			return tn;
		}
		return tn;
	}

	@Test
	public void testLevel() {
		int[] arr = new int[] { 3,5,1,6,2,0,8,0,0,7,4 };
		TreeNode root = createBinaryTreeByArray(arr, 0);
		
		
		TreeNode result = s.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
	System.out.println(result.val);
	}

	@Test
	public void testLevel2() {
		int[] arr = new int[] { 3,5,1,6,2,0,8,0,0,7,4 };
		TreeNode root = createBinaryTreeByArray(arr, 0);
		TreeNode result = s.lowestCommonAncestor(root,new TreeNode(5), new TreeNode(4));
		System.out.println(result.val);
	}
}
