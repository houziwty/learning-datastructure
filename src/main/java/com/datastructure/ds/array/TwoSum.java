package com.datastructure.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : tianyu.wang
 * create at:  2021/5/8  10:02 上午
 * @description: 两数之和
 * 给定一个升序排列的整数数组 numbers ，
 * 从数组中找出两个数满足相加之和等于目标数 target 。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 6, 8, 9, 10};
        System.out.println(Arrays.toString(twoSum(nums, 10)));
        System.out.println(Arrays.toString(twoSumHash(nums, 10)));
        System.out.println(Arrays.toString(twoSearch(nums, 10)));
        System.out.println(Arrays.toString(twoPoint(nums, 10)));


    }

    //暴力解法
    //时间复杂度:O(N的平方) 空间复杂度:O(1)
    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //哈希表:将数组的值作为key存入map，target - num作为key
    static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    //二分查找
    //先固定一个值(从下标0开始)，
    //再用二分查找查另外一个值，找不到则固定值向右移动，继续二分查找
    //时间复杂度:O(N * logN) 空间复杂度:O(1)
    static int[] twoSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            int low = i, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[0];
    }

    //解法二:双指针
    //左指针指向数组head，右指针指向数组tail，head+tail > target 则tail 左移，否则head右移
    static int[] twoPoint(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {

            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

}
