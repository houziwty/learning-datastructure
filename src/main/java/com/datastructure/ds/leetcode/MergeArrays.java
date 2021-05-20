package com.datastructure.ds.leetcode;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/5/17  5:22 下午
 * @description: 合并数组
 * 两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
 * 使 nums1 成为一个有序数组。 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 假设 nums1 的空间大小等于 m + n，这样它就
 * 有足够的空间保存来自 nums2 的元素。
 */
public class MergeArrays {
    public static void main(String[] args) {


        int nums1[] = {1, 2, 3, 0, 0, 0}, nums2[] = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    //    解法二:双指针 从前往后
//    将两个数组按顺序进行比较，放入新的数组
//            从后往前
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}
