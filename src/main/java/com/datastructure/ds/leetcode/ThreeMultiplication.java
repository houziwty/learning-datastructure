package com.datastructure.ds.leetcode;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/5/7  5:51 下午
 * @description:三个数的最大乘积
 * 一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。 乘积不会越界
 * 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积;如果全是非正数，则最大的三个数
 * 相乘同样也为最大乘积。
 * 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数(即绝对
 * 值最大)与最大正数的乘积。
 * 分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答
 * 案。
 */
public class ThreeMultiplication {

    public static void main(String []args){
        int []nums={2,3,1,5,7,8,-1,6,-5};
       System.out.println(sort(nums));


        System.out.println(getMaxMin(nums));
    }

    /***
     * @params []
     * @return int
     * @description
     * @author tianyu.wang
     * @date 2021/5/7 5:53 下午
     */
    public static  int sort(int []nums){
        Arrays.sort(nums);
        int n=nums.length;
        System.out.println(Arrays.toString(nums));
        return Math.max(nums[0]*nums[1]*nums[2],nums[n-3]*nums[n-2]*nums[n-1]);
    }

    //线性扫描 O(N)
    static int getMaxMin(int []nums){
        // 最小的和第二小的
        int min1=0,min2=0;
        // 最大的、第二大的和第三大的
        int max1=0,max2=0,max3=0;
        for(int x:nums){
            if(x<min1){
                min2=min1;
                min1=x;
            }else {
                min2=x;
            }

            if(x>max1){
                max3=max2;
                max2=max1;
                max1=x;
            }else if(x>max2){
                max3=max2;
                max2=x;
            }else if(x>max3){
                max3=x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
