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
   /***
    * @params [nums]
    * @return int
    * @description 数组中某一个下标，左右两边的元素之后相等，该下标即为中心索引
    * 思路:先统计出整个数组的总和，然后从第一个元素开始叠加
    * 总和递减当前元素，叠加递增当前元素，知道两个值相等
    * @author tianyu.wang
    * @date 2021/5/6 4:48 下午
    */
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
