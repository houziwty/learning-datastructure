package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  2:15 下午
 * @description:预测赢家 给定一个表示分数的非负整数数组。
 * 玩家 1 从数组任意一端拿取一个分数，随后玩家
 * 2 继续从剩余数 组任意一端拿取分数，然后玩家 1 拿，...... 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可 取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最 大化。
 * 两个值的时候必然是取较大的，三个值，取一个能使自己分数和最大的，后手必然留较小的给先手，因
 * 此先手选一个值加上该较小值最大化
 */
public class PredWinner {
    public static void main(String[] args) {
        int nums[] = {1, 5, 233, 7};
        System.out.println(predictTheWinner(nums));
    }

    /***
     * @params [nums]
     * @return boolean
     * @description 方法一使用递归，存在大量重复计算，因此时间复杂度很高。由于存在重复子问题，因此可以使用动态规划降低时间复杂度。
     *
     * 定义二维数组 \textit{dp}dp，其行数和列数都等于数组的长度，\textit{dp}[i][j]dp[i][j] 表示当数组剩下的部分为下标 ii 到下标 jj 时，当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手。
     *
     * 只有当 i \le ji≤j 时，数组剩下的部分才有意义，因此当 i>ji>j 时，\textit{dp}[i][j]=0dp[i][j]=0。
     *
     * 当 i=ji=j 时，只剩一个数字，当前玩家只能拿取这个数字，因此对于所有 0 \le i < \textit{nums}.\text{length}0≤i<nums.length，都有 \textit{dp}[i][i]=\textit{nums}[i]dp[i][i]=nums[i]。
     *
     * 当 i<ji<j 时，当前玩家可以选择 \textit{nums}[i]nums[i] 或 \textit{nums}[j]nums[j]，然后轮到另一个玩家在数组剩下的部分选取数字。在两种方案中，当前玩家会选择最优的方案，使得自己的分数最大化。因此可以得到如下状态转移方程：
     *
     * \textit{dp}[i][j]=\max(\textit{nums}[i] - \textit{dp}[i + 1][j], \textit{nums}[j] - \textit{dp}[i][j - 1])
     * dp[i][j]=max(nums[i]−dp[i+1][j],nums[j]−dp[i][j−1])
     *
     * 最后判断 {dp}[0][\textit{nums}.\text{length}-1]dp[0][nums.length−1] 的值，如果大于或等于 00，则先手得分大于或等于后手得分，因此先手成为赢家，否则后手成为赢家。
     *
     * 时间复杂度：O(n^2)O(n
     * 2
     *  )，其中 nn 是数组的长度。需要计算每个子数组对应的 \textit{dp}dp 的值，共有 \frac{n(n+1)}{2}
     * 2
     * n(n+1)
     * ​
     *   个子数组。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是数组的长度。空间复杂度取决于额外创建的数组 \textit{dp}dp，如果不优化空间，则空间复杂度是 O(n^2)O(n
     * 2
     *  )，使用一维数组优化之后空间复杂度可以降至 O(n)O(n)。
     *
     * @author tianyu.wang
     * @date 2021/6/1 2:28 下午
     */
    static boolean predictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];

        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                //j = i +1 因此可以优化为一维数组,下标位置相同才有值，据此推导其他的值
                //Math.max(nums[i] - dp[j][j], nums[j] - dp[j - 1][j - 1]);
//{1, 5, 233, 7};
                System.out.print("i:" + i + " j:" + j );
                System.out.println("nums[i]: "+nums[i] +" "+" dp[i + 1][j]:"+ dp[i + 1][j]);
                System.out.println( "nums[j]: "+nums[j] +" "+" dp[i][j - 1]:"+dp[i][j - 1]);
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                System.out.println("i:" + i + " j:" + j + " " + dp[i][j]);

            }
        }
   


        System.out.println(dp[0][2]);
        return dp[0][length - 1] >= 0;
    }
}
