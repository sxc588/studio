package leetcode.t07xx.t0639;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            
  
            int j = i;
            while ((j+1) < T.length ) {
                j++;
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}