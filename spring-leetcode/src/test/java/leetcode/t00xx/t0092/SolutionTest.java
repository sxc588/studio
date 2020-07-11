package leetcode.t00xx.t0092;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 98. 验证二叉搜索树
 */
public class SolutionTest {

	private static Solution s = new Solution();

	TreeNode make(int... vals) {

//		TreeNode treeNode = new TreeNode(vals[0]);
//		
//		Queue<TreeNode> laysNodes = new LinkedList<TreeNode>(); 
//		
//		laysNodes.add(treeNode);

		TreeNode[] treeNode = new TreeNode[vals.length];

		for (int i = 0; i < vals.length; i++) {
			if (vals[i] > 0) {
				treeNode[i] = new TreeNode(vals[i]);
			}
		}

		for (int n = 0; 2 * n + 1 < vals.length; n++) {
			int left = 2 * n + 1;
			int right = 2 * n + 2;

			if (treeNode[n] != null) 
			{
				treeNode[n].left = treeNode[left];
			
				if (right<vals.length)
				treeNode[n].right = treeNode[right];
			}
		}
		return treeNode[0];
	}

	@Test
	public void test00() {
		assertTrue(s.isValidBST(make(0)));
	}

	@Test
	public void test0() {
		assertTrue(s.isValidBST(make(2)));
	}

	@Test
	public void test1() {
		assertTrue(s.isValidBST(make(2, 1, 3)));
	}

	@Test
	public void test2() {
		assertFalse(s.isValidBST(make(5, 1, 4, 0, 0, 3, 6)));
	}

	@Test
	public void test57() {
		assertFalse(s.isValidBST(make(1, 1)));
	}
	
	
	@Test
	public void test58() {
		assertFalse(s.isValidBST(make(10,5,15,0,0,6,20)));
	}

}
