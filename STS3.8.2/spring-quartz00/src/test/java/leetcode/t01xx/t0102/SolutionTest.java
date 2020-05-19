package leetcode.t01xx.t0102;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

//102. 二叉树的层序遍历
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
//示例：
//二叉树：[3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
		
public class SolutionTest
{


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
		int[] arr = new int[] { 3,9,20,0,0,15,7 };
		TreeNode root = createBinaryTreeByArray(arr, 0);
	
		Solution s = new Solution();
		List<List<Integer>> result = s.levelOrder(root);
		System.out.println(JSON.toJSON(result));
	}
}
