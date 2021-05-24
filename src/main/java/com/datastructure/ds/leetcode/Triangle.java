package com.datastructure.ds.leetcode;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/5/24  3:51 下午
 * @description: 三角形周长
 */
public class Triangle {
    public static void main(String[] args) {

        int[] nums = {10, 9, 7, 5, 8, 6, 11};

        System.out.println(largestPerimeter(nums));
    }

    /***
     * @params
     * @return
     * @description :
     * 给定由一些正数(代表长度)组成的数组 A ，返回由其中三个长度组成的、面积不为零的三角形的最大 周长。
     * 如果不能形成任何面积不为零的三角形，返回 0 。
     * 贪心: 先小到大排序，假设最长边是最后下标，另外两条边是倒数第二和第三下标，则此时三角形周长最大
     * n < (n-1) + (n-2)，如果不成立，意味着该数组中不可能有另外两个值之和大于n，此时将n左移，重新计算
     * @author tianyu.wang
     * @date 2021/5/24 3:55 下午
     */
    static int largestPerimeter(int []nums){
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;--i){

            if(nums[i-2]+nums[i-1]>nums[i]){

                return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }

}
