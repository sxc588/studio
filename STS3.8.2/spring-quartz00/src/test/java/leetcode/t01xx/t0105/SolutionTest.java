package leetcode.t01xx.t0105;

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



	@Test
	public void testLevel() {

		Solution s = new Solution();
		TreeNode result = s.buildTree(make(3,9,20,15,7), make(9,3,15,20,7));
		System.out.println(JSON.toJSON(result));
	}

	private int[] make(int ...i) {
		// TODO Auto-generated method stub
		return i;
	}
}
