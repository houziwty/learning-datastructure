package com.datastructure.ds.tree;

import com.datastructure.ds.list.List;

import java.util.Map;

/**
 * @author : tianyu.wang
 * create at:  2021/4/29  6:48 下午
 * @description:
 */
public class HuffmenTree {
    HfmNode root;
    List<HfmNode>leafs;// 叶子节点
    Map<Character,Integer> weights; // 叶子节点的权重, a,b,c,d,e
}
