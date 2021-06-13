package com.datastructure.ds.leetcode;

import java.util.Arrays;

/**
 * @author : tianyu.wang
 * create at:  2021/6/12  下午4:45
 * @description: 零钱兑换
 * 方法二：动态规划
 * 算法
 *
 * 我们采用自下而上的方式进行思考。仍定义 F(i)F(i) 为组成金额
 * ii 所需最少的硬币数量，假设在计算 F(i)F(i) 之前，
 * 我们已经计算出 F(0)-F(i-1)F(0)−F(i−1) 的答案。
 * 则 F(i)F(i) 对应的转移方程应为
 *
 * F(i)=\min_{j=0 \ldots n-1}{F(i -c_j)} + 1
 * F(i)=
 * j=0…n−1
 * min
 * ​
 *  F(i−c
 * j
 * ​
 *  )+1
 *
 * 其中 c_jc
 * j
 * ​
 *   代表的是第 jj 枚硬币的面值，即我们枚举最后一枚硬币面额是 c_jc
 * j
 * ​
 *  ，那么需要从 i-c_ji−c
 * j
 * ​
 *   这个金额的状态 F(i-c_j)F(i−c
 * j
 * ​
 *  ) 转移过来，再算上枚举的这枚硬币数量 11 的贡献，
 *  由于要硬币数量最少，所以 F(i)F(i)
 *  为前面能转移过来的状态的最小值加上枚举的硬币数量 11
 *

 */
public class CoinChange {

    public  static  void  main(String []args){
        int []nums=new int[]{1,2,5};
        System.out.println(coinChange(nums,11));
    }
    static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {
                    System.out.print("dp[i - coins[j]] + 1):"+(dp[i - coins[j]] + 1)+" dp[i]:"+dp[i]);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);


                    System.out.println("coins[j]:"+coins[j]+" i:"+i);
                }
            }
        }
        System.out.println("dp[amount]:"+dp[amount]);
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
