package com.datastructure.ds.leetcode;

/**
 * @author : tianyu.wang
 * create at:  2021/5/25  4:04 下午
 * @description:省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
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
     * @description 解法一:深度优先 获取一个城市，通过递归找到离该城市最远的城市，标记为已访问，然后逐个向内进行标记
     * @author tianyu.wang
     * @date 2021/5/25 4:05 下午
     */
    static  int findCircleNum(int [][]isConnected){
        int provinces=isConnected.length;
        boolean []visited=new boolean[provinces];
        int circles=0;
        for(int i=0;i<provinces;i++){

        }

        return circles;
    }
    static  void dfs(){
        
    }
}
