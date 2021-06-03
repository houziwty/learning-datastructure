package com.datastructure.ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tianyu.wang
 * create at:  2021/6/3  10:54 上午
 * @description: 连续数组
 * 方法一：前缀和 + 哈希表
 * 由于「00 和 11 的数量相同」等价于「11 的数量减去 00 的数量等于 00」，我们可以将数组中的 00 视作 -1−1，则原问题转换成「求最长的连续子数组，其元素和为 00」。
 *
 * 设数组 \textit{nums}nums 的长度为 nn，将数组 \textit{nums}nums 进行转换得到长度相等的新数组 \textit{newNums}newNums：对于 0 \le i<n0≤i<n，当 \textit{nums}[i]=1nums[i]=1 时 \textit{newNums}[i]=1newNums[i]=1，当 \textit{nums}[i]=0nums[i]=0 时 \textit{newNums}[i]=-1newNums[i]=−1。
 *
 * 为了快速计算 \textit{newNums}newNums 的子数组的元素和，需要首先计算 \textit{newNums}newNums 的前缀和。用 \textit{prefixSums}[i]prefixSums[i] 表示 \textit{newNums}newNums 从下标 00 到下标 ii 的前缀和，则 \textit{newNums}newNums 从下标 j+1j+1 到下标 kk（其中 j<kj<k）的子数组的元素和为 \textit{prefixSums}[k]-\textit{prefixSums}[j]prefixSums[k]−prefixSums[j]，该子数组的长度为 k-jk−j。
 *
 * 当 \textit{prefixSums}[k]-\textit{prefixSums}[j]=0prefixSums[k]−prefixSums[j]=0 时，即得到 \textit{newNums}newNums 的一个长度为 k-jk−j 的子数组元素和为 00，对应 \textit{nums}nums 的一个长度为 k-jk−j 的子数组中有相同数量的 00 和 11。
 *
 * 实现方面，不需要创建数组 \textit{newNums}newNums 和 \textit{prefixSums}prefixSums，只需要维护一个变量 \textit{counter}counter 存储 \textit{newNums}newNums 的前缀和即可。具体做法是，遍历数组 \textit{nums}nums，当遇到元素 11 时将 \textit{counter}counter 的值加 11，当遇到元素 00 时将 \textit{counter}counter 的值减 11，遍历过程中使用哈希表存储每个前缀和第一次出现的下标。
 *
 * 规定空的前缀的结束下标为 -1−1，由于空的前缀的元素和为 00，因此在遍历之前，首先在哈希表中存入键值对 (0,-1)(0,−1)。遍历过程中，对于每个下标 ii，进行如下操作：
 *
 * 如果 \textit{counter}counter 的值在哈希表中已经存在，则取出 \textit{counter}counter 在哈希表中对应的下标 \textit{prevIndex}prevIndex，\textit{nums}nums 从下标 \textit{prevIndex}+1prevIndex+1 到下标 ii 的子数组中有相同数量的 00 和 11，该子数组的长度为 i-\textit{prevIndex}i−prevIndex，使用该子数组的长度更新最长连续子数组的长度；
 *
 * 如果 \textit{counter}counter 的值在哈希表中不存在，则将当前余数和当前下标 ii 的键值对存入哈希表中。
 *
 * 由于哈希表存储的是 \textit{counter}counter 的每个取值第一次出现的下标，因此当遇到重复的前缀和时，根据当前下标和哈希表中存储的下标计算得到的子数组长度是以当前下标结尾的子数组中满足有相同数量的 00 和 11 的最长子数组的长度。遍历结束时，即可得到 \textit{nums}nums 中的有相同数量的 00 和 11 的最长子数组的长度。
 */
public class FindMaxLength {
    public static void main(String[] args) {
        int []nums = {0,1,0,0};
        System.out.println(findMaxLentt(nums));
    }

    static  int findMaxLentt(int []nums){
        int maxLength=0;
        Map<Integer,Integer> map=new HashMap<>();
        int counter=0;
        map.put(counter,-1);
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];

            if(num==1){
                counter++;
            }else {
                counter--;
            }
            if(map.containsKey(counter)){
                int prevIndex=map.get(counter);
                System.out.println( "num:"+num+ " counter:"+counter+" prevIndex:"+prevIndex+" i:"+i+" i-prevIndex:"+(i-prevIndex));
                maxLength=Math.max(maxLength,i-prevIndex);
            }else {
                map.put(counter,i);
            }
        }
        return maxLength;
    }
}
