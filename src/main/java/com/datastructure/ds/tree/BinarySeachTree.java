package com.datastructure.ds.tree;

/**
 * @author : tianyu.wang
 * create at:  2021/4/19  5:54 下午
 * @description:二查搜索树
 */
public class BinarySeachTree {
    private int color=0;//0表示黑，1表示红

    int data ;

    BinarySeachTree left;

    BinarySeachTree right;

    BinarySeachTree parent;

    public  BinarySeachTree(int data){
        this.data = data;
        this.left = null;
        this.parent = null;
        this.color = 1;
        this.right = null;
        //parent.parent	;爷爷
        //parent.parent.left 左边的叔叔
        //parent.left 兄弟姐妹
    }
}
