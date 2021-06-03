package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/2  5:16 下午
 * @description: 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素 就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报 警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷 窃到的最高金额。
 */
public class MaxMoney {

    public static void main(String []args){

        int nums[]={2,7,9,3,1};

        System.out.println(rob(nums));
    }

    /***
     * @params [nums]
     * @return int
     * @description
     * 首先考虑最简单的情况。如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
     *
     * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k~(k>2)k (k>2) 间房屋，有两个选项：
     *
     * 偷窃第 kk 间房屋，那么就不能偷窃第 k-1k−1 间房屋，偷窃总金额为前 k-2k−2 间房屋的最高总金额与第 kk 间房屋的金额之和。
     *
     * 不偷窃第 kk 间房屋，偷窃总金额为前 k-1k−1 间房屋的最高总金额。
     *
     * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kk 间房屋能偷窃到的最高总金额。
     *
     * 用 \textit{dp}[i]dp[i] 表示前 ii 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
     *
     * \textit{dp}[i] = \max(\textit{dp}[i-2]+\textit{nums}[i], \textit{dp}[i-1])
     * dp[i]=max(dp[i−2]+nums[i],dp[i−1])
     *
     * 边界条件为：
     *
     * \begin{cases} \textit{dp}[0] = \textit{nums}[0] & 只有一间房屋，则偷窃该房屋 \\ \textit{dp}[1] = \max(\textit{nums}[0], \textit{nums}[1]) & 只有两间房屋，选择其中金额较高的房屋进行偷窃 \end{cases}
     * {
     * dp[0]=nums[0]
     * dp[1]=max(nums[0],nums[1])
     * ​
     *
     * 只有一间房屋，则偷窃该房屋
     * 只有两间房屋，选择其中金额较高的房屋进行偷窃
     * ​
     *
     *
     * 最终的答案即为 \textit{dp}[n-1]dp[n−1]，其中 nn 是数组的长度。
     *
     * @author tianyu.wang
     * @date 2021/6/2 5:20 下午
     */
    static int rob(int nums[]){
        if(nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length;
        if(length==1){
            return nums[0];
        }
        int []dp=new int [length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<length;i++){

            System.out.println("i:"+i+ "dp[i-2]:"+dp[i-2]+" nums[i]:"+nums[i]+ " dp[i-2]+nums[i]:"+(dp[i-2]+nums[i])+" dp[i-1]:"+dp[i-1]);

            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        return dp[length-1];
    }
}
