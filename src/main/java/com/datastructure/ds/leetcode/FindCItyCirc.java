package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/5/25  4:04 下午
 * @description:省份数量 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相
 * 连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * 亲戚问题、朋友圈问题
 */
public class FindCItyCirc {


    /***
     * @params
     * @return
     * @description 解法一:深度优先 获取一个城市，
     * 通过递归找到离该城市最远的城市，标记为已访问，然后逐个向内进行标记
     * @author tianyu.wang
     * @date 2021/5/25 4:05 下午
     */
    static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }

        return circles;
    }

    //复杂度分析
    //
    //时间复杂度：O(n^2)O(n
    //2
    // )，其中 nn 是城市的数量。需要遍历矩阵 nn 中的每个元素。
    //
    //空间复杂度：O(n)O(n)，其中 nn 是城市的数量。需要使用数组 \textit{visited}visited 记录每个城市是否被访问过，数组长度是 nn，递归调用栈的深度不会超过 nn。
    //
    static void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    /***
     * @params
     * @return
     * @description 解法二:广度优先 获取一个城市，先标记与该城市直连的城市(最近的)，然后逐步向外扩散寻找
     * 时间复杂度：O(n^2)O(n
     * 2
     *  )，其中 nn 是城市的数量。需要遍历矩阵 \textit{isConnected}isConnected 中的每个元素。
     * @author tianyu.wang
     * @date 2021/5/27 8:13 下午
     */
    public int findCircleNumBFS(int[][] isConnected) {
        return 0;
    }

}
