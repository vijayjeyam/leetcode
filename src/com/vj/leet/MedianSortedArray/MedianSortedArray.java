package com.vj.leet.MedianSortedArray;

public class MedianSortedArray {
    public static void main(String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int startIndex = (length % 2 == 0 ? length / 2 : length / 2 + 1)-1;
        int endIndex = (length % 2 == 0 ? length / 2 + 1 : length / 2 + 1)-1;
        double value = 0;
        for (int i = 0, j = 0, k = 0; (i < nums1.length || j < nums2.length) && k <= endIndex; k++) {
            int current =  (get(nums1,i) > get(nums2,j)) ?
                    nums2[j++]:nums1[i++];
            if (k == startIndex) {
                value = current;
            }
            if (k == endIndex ) {
                return startIndex == endIndex ? value : (value + current )/2;
            }
        }
        return 0;
    }
    private int get(int[] nums1, int i) {
        return i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
    }
}
