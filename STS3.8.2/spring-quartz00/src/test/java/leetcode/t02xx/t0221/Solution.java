package leetcode.t02xx.t0221;

class Solution {
    public int maximalSquare(char[][] matrix) {

    	int rowLen = matrix.length;
    	if (rowLen == 0)
    	{
    		return 0;
    	}
    	
    	int colLen = matrix[0].length;
    	
    	if (colLen == 0)
    	{
    		return 0;
    	}
    	
    	
    	
    	int max=0;
    	
    	for(int row= 0; row<rowLen; row++)
    	{
    		for(int col= 0; col<colLen; col++)
    		{
    			if (matrix[row][col] !='0')
    			{
    				int curnt = kk(matrix, row, col);
    				if (curnt>max)
    				{
    					max = curnt;
    					col +=curnt-1;
    				}
    			}
    			
    		}
    	}
    	return max*max;
    }

	private int kk(char[][] matrix, int row, int col) {
		
		int rowLen = matrix.length;
    	int colLen = matrix[0].length;
    	int i= 1;
		for (; i+row< rowLen && i+col< colLen;i++ )
		{			
			for (int j= 0; j<=i;j++)
			{
				if (matrix[row+j][i+col] =='0' || matrix[row+i][col+j]=='0')
				{
					return i;
				}	
			}
		}
		return i;
	}
}