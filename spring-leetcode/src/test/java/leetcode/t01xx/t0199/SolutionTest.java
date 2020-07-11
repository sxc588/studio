package leetcode.t01xx.t0199;

import org.junit.Test;

import leetcode.t01xx.t0199.Solution.TreeNode;

public class SolutionTest
{

	private static Solution s = new Solution();

	
	@Test
	public void test()
	{
		TreeNode root = makeListFunction(1,2,3,0,5,0,4);
		System.out.println(s.rightSideView(root));
	}

	private TreeNode makeListFunction(int ...ary) {
				
//		Queue<TreeNode> candiNodes = new LinkedList<TreeNode>();
//	
//		 int val = ary[0].intValue();
//		 TreeNode rooTreeNode= new Solution.TreeNode(val);
//		 candiNodes.add(new TreeNode(val));
//		
//		while (!candiNodes.isEmpty())
//		{
//			
//		}
//		 	
		return null;
	}
}
