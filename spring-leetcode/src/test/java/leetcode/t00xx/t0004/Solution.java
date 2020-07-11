package leetcode.t00xx.t0004;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int nCount1 = nums1.length;
		int nCount2 = nums2.length;

		int mid1 = (nCount1 + nCount2 - 1) / 2;
		int mid2 = (nCount1 + nCount2) / 2;

		int val1 = 0;
		int val2 = 0;

		int k1 = 0;
		int k2 = 0;
		for (int i = 0; i <= mid2; i++) {

			int val = 0;
			if (k1 < nCount1 && k2 < nCount2) {
				if (nums1[k1] <= nums2[k2]) {
					val = nums1[k1++];
				} else {
					val = nums2[k2++];
				}
			} else if (k1 < nCount1) {
				val = nums1[k1++];
			} else {
				val = nums2[k2++];
			}

			if (i == mid1) {
				val1 = val;
			}
			if (i == mid2) {
				val2 = val;
			}
		}
		return (val1 + val2) / 2.0;

	}
}