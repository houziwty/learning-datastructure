package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  4:32 下午
 * @description:香槟塔
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个 玻璃杯(250ml)将盛有香槟。
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向
 * 左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。
 * (当最底层的玻璃杯满了，香槟会流到地板上)
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一 半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层 中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟
 *
 * }
 * int player1 = getScore(nums, 0, nums.size() - 1);
 * int player2 = sum - player1;
 * // 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家，所以是大于等于。 return player1 >= player2;
 *     //return getScore(nums, 0, nums.size() - 1) >=0 ;
 * }
 * //差值
 * int getScore(int[] nums, int start, int end) {
 *     if (end == start) {
 *         return nums[start];
 *     }
 *     int selectLeft = nums[start] - getScore(nums, start + 1, end);
 *     int selectRight = nums[end] - getScore(nums, start, end - 1);
 *     return max(selectLeft, selectRight);
 * }
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例(i 和 j都从0 开始)。
 */
public class ChampagneTower {

    /***
     * @params [poured, query_row, query_galss]
     * @return double
     * @description :
     * 我们可以直接模拟整个过程。我们记录流入每个杯子的香槟的数量之和，
     * 例如对于一个杯子，流入的香槟数量为 10。由于这个数值大于 1，因此会有 9 数量的香槟流出这个杯子，
     * 并且会有 4.5 数量的香槟分别流入这个杯子下面的两个杯子中。以此类推。
     *
     * 总的来说，如果流入一个杯子的香槟数量为 X，且 X 大于 1，
     * 那么就会有 Q = (X - 1.0) / 2 数量的香槟流入下面的两个杯子中。我们可以从第一层的杯子开始，
     * 计算出第二层每个杯子中流入的香槟数量，再计算出第三层的数量，直到计算到第 query_row 层。
     *时间复杂度：O(R^2)O(R
     * 2
     *  )，其中 RR 是杯子的层数。
     *
     * 空间复杂度：O(R^2)O(R
     * 2
     *  )。
     * @author tianyu.wang
     * @date 2021/6/1 4:36 下午
     */
    public double champagneTower(int poured,int query_row,int query_galss){
        double [][]A=new double[102][102];
        A[0][0]=poured;
        for(int r=0;r<=query_row;++r){
            for(int c=0;c<=r;++c){
                double q=(A[r][c]-1.0)/2.0;
                if(q>0){
                    A[r+1][c]+=q;
                    A[r+1][c+1]+=q;
                }
            }
        }
        return Math.min(1,A[query_row][query_galss]);
    }
}
