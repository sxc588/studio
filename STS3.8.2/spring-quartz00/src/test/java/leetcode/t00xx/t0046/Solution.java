package leetcode.t00xx.t0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

    	List<List<Integer>> re = new ArrayList<List<Integer>>();

    	List<int[]> rList= permute2(nums);
    	
    	for (int[] one:rList) {
		
    		re.add(make(one));
		}
    	  
    	return  re;
    }
    
    
    public List<int[]> permute2(int[] nums) {

    	

    	List<int[]> ku = permute2(nums);
    	
    	
//    	for (int i = 0; i < nums.length; i++) {
//    	
//    		int[] ab = new int[nums.length-1];
//    		
//    		for (int j = 0; j < nums.length-1; j++) {
//    			
//    			if (i<=j)
//    			
//    		}
//    		
//    		
//    		
//    		
//    		
//    		
//    		int[] kk= new int[nums.length];
//		}
    	  
//    	return permute(lstIntegers);
    	
    	return ku;
    }
    
    
  
    
    
    
    


	private List<Integer> make(int[] nums) {
		int count = nums.length;
		List<Integer> lstIntegers = new ArrayList<Integer>(count);
		for (int k=0;k<count;k++)
		{
			lstIntegers.add( new Integer(nums[k])) ;
		}
		return lstIntegers;
	}
}