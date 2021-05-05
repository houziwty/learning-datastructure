package com.datastructure.ds.array;


import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/5/4  11:00 下午
 * @description:寻找数组的中心索引
 */
public class SearchIndex {

   public  static  void main(String []args){
       int[] nums = {1, 7, 3, 6, 5, 6};
       System.out.println(pivotIndex(nums));

   }
   static int pivotIndex(int []nums){
       int sum1= Arrays.stream(nums).sum();
       int sum2=0;
       for(int i=0;i<nums.length;i++){
           sum2+=nums[i];
           if(sum1==sum2){
               return i;
           }
           sum1=sum1-nums[i];
       }
       return -1;
   }
}
