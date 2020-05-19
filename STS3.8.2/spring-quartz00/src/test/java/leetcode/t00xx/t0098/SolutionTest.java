package leetcode.t00xx.t0098;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest
{

	private static Solution s = new Solution();

	
	public TreeNode createTree(int ... array) {
		// 首先将数组以节点的形式存到nodelist中,使用LinkedList的原因:LinkedList可以用作栈、队列，插入删除比较便利
		TreeNode[] nodelist = new TreeNode[array.length];
		for (int i = 0; i < array.length; i++) {
			nodelist[i] = new TreeNode(array[i]);
		}
		/*
		 * 其次按照数组转化为二叉树时节点之间的数字关系构造二叉树,根节点为0
		 * 最后一个父节点(lastParentNode=array.length/2-1;)有可能不存在右孩子,所以要单独分析
		 */
		int lastParentNode = array.length / 2 - 1; // 得到最后一个父节点的数组下标
//      构建前lastParentNode-1个父节点的二叉树关系
		for (int parentIndex = 0; parentIndex < lastParentNode; parentIndex++) {
//          构造左孩子
			nodelist[parentIndex].left = nodelist[parentIndex * 2 + 1];
//          构造右孩子
			nodelist[parentIndex].right = nodelist[parentIndex * 2 + 2];
		}
//      构造最后一个父节点的孩纸
//      左孩子
		nodelist[lastParentNode].left = nodelist[lastParentNode * 2 + 1];
//      右孩子,如果数组长度为奇数则存在右孩子,否则不存在右孩子
		if (array.length % 2 == 1) {
			nodelist[lastParentNode].right = nodelist[lastParentNode * 2 + 2];
		}
		
		return nodelist[0];
	}
	
	@Test
	public void test()
	{
		Assert.assertTrue(s.isValidBST(createTree(2,1,3)));
		Assert.assertTrue(s.isValidBST(createTree(5,1,4,0,0,3,6)));
	}
}
