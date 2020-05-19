package leetcode.t10xx.t1045;

import java.util.HashMap;
import java.util.Map;

/**
 * // This is MountainArray's API interface. // You should not implement it, or
 * speculate about its implementation interface MountainArray { public int
 * get(int index) {} public int length() {} }
 */

class Solution {
	public int findInMountainArray(int target, MountainArray mountainArr) {
		int maxR = max(target, mountainArr, 0, mountainArr.length() - 1);
		return maxR;
	}

	
	private  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private int get(MountainArray mountainArr, int index) {
		
		Integer key = new Integer(index);
		if (!map.containsKey(key))
		{
			Integer val = new Integer(mountainArr.get(index));
			map.put(key, val);
		}
		
		return map.get(key).intValue();
	}
	
	public int max(int target, MountainArray mountainArr, int left, int right) {

		if (left == right) {

			if (get(mountainArr,left) == target) {
				return left;
			} else {
				return -1;
			}
		}

		int valL = get(mountainArr,left);

		int valR = get(mountainArr,right);

		if (valL > target && valR > target) {

			return -1;
		}


		int mid = (left + right) / 2;

		int maxL = max(target, mountainArr, left, mid);

		if (maxL >= 0) {
			return maxL;
		}

		int maxR = max(target, mountainArr, mid + 1, right);

		return maxR;
	}

}