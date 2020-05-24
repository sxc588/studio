package leetcode.t01xx.t0105;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    	if (preorder.length == 0)
    	{
    		return null;
    	}
    	
    	
    	TreeNode treeNode=  new TreeNode(preorder[0]);
  
    	int index = -1;
     	for (int i= 0; i<inorder.length; i++)
    	{
    		 if (inorder[i] == preorder[0])
    		 {
    			 index = i;
    			 break;
    		 }
    	}
    	
     	TreeNode left = buildTree(subArray(preorder,1,index), subArray(inorder,0,index-1));

     	TreeNode right = buildTree(subArray(preorder,index+1,preorder.length-1), subArray(inorder,index+1,preorder.length-1));

     	treeNode.left =left;
     	treeNode.right=right;
    	
    	return treeNode;
    }
    

    public int[] subArray(int[] preorder, int begin, int end) {

    	if(end < begin)
    	{
    		return new int[0];
    	}
    		
    	
    
    	int[] kk = new int[end-begin+1];
   
    	for (int i= 0; i<kk.length; i++)
    	{
    		 kk[i] = preorder[begin+i];
    	}
    	
    	return kk;
    }
    
    
    
}