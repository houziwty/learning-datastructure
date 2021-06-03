package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/3  7:08 下午
 * @description: 接雨水
 */
public class Trap {
    public static void main(String []args){
        int []nums={2,1,0,3,1,0,5,7,8};
        System.out.println(trap(nums));
    }

    /***
     * @params [height]
     * @return int
     * @description
     * 动态规划
     * 对于下标 ii，下雨后水能到达的最大高度等于下标 ii 两边的最大高度的最小值，下标 ii 处能接的雨水量等于下标 ii 处的水能到达的最大高度减去 \textit{height}[i]height[i]。
     *
     * 朴素的做法是对于数组 \textit{height}height 中的每个元素，分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。假设数组 \textit{height}height 的长度为 nn，该做法需要对每个下标位置使用 O(n)O(n) 的时间向两边扫描并得到最大高度，因此总时间复杂度是 O(n^2)O(n
     * 2
     *  )。
     *
     * 上述做法的时间复杂度较高是因为需要对每个下标位置都向两边扫描。如果已经知道每个位置两边的最大高度，则可以在 O(n)O(n) 的时间内得到能接的雨水总量。使用动态规划的方法，可以在 O(n)O(n) 的时间内预处理得到每个位置两边的最大高度。
     *
     * 创建两个长度为 nn 的数组 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax。对于 0 \le i<n0≤i<n，\textit{leftMax}[i]leftMax[i] 表示下标 ii 及其左边的位置中，\textit{height}height 的最大高度，\textit{rightMax}[i]rightMax[i] 表示下标 ii 及其右边的位置中，\textit{height}height 的最大高度。
     *
     * 显然，\textit{leftMax}[0]=\textit{height}[0]leftMax[0]=height[0]，\textit{rightMax}[n-1]=\textit{height}[n-1]rightMax[n−1]=height[n−1]。两个数组的其余元素的计算如下：
     *
     * 当 1 \le i \le n-11≤i≤n−1 时，\textit{leftMax}[i]=\max(\textit{leftMax}[i-1], \textit{height}[i])leftMax[i]=max(leftMax[i−1],height[i])；
     *
     * 当 0 \le i \le n-20≤i≤n−2 时，\textit{rightMax}[i]=\max(\textit{rightMax}[i+1], \textit{height}[i])rightMax[i]=max(rightMax[i+1],height[i])。
     *
     * 因此可以正向遍历数组 \textit{height}height 得到数组 \textit{leftMax}leftMax 的每个元素值，反向遍历数组 \textit{height}height 得到数组 \textit{rightMax}rightMax 的每个元素值。
     *在得到数组 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax 的每个元素值之后，对于 0 \le i<n0≤i<n，下标 ii 处能接的雨水量等于 \min(\textit{leftMax}[i],\textit{rightMax}[i])-\textit{height}[i]min(leftMax[i],rightMax[i])−height[i]。遍历每个下标位置即可得到能接的雨水总量。
    时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{height}height 的长度。计算数组 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax 的元素值各需要遍历数组 \textit{height}height 一次，计算能接的雨水总量还需要遍历一次。

    空间复杂度：O(n)O(n)，其中 nn 是数组 \textit{height}height 的长度。需要创建两个长度为 nn 的数组 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax。
     * @author tianyu.wang
     * @date 2021/6/3 7:10 下午
     */
    static int trap(int[] height) {
        int n=height.length;
        if(n==0){
            return 0;
        }
        int[]leftMax=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;++i){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        int []rightMax=new int [n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;--i){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;++i){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }


    /***
     * @params [height]
     * @return int
     * @description :
     * 双指针
     * 动态规划的做法中，需要维护两个数组 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax，因此空间复杂度是 O(n)O(n)。是否可以将空间复杂度降到 O(1)O(1)？
     *
     * 注意到下标 ii 处能接的雨水量由 \textit{leftMax}[i]leftMax[i] 和 \textit{rightMax}[i]rightMax[i] 中的最小值决定。由于数组 \textit{leftMax}leftMax 是从左往右计算，数组 \textit{rightMax}rightMax 是从右往左计算，因此可以使用双指针和两个变量代替两个数组。
     *
     * 维护两个指针 \textit{left}left 和 \textit{right}right，以及两个变量 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax，初始时 \textit{left}=0,\textit{right}=n-1,\textit{leftMax}=0,\textit{rightMax}=0left=0,right=n−1,leftMax=0,rightMax=0。指针 \textit{left}left 只会向右移动，指针 \textit{right}right 只会向左移动，在移动指针的过程中维护两个变量 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax 的值。
     *
     * 当两个指针没有相遇时，进行如下操作：
     *
     * 使用 \textit{height}[\textit{left}]height[left] 和 \textit{height}[\textit{right}]height[right] 的值更新 \textit{leftMax}leftMax 和 \textit{rightMax}rightMax 的值；
     *
     * 如果 \textit{height}[\textit{left}]<\textit{height}[\textit{right}]height[left]<height[right]，则必有 \textit{leftMax}<\textit{rightMax}leftMax<rightMax，下标 \textit{left}left 处能接的雨水量等于 \textit{leftMax}-\textit{height}[\textit{left}]leftMax−height[left]，将下标 \textit{left}left 处能接的雨水量加到能接的雨水总量，然后将 \textit{left}left 加 11（即向右移动一位）；
     *
     * 如果 \textit{height}[\textit{left}] \ge \textit{height}[\textit{right}]height[left]≥height[right]，则必有 \textit{leftMax} \ge \textit{rightMax}leftMax≥rightMax，下标 \textit{right}right 处能接的雨水量等于 \textit{rightMax}-\textit{height}[\textit{right}]rightMax−height[right]，将下标 \textit{right}right 处能接的雨水量加到能接的雨水总量，然后将 \textit{right}right 减 11（即向左移动一位）。
     *
     * 当两个指针相遇时，即可得到能接的雨水总量。

     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{height}height 的长度。两个指针的移动总次数不超过 nn。
     *
     * 空间复杂度：O(1)O(1)。只需要使用常数的额外空间。

     * @author tianyu.wang
     * @date 2021/6/3 7:10 下午
     */
   static int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }



}
