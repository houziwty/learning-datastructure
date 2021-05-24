package com.datastructure.ds.leetcode.dp;

/**
 * @author : tianyu.wang
 * create at:  2021/3/9  4:09 下午
 * @description:
 * 小偷去某商店盗窃，背有一个背包，容量是50kg，现在有以下物品（物品不能切分,且只有一个），请问小偷应该怎么拿才能得到最大的价值？
 * 	  重量    价值
 * 物品1   10kg    60元   60 / 10 = 6
 * 物品2   20kg    100元   100/20 = 5
 * 物品3   40kg    120元   120/40 = 3
 * 性价比最高：贪心的策略，按性价比排序,得到的最大价值是 60+100=160，背包装了30kg
 * 很显然：40+10（kg）=120+60=180
 * 遍历它：每个物品只有2个选择就是拿与不拿吧，我们就用枚举，排列组合；
 * 3：000 111 011 010 001 100 101 110 ，有没有道理. 10个物品 有多少排列组合？10! 20!,10一下是完美的，32！
 *
 * 一般用动态规划可以解决的问题：
 * 1.局部最优解：也就是它会有一个最优子结构
 * 2.子问题可以重复
 * 3.状态转移方程：通过把问题分成很多小阶段一段段的转移。
 * 从而得出最优解.状态转移方程是解决动态规划的关键。
 * 如果我们能写出状态转移方程，
 * 那动态规划问题基本上就解决一大半了，
 * 翻译成代码非常简单。但是很多动态规划问题的状态本身就不好定义，状态转移方程也就更不好想到。
 */
public class DP {
    public static void main(String[]args){
        int value[]={60,100,120};//价值
        int weigth[]={10,20,40};//重量 购物车那个问题 只需要一个价值就行了，重量都都没有。
        int w=50;//背包重量
        int n=3;//有3个物体
        int dp[][]=new int[n+1][w+1];//n表示是物品，w表示重量,初始化全是0

        System.out.println("初始化"+dp[n][w]);

        for(int i=1;i<=n;i++){//每次加的物品
            for(int cw=1;cw<=w;cw++){//分割的背包
                if(weigth[i-1]<=cw){//表示这个物品可以装进去
                    System.out.println("cw="+cw+"  weigth:"+weigth[i-1]);
                    dp[i][cw]=Math.max(value[i-1]+dp[i-1][cw-weigth[i-1]],dp[i-1][cw]);
                    System.out.println("装进去:"+dp[i][cw]);
                }else {
                    dp[i][cw]=dp[i-1][cw];//不能装
                    System.out.println("不能装进去:"+dp[i][cw]);
                }
            }

        }
        System.out.println("n:"+n+" w:"+w);
        System.out.println(dp[n][w]);
    }
}
