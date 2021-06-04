package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/4  10:24 上午
 * @description:
 */
public class CountLands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }


    /***
     * @params
     * @return
     * @description :深度优先搜索
     * 我们可以将二维网格看成一个无向图，竖直或水平相邻的 11 之间有边相连。
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，
     * 则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，
     * 每个搜索到的 11 都会被重新标记为 00。
     * 最终岛屿的数量就是我们进行深度优先搜索的次数。
    时间复杂度：O(MN)O(MN)，其中 MM 和 NN 分别为行数和列数。
    空间复杂度：O(MN)O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M NMN
     * @author tianyu.wang
     * @date 2021/6/4 10:31 上午
     */
    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIsLand = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIsLand;
                    dfs(grid, r, c);
                }
            }
        }
        return numIsLand;
    }

    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        System.out.println("nr:"+nr+" nc:"+nc+" r:"+r+" c:"+c);
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }


}
