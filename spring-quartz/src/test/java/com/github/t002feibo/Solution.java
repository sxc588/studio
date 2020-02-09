package com.github.t002feibo;

class Solution {
	
	 public String convert(String s, int numRows) {
	
		 double n = s.length();
		 
		 int t = (int) Math.ceil(n/(numRows*2-2));
		 
		 char[][][] array = new char[t][numRows][numRows-1];
		 
		 for (int i= 0 ; i<t; i++)
		 {
			 int beginIndex = (numRows*2-2)*i;
			 int endIndex = (numRows*2-2)*(i+1)+1;
			 if (endIndex>s.length())
				 endIndex= s.length();
			 
			 String sub= s.substring(beginIndex, endIndex);
			 
			 int index =0;
			 for(int ki=0,kj=0;ki<numRows && index<sub.length();ki++)
			 {
				array[i][ki][kj]=sub.charAt(index++); 
			 }
			 
			 for(int ki=1,kj=1;ki<numRows-1 && index<sub.length();ki++,kj++)
			 {
				array[i][ki][kj]=sub.charAt(index++); 
			 }
		 }
		 
		 StringBuilder sb= new StringBuilder();
		 for (int i= 0; i<numRows; i++)
		 {
			 for (int ti= 0 ; ti<t; ti++)
			 {
			 for (int j=0; j<numRows-1;j++)
			 {
	
					 if (array[ti][i][j]>0)
					 {
						 sb.append(array[ti][i][j]);
						//	System.out.print(" ");
					 }//else
						 
					 
					//System.out.print(array[ti][i][j]);
				 }
			 }
			 
			// System.out.println();
		 }
		 
		 return sb.toString();   
	    }
}