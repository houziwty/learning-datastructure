package com.datastructure.ds.array;

/**
 * @author : tianyu.wang
 * create at:  2021/5/18  2:56 下午
 * @description: 子数组最大平均数
 */
public class MaxAverage {
    public static void main(String[] args) {
        int []nums={6,2,7,5,4,3,1};
        System.out.println(findMaxAverage(nums,2));
    }


    static double findMaxAverage(int []nums,int k){
       int sum=0;
       int n=nums.length;
       for(int i=0;i<k;i++){
           sum+=nums[i];
       }
       int maxSum=sum;
       for(int i=k;i<n;i++){
           sum=sum-nums[i-k]+nums[i];
           maxSum=Math.max(maxSum,sum);
       }
       return 1.0*maxSum/k;
    }
}
