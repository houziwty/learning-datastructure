package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/6/1  10:26 上午
 * @description: 统计关闭岛屿数量
 */
public class ClosedIsland {

    int grid[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    int val=1;
    public int closeIsland(int[][]grid){
        int closedLandNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    val = 1;
                    dfs(grid, i, j);
                    closedLandNum += val;
                }
            }
        }
        return closedLandNum;
    }
    void dfs(int [][]grid,int i,int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            val = 0;
            return;
        }
        if(grid[i][j] != 0) return;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
