package leetcode.t00xx.t0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
          Arrays.parallelSort(nums);
        System.out.println(JSON.toJSON(nums));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j< nums.length - 1; j++) {
                int sumij = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {

                    if (sumij + nums[k] == 0) {
                        List<Integer> rs = new ArrayList<Integer>();
                        rs.add(new Integer(nums[i]));
                        rs.add(new Integer(nums[j]));
                        rs.add(new Integer(nums[k]));
                        extracted(result, rs);
                        break;
                    }
                   
                }
            }
        }
        return result;
    }

    private void extracted(List<List<Integer>> result, List<Integer> rs) {
        
        for (List<Integer> loop: result)
        {
           if (loop.containsAll(rs) && rs.containsAll(loop))
           {
                return ;
            }
        }
        result.add(rs);
    }
}