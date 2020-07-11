package leetcode.btree;

import org.junit.Test;

public class SolutionTest {

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
		int[] arr = new int[] { 3, 9, 20, 0, 0, 15, 7 };
		TreeNode root = createBinaryTreeByArray(arr, 0);
	}

}
