package com.example.demo;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        boolean ouShu = total % 2 == 0;
        int i = 1, j = 1, result = 0;
        if (!ouShu) {
            if (nums1.length == 0) {
                return nums2[total / 2];
            }
            if (nums2.length == 0) {
                return nums1[total / 2];
            }
            while (i + j <= (total / 2 + 1)) {
                if (i > nums1.length || nums2[j - 1] < nums1[i - 1]) {
                    result = nums1[i - 1];
                    j++;
                } else if (j > nums2.length || nums1[i - 1] < nums2[j - 1]) {
                    result = nums2[j - 1];
                    i++;
                }
            }
            return result;
        } else {
            if (nums1.length == 0) {
                return nums2[total / 2 - 1] + nums2[total / 2] / 2;
            }
            if (nums2.length == 0) {
                return nums1[total / 2 - 1] + nums1[total / 2] / 2;
            }
            while (i + j <= (total / 2 + 1)) {
                if (i > nums1.length || nums2[j - 1] < nums1[i - 1]) {
                    result = nums1[i - 1];
                    j++;
                } else if (j > nums2.length || nums1[i - 1] < nums2[j - 1]) {
                    result = nums2[j - 1];
                    i++;
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        int nums1[] = {1, 3, 5, 7, 9};
        int nums2[] = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
